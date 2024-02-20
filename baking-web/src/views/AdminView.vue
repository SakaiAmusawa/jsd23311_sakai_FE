<script setup>

</script>
<!--管理系列页面-->
<template>
  <div class="common-layout">
    <el-container>
      <!--共有头部-->
      <el-header style="background-color: #368;line-height: 60px">
        <h1 style="color: white;font-size: 30px;margin: 0;">烘焙坊后台管理系统
          <el-button style="float: right;margin: 14px 0 0 5px;">退出登录</el-button>
          <span style="float: right;font-size: 20px">欢迎xxx回来</span>
        </h1>
      </el-header>
      <el-container>
        <!--共有左侧侧边栏-->
        <el-aside width="200px">
          <!--   此处的router 配合下面index的路径 起到点击跳转的效果       -->
          <el-menu router default-active="/admin/user" active-text-color="orange" style="height: 100%;">
            <img src="/imgs/icon.png" alt="" style="width: 150px;margin: 20px;">
            <el-menu-item index="/admin/user">
              <el-icon>
                <User/>
              </el-icon>
              用户管理
            </el-menu-item>
            <el-menu-item index="/admin/banner">
              <el-icon>
                <Picture/>
              </el-icon>
              轮播图管理
            </el-menu-item>
            <el-menu-item index="/admin/content">
              <el-icon>
                <ChatDotSquare/>
              </el-icon>
              内容管理
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>

</style>