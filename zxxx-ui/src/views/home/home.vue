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
        <el-menu router style=""
                 :default-openeds="['/home', '2']" :collapse="appStore.sidebar.opened">
          <el-menu-item index="/home">
            <el-icon>
              <HomeFilled/>
            </el-icon>
            <span>首页</span>
          </el-menu-item>
          <el-menu-item index="/home">
            <el-icon>
              <HomeFilled/>
            </el-icon>
            <span>在线学习</span>
          </el-menu-item>
          <el-menu-item index="/home">
            <el-icon>
              <HomeFilled/>
            </el-icon>
            <span>我的课程</span>
          </el-menu-item>
          <el-menu-item index="/home">
            <el-icon>
              <HomeFilled/>
            </el-icon>
            <span>通知公告</span>
          </el-menu-item>
          <el-menu-item index="/index">
            <el-icon>
              <HomeFilled/>
            </el-icon>
            <span>个人中心</span>
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