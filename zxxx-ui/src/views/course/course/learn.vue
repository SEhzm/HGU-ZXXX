<template>
    <div class="card main">
        {{ data.courseName }}
        <div id="player"></div>
    </div>
</template>

<script setup>
import { ref, onMounted, watch, reactive, toRefs } from 'vue';
import { useRoute } from "vue-router";
import { getCourse } from '@/api/course/course';
import { listChapters, getChapters } from "@/api/course/chapters";
// 引入西瓜播放器

import "xgplayer/dist/index.min.css";
import Player from 'xgplayer';

const route = useRoute();
const courseId = ref(null);
const chapterId = ref(null);

const data = ref([]);
const chaptersList = ref([]);
const total = ref(0);
const loading = ref(true);
const videoUrl = ref('');

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
const { queryParams } = toRefs(courseChapters);

onMounted(async () => {
    const id = route.query.courseId;
    chapterId.value = route.query.chapterId;
    if (id) {
        courseId.value = id;
    }

    if (courseId.value) {
        await getCourseDetail(courseId.value);
        await listChapters(queryParams.value).then(response => {
            chaptersList.value = response.rows;
            total.value = response.total;
            loading.value = false;
        });
    }

    await getChapters(chapterId.value).then(res => {
        videoUrl.value = res.data.videoUrl.replace('https://', '');
        initializePlayer(videoUrl.value);
    });
});

const getCourseDetail = async (courseId) => {
    try {
        const res = await getCourse(courseId);
        data.value = res.data;
        // console.log(data.value.courseImg)
    } catch (error) {
    }
};

watch(videoUrl, (newUrl) => {
    if (newUrl) {
        initializePlayer(newUrl);
    }
});

const initializePlayer = (url) => {
    const player = new Player({
        id: 'player',
        url: `http://${url}`,
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
        playbackRate: [2, 1.5, 1.25, 1,0.75, 0.5], // 传入倍速可选数组
        rotateFullscreen: true,
    });
};
</script>

<style scoped>
@media (min-width: 601px) {
    .option-item{
        font-size: 20px;
    }
    .main {
        width: 1000px;
        margin: 20px;
    }
}
</style>
