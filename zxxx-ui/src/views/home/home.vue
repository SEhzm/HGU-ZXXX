<template>

  <div>

    <div class="header">
      <div style="flex: 1">
        <div class="header-content">
          <img src="@/assets/logo/logo.png" class="logo-img"/>
          <b class="header-title">在线学习平台1（圆桌组）</b>
          <navbar style="position: fixed;right: 0;top: 0;width: calc(100vw - 200px);box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.3);;"></navbar>
        </div>
      </div>
    </div>

    <div class="main-content">
      <div class="sidebar">
        <el-menu router style="border: none; margin-right: auto" :default-active="$route.path"
                 :default-openeds="['/home', '2']" :collapse="isCollapse">
          <el-menu-item index="/home">
            <el-icon>
              <HomeFilled/>
            </el-icon>
            <span>首页</span>
          </el-menu-item>


        </el-menu>
      </div>
      <div class="content">
        <router-view/>
      </div>
    </div>
  </div>

</template>


<script setup lang="ts">
import navbar from '../../layout/components/Navbar.vue'
</script>

<style lang="scss" scoped>

@media (min-width: 601px) {

.main-content{
  margin-top: 50px;
  position: fixed;
}
  .el-menu {
    background-color: transparent !important;
  }

  .el-menu-item,
  .el-sub-menu .el-menu-item {
    color: black;
    background-color: transparent !important;
    border-radius: 5px;
  }


  .el-menu-item.is-active,
  .el-sub-menu .el-menu-item.is-active {
    background-color: rgba(255, 255, 255, 0.5) !important;
    color: black;
    border-radius: 5px;
  }

  .el-menu.el-menu--vertical.v-enter-to {
    background-color: rgba(255, 255, 255, 0) !important;
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
    box-shadow: 2px -220px 6px rgba(0, 21, 41, 0.35);
    height: 50px;
    width: 200px;
    background-color: #ffffff;
    display: flex;
    align-items: center;
  }

  .logo-img {
    float: left;
  }

  .header-title {
    font-size: 14px;
    align-items: center;
  }


  .icon-img {
    width: 31px;
    margin-right: 15px;
  }


  .sidebar {
    width: 200px;
    box-shadow: 2px 0px 6px rgba(0, 21, 41, 0.35);
    height: calc(100vh + 20px);
  }

  .collapse-button {
    margin-top: 2%;
    align-content: center;
    width: 96%;
    margin-left: 2%;
  }

  .menu-icon {
    height: 18px;
    margin-right: 10px;
  }

  .content {
    flex: 1;
    width: 0;
    padding: 10px;
  }
}

@media (max-width: 600px) {
  .hotBarrageSpan {
    color: #e4d6b8;
    border-bottom: 1px solid #e4d6b8;
    padding-bottom: 1px;
  }

  .el-overlay-dialog {
    z-index: 3;
  }

  .el-dialog {
    width: 100vw;
  }

  .hotBarrage {
    position: absolute;
    margin-top: 85px;
    left: 30px;
    z-index: 1;
    color: #e4d6b8;
  }

  .hotBarrageImg {
    z-index: 1;
    top: 85px;
    position: absolute;
    left: 2px;
  }

  .fade-enter-active,
  .fade-leave-active {
    transition: opacity 0.5s;
  }

  .fade-enter-from,
  .fade-leave-to {
    opacity: 0;
  }

  .QueryTable {
    padding: 20px;
    z-index: 1000;
    position: absolute;
    width: 100%;
    background-color: white;
    border-radius: 10px;
    right: 0px;
    box-shadow: 0px 0px 35px rgb(37, 19, 19);
  }

  .el-image-viewer__img {
    height: 100px;
    width: 100px;
  }

  .el-image-viewer__mask {
    height: 100px;
    width: 100px;
  }

  .icon-img-rounded {
    margin-top: 5px;
    width: 20px;
    height: 20px;
    border-radius: 5px;
    margin-right: 5px;
  }

  .complaint-button {
    width: 95px;
    height: 30px;
    font-size: 12px;
  }

  .icon-img {
    margin-top: 5px;
    height: 20px;
    width: 20px;
    margin-right: 5px;
  }

  .sidebar {
    display: none;
  }

  .header-actions {
    display: flex;
    justify-content: flex-end;
    margin-left: 0;
  }

  .header {
    background-color: #fff;
    display: flex;
    align-items: center;
    border-bottom: 1px solid #ddd;
  }

  .logo-link {
    display: none;
  }

  header-title {
    display: none;
  }

  //移动端
  .tab {
    display: flex;
    overflow-x: scroll;
    white-space: nowrap;
    scrollbar-width: none; // 确保 Firefox 也隐藏滚动条
    -ms-overflow-style: none; // IE 和 Edge
    -webkit-overflow-scrolling: touch; // 启用原生滚动效果
    touch-action: pan-x; // 允许水平滚动，阻止其他触摸行为
  }

  .tab-container {
    display: flex;
    flex-wrap: nowrap;
    width: 100%;
  }

  .tab1 {
    position: relative;
    white-space: nowrap;
    padding: 10px 5px;
    margin-right: 10px;
    border-radius: 15px 15px 0 0;
    transition: all 0.3s ease;
    font-size: 14px;
    color: #000000;
    background-color: #fff;
    flex-shrink: 0; // 防止缩小
    touch-action: pan-x;
  }

  .tab1::before {
    content: "";
    position: absolute;
    left: 0;
    width: 100%;
    background-color: transparent;
    transition: all 0.3s ease;
  }

  .none {
    background-color: #93a2b9;
    padding: 10px;
  }

  .tab1:hover,
  .selected {
    color: #fff;
    background-color: #007bff;


    &::before {
      background-color: #007bff;
    }

    padding-left: 15px; /* 左侧 padding 增加 10px */
    padding-right: 15px; /* 右侧 padding 增加 10px */
  }

  .tab::-webkit-scrollbar {
    /* Webkit browsers (Chrome, Safari) */
    height: 8px;
  }

  .tab::-webkit-scrollbar-track {
    background: transparent;
  }

  .tab::-webkit-scrollbar-thumb {
    background-color: rgba(0, 0, 0, 0.2);
    border-radius: 10px;
  }

  //移动端

}
</style>