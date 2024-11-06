<template>
    <div>
        <div class="header">
            <div style="flex: 1">
                <div class="header-content">
                    <img src="@/assets/logo/logo.png" class="logo-img"/>
                    <b class="header-title">在线学习平台（圆桌组）</b>
                    <navbar class="navbar">
                    </navbar>
                    <img src="../../assets/images/profile.jpg" alt="" class="user-img"/>
                </div>
            </div>
        </div>


        <div class="main-content">
            <div class="sidebar">
                <el-menu router style=""
                         :default-openeds="['/home', '2']">
                    <el-menu-item @click="goToCourse">
                        <el-icon>
                            <House/>
                        </el-icon>
                        <span>首页</span>
                    </el-menu-item>
                    <el-menu-item @click="goToCourse">
                        <el-icon>
                            <DataLine/>
                        </el-icon>
                        <span>在线学习</span>
                    </el-menu-item>
                    <el-menu-item @click="goToCourse">
                        <el-icon>
                            <Notebook/>
                        </el-icon>
                        <span>我的课程</span>
                    </el-menu-item>
                    <el-menu-item @click="goToCourse">
                        <el-icon>
                            <Message/>
                        </el-icon>
                        <span>通知公告</span>
                    </el-menu-item>
                    <el-menu-item @click="goToCourse">
                        <el-icon>
                            <User/>
                        </el-icon>
                        <span>个人中心</span>
                    </el-menu-item>
                </el-menu>

            </div>

        </div>

    </div>
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
                    <el-button icon="Search" @click="goToCourse"/>
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
                    <el-tag effect="dark" round type="success" class="tag" style="color: black">{{ row.courseName }}</el-tag>
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
                    <el-tag effect="dark" round type="success" class="tag" style="color: black">{{ row.courseName }}</el-tag>
                    <el-tag effect="dark" round class="tag">{{ row.teacher }}
                    </el-tag>
                    <el-tag effect="dark" round class="shiny-gold-tag">精品课程</el-tag>
                    <span class="enrollment-date">{{ row.enrollmentDate }}</span>
                </div>
            </div>
        </div>
    </div>

</template>


<script setup lang="ts">
import navbar from '../../layout/components/Navbar.vue'
import {ref, reactive, onMounted} from 'vue';
import {getCourse,getHomeCourse} from '@/api/course/course';
import {useRouter} from "vue-router";
import { ElMessage, ElMessageBox } from 'element-plus'
const router = useRouter();
const homeCourseInfo = reactive({
    caruCourseId: [],
    findCourseId: [],
    recommendCourseId: []
})

const carouselData = reactive({
    caruCourseId: []
})
//跳转课程页面
const goToCourse = () => {
    // console.log(item)
    ElMessageBox.confirm('请先登录在学习喔🫡', '您未登录😯', {
        confirmButtonText: '去登录',
    }).then(() => {
        ElMessage({
            type: 'success',
            message: '请您登录🫡',
        })
        router.push(`/login`)
    })
        .catch(() => {
            ElMessage({
                type: 'info',
                message: '已取消',
            })
        })

}
const data = reactive({
    queryParams: {
        courseName: null,
    },
});
const {queryParams} = toRefs(data);
onMounted(async () => {
    await getHomeCourse().then(res => {
        homeCourseInfo.value = res.data;
        console.log(homeCourseInfo.value.recommendCourseId);
        carouselData.caruCourseId = homeCourseInfo.value.caruCourseId;
    });
})



</script>

<style lang="scss" scoped>
.carousel-image {
    width: 100%;
    height: 100%;
}

:deep .el-carousel__arrow i {
    font-size: 40px !important;
    /* 增大箭头 */
}

@media (min-width: 601px) {
    .searchInput {
        border-radius: 10px;
        box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.3);
        position: relative;
        width: 700px;
        margin-left: 380px;
        margin-top: 3em;
    }
    .home{
        margin-left: 200px;
    }
    :deep .el-carousel__indicators--horizontal { //轮播图指示器样式
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
        position: fixed;
        width: 50%;
        margin-left: 480px;
        margin-top: 120px;
    }
    .navbar {
        position: fixed;
        right: -7px;
        top: 0;
        width: calc(100vw - 200px);
        box-shadow: 0px 0px 2px rgba(0, 0, 0, 0.3);
    }
    .user-img {
        pointer-events:none;
        width: 40px;
        position: fixed;
        right: 41px;
        border-radius: 5px
    }
    .main-content {
        margin-top: 50px;
        position: fixed;
    }
    .el-menu {
        background-color: transparent !important;
    }

    .el-menu-item.is-active,
    .el-sub-menu .el-menu-item.is-active {
        background-color: rgba(255, 255, 255, 0.5) !important;
        color: black;
        border-radius: 5px;
    }

    .el-menu .el-menu-item:hover {
        outline: 0 !important;
        color: #2E95FB !important;
        background: linear-gradient(270deg, #F2F7FC 0%, #FEFEFE 100%) !important;
    }


    .header {
        position: fixed;
        height: 50px;
        opacity: 1;
        display: flex;
        align-items: center;
    }

    .header-content {
        height: 50px;
        width: 200px;
        background-color: #ffffff;
        display: flex;
        align-items: center;
    }


    .header-title {
        font-size: 14px;
        align-items: center;
    }

    .sidebar {
        width: 200px;
        box-shadow: -1px 20px 20px 0px rgba(0, 0, 0, 0.35);
        height: calc(100vh + 20px);
    }

    .content {
        flex: 1;
        width: 0;
        padding: 0px;
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
        cursor: pointer;
        position: relative;
        width: 900px;
        margin-left: 280px;
        margin-top: 60px;
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
    .user-img {
        display: none;
    }
    .sidebar {
        display: none;
    }

    .header {
        background-color: #fff;
        display: flex;
        align-items: center;
        border-bottom: 1px solid #ddd;
    }


    header-title {
        display: none;
    }
}
</style>