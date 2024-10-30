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
                    <el-menu-item index="/login">
                        <el-icon>
                            <House/>
                        </el-icon>
                        <span>首页</span>
                    </el-menu-item>
                    <el-menu-item index="/login">
                        <el-icon>
                            <DataLine/>
                        </el-icon>
                        <span>在线学习</span>
                    </el-menu-item>
                    <el-menu-item index="/login">
                        <el-icon>
                            <Notebook/>
                        </el-icon>
                        <span>我的课程</span>
                    </el-menu-item>
                    <el-menu-item index="/login">
                        <el-icon>
                            <Message/>
                        </el-icon>
                        <span>通知公告</span>
                    </el-menu-item>
                    <el-menu-item index="/login">
                        <el-icon>
                            <User/>
                        </el-icon>
                        <span>个人中心</span>
                    </el-menu-item>
                </el-menu>

            </div>

        </div>

    </div>
    <div class="carou">
        <el-carousel arrow="always" :interval="20000" autoplay>
            <el-carousel-item v-for="(item, index) in carouselData" :key="index">
                <img :src="item.url" alt="轮播图" class="carousel-image">
            </el-carousel-item>
        </el-carousel>
        <div style="font-size: 25px;margin-top: 40px">推荐


        </div>
    </div>

</template>


<script setup lang="ts">
import navbar from '../../layout/components/Navbar.vue'
import {ref} from 'vue';

const carouselData = ref([
    {url: 'https://pic.imgdb.cn/item/66f82947f21886ccc0add174.jpg'},
    {url: 'https://s21.ax1x.com/2024/10/27/pA0KZOP.png'},
    {url: 'https://pic.imgdb.cn/item/66f82947f21886ccc0add174.jpg'},
    {url: 'https://pic.imgdb.cn/item/661353f168eb935713534eb7.jpg'},
])


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
        right: 0;
        top: 0;
        width: calc(100vw - 200px);
        box-shadow: 0px 0px 2px rgba(0, 0, 0, 0.3);
    }
    .user-img {
        pointer-events:none;
        width: 40px;
        position: fixed;
        right: 48px;
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