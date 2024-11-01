<template>
    <p style="padding: 20px;margin-left: 30px;font-size: 18px">我的选课</p>
    <div class="course-list">
        <div v-for="(row, index) in enrollmentsList" :key="index" @click="navigateToCourse(row.courseId,row.chapterId)"
             class="course-box">
            <div>
                <p style="padding: 10px;margin-left: 20px; font-size: 20px">{{ row.courseName }}</p>
                <br><br><br><br>
                <span class="course-content">
                    <img src="@/assets/svg/teacher.svg" style="">：{{ row.teacher }}
                </span>
                <span class="enrollment-date">{{ row.enrollmentDate }}</span>
            </div>
        </div>
    </div>

</template>

<script setup>
import {myListEnrollments} from "@/api/course/enrollments";
import {ref, reactive} from 'vue';
import {useRouter} from "vue-router";

const router = useRouter();


const enrollmentsList = ref([]);
const loading = ref(true);

const total = ref(0);

const data = reactive({
    form: {},
    queryParams: {
        pageNum: 1,
        pageSize: 10,
        courseId: null,
        userId: null,
        enrollmentDate: null,
        chapterId: null,
        courseStatus: null
    },
    rules: {}
});

function getList() {
    loading.value = true;
    myListEnrollments(data.queryParams.value).then(response => {
        enrollmentsList.value = response.rows;
        total.value = response.total;
        loading.value = false;
    });
}

getList();
/**
 * 跳转页面
 * @param courseId
 */
const navigateToCourse = (courseId,chapterId) => {
    router.push(`/study/show?courseId=${courseId}&chapterId=${chapterId}`)
};

</script>

<style scoped>
.course-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: flex-start;
}

.course-box {
    cursor: pointer;
    color: #FFFFFF;
    margin-left: 50px;
    width: 350px;
    height: 150px;
    border: 1px solid #ccc;
    margin-bottom: 50px;
    border-radius: 8px;
    background: linear-gradient(135deg, #3C8CE7 0%, #BEDEC0 100%);
}

.course-content {
    margin-left: 20px;
    align-items: center;
}

.enrollment-date {
    margin-left: 150px;
}

</style>