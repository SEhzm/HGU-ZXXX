<template>
    <div class="card text-main">
        <span style="font-size: 25px;margin: 15px">{{ data.courseName }}</span>
        <span style="font-size: 25px">{{ chapterInfo.chapterTitle }}</span>
        <el-tag round size="large" style="margin-left: 30px;font-size: 16px">讲师：{{ data.teacher }}</el-tag>
        <el-tag type="info" style="margin-left: 50px">类别：{{ courseCategory }}</el-tag>
    </div>
    <div class="main card">
        <div id="player"></div>
        <div class="card chat">
            聊天区
        </div>
    </div>
    <div class="chaptersSelect">
        <div class="card chapters">
            <span style="font-size: 21px;font-family: 黑体">章节选择</span>
            <el-table :data="courseData.tableData" style="width: 900px;cursor:pointer" @row-click="jumpToChapter">
                <el-table-column prop="chapterTitle" label="章节标题" width="150"/>
                <el-table-column show-overflow-tooltip prop="chapterDescription" label="章节描述" width="700"/>
                <!--                <el-table-column show-overflow-tooltip prop="chapterDescription" label="章节描述" width="50" />-->
            </el-table>
        </div>
        <div style="width: 40px"><!--  占位置的div  --></div>
        <div class="card course-introduction"><span style="font-size: 20px">课程简介</span>
            <p>{{ data.courseDescription }}</p>
        </div>
    </div>
</template>

<script setup>
import {ref, onMounted, watch, reactive, toRefs, computed} from 'vue';
import {useRoute, useRouter} from "vue-router";
import {getCourse} from '@/api/course/course';
import {listChapters, getChapters} from "@/api/course/chapters";
// 引入西瓜播放器

import "xgplayer/dist/index.min.css";
import Player from 'xgplayer';

const {proxy} = getCurrentInstance();
const {course_category} = proxy.useDict('course_category');
const route = useRoute();
const courseId = ref(null);
const chapterId = ref(null);
const courseCategory = ref(null);
const router = useRouter();
const data = ref({});
const chaptersList = ref([]);
const total = ref(0);
const loading = ref(true);
const videoUrl = ref('');
const chapterInfo = ref({});

const courseData = reactive({
    tableData: [],
})

const courseChapters = reactive({
    queryParams: {
        pageNum: 1,
        pageSize: 10,
        courseId: null,
        chapterTitle: null,
        chapterDescription: null,
        videoUrl: "",
        position: null,
        createdAt: null,
        updatedAt: null
    },
});
const {queryParams} = toRefs(courseChapters);

onMounted(async () => {
    const id = route.query.courseId;
    chapterId.value = route.query.chapterId;
    courseId.value = id;
    await getCourseDetail(courseId.value);
    //获取章节列表
    await listChapters(queryParams.value).then(response => {
        courseData.tableData = response.rows;
        console.log(courseData.tableData)
        chaptersList.value = response.rows;
        total.value = response.total;
        loading.value = false;
    });

    // 获取章节视频
    await getChapters(chapterId.value).then(res => {
        chapterInfo.value = res.data;
        videoUrl.value = res.data.videoUrl.replace('https://', '');
        initializePlayer(videoUrl.value);
    });
    courseCategory.value = handleIndexType(data.value.courseCategory);

});


/**
 * 作用：从course_category字典里选出与data对应的label显示
 * 注意：如果这个函数最后返回的是undefined,undefined在模板上是不显示的
 */
const handleIndexType = (data) => {
    return course_category.value.find((item) => {
        return item.value === data;
    })?.label;
};

//跳转到新章节
const jumpToChapter = (row) => {
    // console.log(row.courseId);
    // console.log(row.chapterId);

    router.push(`/study/learn?courseId=${row.courseId}&chapterId=${row.chapterId}`);
}

//获取课程详情
const getCourseDetail = async (courseId) => {
    try {
        const res = await getCourse(courseId);
        data.value = res.data;
    } catch (error) {
    }
};

watch(videoUrl, (newUrl) => {
    if (newUrl) {
        initializePlayer(newUrl);
    }
});
//西瓜视频播放器
const initializePlayer = (url) => {
    const player = new Player({
        id: 'player',
        url: `http://${url}`,
        width: 1000,
        height: 525,
        autoplay: false,
        poster: `${data.value.courseImg}`, // 封面图
        lang: "zh-cn", // 设置中文
        lastPlayTime: 0, // 视频起播时间（单位：秒）
        lastPlayTimeHideDelay: 5, // 提示文字展示时长（单位：秒）
        closeVideoClick: false, // true - 禁止pc端单击暂停，反之
        closeVideoTouch: true, // true - 禁止移动端单击暂停，反之
        fluid: true, // 填满屏幕
        loop: false, // 循环播放
        pip: true,
        volume: 0.5, // 音量 0 -  1
        playbackRate: [2, 1.5, 1.25, 1, 0.75, 0.5], // 传入倍速可选数组
        rotateFullscreen: true,
    });
};
</script>
<style scoped>@media (min-width: 601px) {
    #player {
        width: 1000px;
        height: 591px;
    }

    .text-main {
        margin: 20px 50px;
    }

    .main {
        display: flex;
        align-items: flex-start;
        width: 1000px;
        margin: 20px 50px;
    }

    .chat {
        width: 400px;
        position: absolute;
        margin-left: 1020px;
    }

    .chaptersSelect {
        display: table;
        margin: 20px 50px;
        width: 1400px
    }

    .chapters {
        display: table-cell;
        height: 200px;
        width: 1110px;

    }

    .course-introduction {
        display: table-cell;
        width: 400px;
    }
}
</style>
