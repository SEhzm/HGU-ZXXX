<template>
    <div class="course-all" >
        <img :src=data.courseImg alt="" class="course-img">
        <div class="course-info">
            <span style="font-size: 30px">{{ data.courseName }}</span>
            <span style="margin-left: 500px;font-size: 20px">授课教师：<b>{{ data.teacher }}</b></span>
            <br>
            <p>开课时间：{{ data.createdAt }}</p>
            <br>
            <p>学习方式：在线学习</p>
            <el-button type="primary" style="margin-top: 100px;margin-left: 20px">立即学习</el-button>

        </div>


    </div>

    <div class="course-jianjie card">
        <p style="font-size: 20px;width: 100px;">课程简介</p><br><br>
        <p>{{ data.courseDescription }}</p>
    </div>
</template>

<script setup>
import {ref, onMounted, watch} from 'vue';
import {useRoute} from "vue-router";
import {getCourse} from '@/api/course/course';

const route = useRoute();
const courseId = ref(null);

const data = ref([]);

onMounted(async () => {
    // 获取查询参数中的 courseId
    const id = route.query.courseId;
    if (id) {
        courseId.value = id;
    }
    // 在 courseId 被初始化后调用 getCourseDetail
    if (courseId.value) {
        await getCourseDetail(courseId.value);
    }
});

const getCourseDetail = async (courseId) => {
    try {
        const res = await getCourse(courseId);
        data.value = res.data;
        // console.log(data)
        // 处理响应数据
    } catch (error) {
    }
};

// // 监听 courseId 的变化
watch(courseId, (newId) => {
    if (newId) {
        getCourseDetail(newId);
    }
});
</script>

<style scoped>
@media (min-width: 601px) {
    .course-jianjie{
        width: 1000px;
        margin-left: 100px;
        margin-top: 50px;
    }
    .course-all{
        display: flex;
    }
    .course-img {
        background-color: #fff;
        border-radius: 10px;
        padding: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,.2);
        margin-left: 100px;
        margin-top: 100px;
        width: 500px;
    }

    .course-info {
        background-color: #fff;
        border-radius: 10px;
        padding: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,.2);
        width: 1000px;
        margin-left: 50px;
        margin-top: 100px;

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