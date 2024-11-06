<template>
    <div class="app-container home">
        <div class="searchInput">
            <el-input
                clearable
                size="large"
                v-model="queryParams.courseName"
                placeholder="请输入课程.."
                class="input-with-select"
            >
                <template #append>
                    <el-button icon="Search" @click="searchCourse"/>
                </template>
            </el-input>
        </div>
        <div class="carou">
            <el-carousel arrow="always" :interval="2000" autoplay>
                <el-carousel-item v-for="(item, index) in carouselData.caruCourseId" :key="index"
                                  @click="goToCourse(item.courseId)">
                    <img :src="item.courseImg" alt="轮播图" class="carousel-image">
                </el-carousel-item>
            </el-carousel>
        </div>
        <!--        推荐课程-->
        <p style="margin-left: 150px;font-size: 25px;font-family: 'Microsoft YaHei';">推荐课程</p>
        <div class="course-list">
            <div v-if="homeCourseInfo.value && homeCourseInfo.value.caruCourseId"
                 v-for="(row, index) in homeCourseInfo.value.caruCourseId" :key="index"
                 @click="goToCourse(row.courseId)"
                 class="course-box" :style="{ backgroundImage: `url(${row.courseImg})` ,opacity:0.9}">
                <div style="display: flex">
                    <el-tag effect="dark" round type="success" class="tag" style="color: black">{{
                            row.courseName
                        }}
                    </el-tag>
                    <el-tag round class="tag">{{ row.teacher }}</el-tag>
                    <span class="enrollment-date">{{ row.enrollmentDate }}</span>
                </div>
            </div>
        </div>
        <!--        精品课程-->
        <p style="margin-left: 150px;font-size: 25px;font-family: 'Microsoft YaHei';">精品课程</p>
        <div class="course-list">
            <div v-if="homeCourseInfo.value && homeCourseInfo.value.findCourseId"
                 v-for="(row, index) in homeCourseInfo.value.findCourseId" :key="index"
                 @click="goToCourse(row.courseId)"
                 class="course-box" :style="{ backgroundImage: `url(${row.courseImg})` ,opacity:0.9}">
                <div style="display: flex">
                    <el-tag effect="dark" round type="success" class="tag" style="color: black">{{
                            row.courseName
                        }}
                    </el-tag>
                    <el-tag effect="dark" round class="tag">{{ row.teacher }}
                    </el-tag>
                    <el-tag effect="dark" round class="shiny-gold-tag">精品课程</el-tag>
                    <span class="enrollment-date">{{ row.enrollmentDate }}</span>
                </div>
            </div>
        </div>
    </div>

    <el-dialog v-model="dialogTableVisible" title="搜索到的课程" width="1600">
        <div class="course-list">
            <div v-if="searchCourseData.Course.rows"
                 v-for="(row, index) in searchCourseData.Course.rows" :key="index"
                 @click="goToCourse(row.courseId)"
                 class="course-box" :style="{ backgroundImage: `url(${row.courseImg})` ,opacity:0.9}">
                <div style="display: flex">
                    <el-tag effect="dark" round type="success" class="tag" style="color: black">{{
                            row.courseName
                        }}
                    </el-tag>
                    <el-tag round class="tag">{{ row.teacher }}</el-tag>
                    <span class="enrollment-date">{{ row.enrollmentDate }}</span>
                </div>
            </div>
        </div>
    </el-dialog>
</template>

<script setup>

import {onMounted, reactive, ref} from 'vue';
import {listCourse} from '@/api/course/course';
import {getHomeCourse} from "../api/course/course.js";
import {useRouter} from "vue-router";

const dialogTableVisible = ref(false)
const router = useRouter();
const homeCourseInfo = reactive({
    caruCourseId: [],
    findCourseId: [],
    recommendCourseId: []
})
const searchCourseData = reactive({
    Course: []
})
const carouselData = reactive({
    caruCourseId: []
})
const data = reactive({
    queryParams: {
        courseName: null,
    },
});

const {queryParams} = toRefs(data);
//跳转课程页面
const goToCourse = (courseId) => {
    // console.log(item)
    router.push(`/study/show?courseId=${courseId}`)
}
const searchCourse = () => {
    listCourse(queryParams.value).then(res => {
        searchCourseData.Course = res
        dialogTableVisible.value = true
        console.log(searchCourseData.Course)
    })
}
onMounted(async () => {
    await getHomeCourse().then(res => {
        homeCourseInfo.value = res.data;
        // console.log(homeCourseInfo.value.recommendCourseId);
        carouselData.caruCourseId = homeCourseInfo.value.caruCourseId;
    });
})


</script>
<style lang="scss" scoped>
.carousel-image {

    width: 100%;
    height: 100%;
}

:deep .el-carousel__arrow i { /* 增大箭头 */
    font-size: 40px !important;
}

@media (min-width: 601px) {
    .searchInput {
        border-radius: 10px;
        box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.3);
        position: relative;
        width: 700px;
        margin-left: 380px;
        margin-top: 10px;
    }
    .tag {
        margin-left: 30px;
        margin-top: 10px;
        font-size: 18px;
        font-weight: 600;
    }
    .course-list {
        color: black;
        width: 1500px;
        margin-left: 100px;
        margin-top: 15px;
        display: flex;
        flex-wrap: wrap;
        justify-content: flex-start;
    }
    .course-box {
        display: flex;
        cursor: pointer;
        color: #FFFFFF;
        margin-left: 50px;
        width: 400px;
        height: 200px;
        border: 1px solid #ccc;
        margin-bottom: 50px;
        border-radius: 8px;
        background-size: cover;
        background-position: center;
    }

    .course-content {
        margin-left: 20px;
        align-items: center;
    }
    :deep .el-carousel__indicators--horizontal {
        position: absolute;
        text-align: right;

        .el-carousel__indicator--horizontal button {
            width: 10px;
            height: 10px;
            background: #ffffff;
            border-radius: 50%;
            opacity: 0.7;
        }

        .el-carousel__indicator--horizontal.is-active button {
            width: 30px;
            height: 8px;
            background: #ffffff;
            opacity: 0.8;
            border-radius: 10px;
        }
    }

    .carou {
        box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.6);
        cursor: pointer;
        position: relative;
        width: 900px;
        margin-left: 280px;
        margin-top: 30px;
    }

    .el-menu .el-menu-item:hover {
        outline: 0 !important;
        color: #2E95FB !important;
        background: linear-gradient(270deg, #F2F7FC 0%, #FEFEFE 100%) !important;
    }
    .shiny-gold-tag {
        border: 0px;
        color: black; /* 将字体颜色设置为黑色 */
        margin-left: 30px;
        margin-top: 10px;
        font-size: 17px;
        padding: 5px 10px;
        border-radius: 5px;
        background-image: linear-gradient(45deg, #FFD700, #FFAA00, #FFFF99, #FFEE00);
        background-size: 200% 200%;
        animation: gradientShift 3s ease-in-out infinite; /* 仅保持渐变动画 */
        font-weight: 700;
    }

    /* 渐变背景平滑移动 */
    @keyframes gradientShift {
        0% {
            background-position: 0% 50%;
        }
        100% {
            background-position: 100% 50%;
        }
    }
}

@media (max-width: 600px) {
    header-title {
        display: none;
    }
}


</style>