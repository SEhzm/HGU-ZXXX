<template>
    <div class="el-footer">
        基于腾讯云服务器搭建<text style="font-size: 11px">(离服务器到期还有{{ ServerDate }}天)</text>
        <text> 域名所有：<a href="https://yuba.douyu.com/user/main/lOdEpeOJzwnR"
                           target="_blank">@瓜瓜的御用攻城狮</a></text>&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
</template>

<style scoped>
.el-footer {
    pointer-events: none; /* 禁用事件处理 */
    z-index: 200;
    height: 40px;
    line-height: 40px;
    position: fixed;
    bottom: 0;
    width: 100% !important;
    text-align: center;
    font-family: Arial;
    font-size: 14px;
    letter-spacing: 1px;
    margin-left: -153px;
}
.el-footer a {
    pointer-events: auto;
}


</style>