<template>
    <div class="course-all">
        <img :src=data.courseImg alt="" class="course-img">
        <div class="course-info">
            <span style="font-size: 30px;margin-left: 20px">{{ data.courseName }}</span>
            <span style="margin-left: 400px;font-size: 20px;white-space: nowrap">授课教师：<b>{{
                    data.teacher
                }}</b></span>
            <br><br>
            <p>开课时间：{{ data.createdAt }}</p>
            <br><br>
            <p>学习方式：在线学习</p>
            <p style="margin-left: 550px;white-space: nowrap">已有 {{ courseStudyTotal }} 人学习</p>
            <el-button type="success" class="study-btn" @click="navigateToLearn(data.courseId)">立即学习</el-button>
        </div>


    </div>

    <div class="course-jianjie card">
        <p style="font-size: 20px;width: 100px;">课程简介</p><br><br>
        <p>{{ data.courseDescription }}</p>
    </div>
</template>

<script setup>
import {ref, onMounted, watch, reactive} from 'vue';
import {useRoute, useRouter} from "vue-router";
import {getCourse} from '@/api/course/course';
import {getChaptersIdByCourseId,getCourseStudyTotal} from '@/api/course/enrollments';
import {getChaptersInfoByChapterId} from "../../../api/course/chapters.js";
import { ElMessage } from 'element-plus';


const route = useRoute();
const router = useRouter();
const courseId = ref(null);
const chapterId = ref(null);
const courseStudyTotal=ref(null)
const data = ref({});
const enrollmentInfo = ref([]);
const chapterInfo = ref([]);


onMounted(async () => {
    // 获取查询参数中的 courseId
    const id = route.query.courseId;
    if (id) {
        courseId.value = id;
    }
    // 在 courseId 被初始化后调用 getCourseDetail
    if (courseId.value) {
        await getCourseDetail(courseId.value);
        await getChaptersIdByCourseId(courseId.value).then(res => {
            enrollmentInfo.value = res.rows;
            chapterId.value = enrollmentInfo.value[0].chapterId;
            // console.log(chapterId.value)
        });
        await getChaptersInfo(chapterId.value);
        await getCourseStudyTotal(courseId.value).then(res=>{
            courseStudyTotal.value = res.data
        })

    }else {
        router.push(`/study/details`)
        ElMessage({
            message: '请从选课记录进入',
            type: 'warning',
        })
    }
})

//获取课程详情
const getCourseDetail = async (courseId) => {
    try {
        const res = await getCourse(courseId);
        data.value = res.data;
        // console.log(data)
        // 处理响应数据
    } catch (error) {
    }
};
// 获取章节详情
const getChaptersInfo = async (chapterId) => {
    try {
        const res = await getChaptersInfoByChapterId(chapterId);
        chapterInfo.value = res.data;
        console.log(chapterInfo)
        // 处理响应数据
    } catch (error) {
        // console.log(error)
    }
};
const navigateToLearn = (courseId) => {
    router.push(`/study/learn?courseId=${courseId}&chapterId=${chapterId.value}`);
};
// // 监听 courseId 的变化
// watch(courseId, (newId) => {
//     if (newId) {
//         getCourseDetail(newId);
//     }
// });
</script>

<style scoped>
@media (min-width: 601px) {
    .course-jianjie {
        width: 1000px;
        margin-left: 100px;
        margin-top: 50px;
    }

    .study-btn {
        width: 150px;
        height: 50px;
        margin-top: 20px;
        margin-left: 20px;
        font-size: 20px;
        border-radius: 50px;
    }

    .course-all {
        display: flex;
    }

    .course-img {
        background-color: #fff;
        border-radius: 10px;
        padding: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, .2);
        margin-left: 100px;
        margin-top: 50px;
        width: 500px;
    }

    .course-info {
        background-color: #fff;
        border-radius: 10px;
        padding: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, .2);
        width: 800px;
        margin-left: 50px;
        margin-top: 50px;

    }
}

@media (max-width: 600px) {
    .course-img {
        width: 100vw;

    }

    .course-info {

    }
}

</style>