<template>
  <div class="app-container home">
      <div class="carou">
          <el-carousel arrow="always" :interval="2000" autoplay>
              <el-carousel-item v-for="(item, index) in carouselData" :key="index">
                  <img :src="item.url" alt="轮播图" class="carousel-image">
              </el-carousel-item>
          </el-carousel>
          <div style="font-size: 25px;margin-top: 40px">推荐
                <div>
                    <img src="" alt="">
                </div>
          </div>
      </div>
  </div>
</template>

<script setup>

import {ref} from 'vue';
import {getCourse} from '@/api/course/course';
const carouselData = ref([
    {url: 'https://tse4-mm.cn.bing.net/th/id/OIP-C.fK7K5Lvtke9pBIs-x0hN_wHaEY?w=290&h=180&c=7&r=0&o=5&pid=1.7'},
    {url: 'https://tse4-mm.cn.bing.net/th/id/OIP-C.3_oGuKFIx9tjtiymYgijWwHaEo?w=263&h=180&c=7&r=0&o=5&pid=1.7'},
    {url: 'https://tse3-mm.cn.bing.net/th/id/OIP-C.W89FVAuldBahnyfGq96HsAHaEK?w=306&h=180&c=7&r=0&o=5&pid=1.7'},
    {url: 'https://tse4-mm.cn.bing.net/th/id/OIP-C.eYHEu6KQghISczSpd2qixwHaEo?w=313&h=195&c=7&r=0&o=5&pid=1.7'},
])

getCourse().then(res=>{

});


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
        position: fixed;
        width: 50%;
        margin-left: 280px;
        margin-top: 120px;
    }

    .el-menu .el-menu-item:hover {
        outline: 0 !important;
        color: #2E95FB !important;
        background: linear-gradient(270deg, #F2F7FC 0%, #FEFEFE 100%) !important;
    }
}

@media (max-width: 600px) {
    header-title {
        display: none;
    }
}



</style>