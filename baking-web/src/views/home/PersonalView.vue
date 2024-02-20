<script setup>

</script>
<!--个人中心共有部分 左侧侧边栏-->
<template>
  <el-row :gutter="10" style="width: 1200px;margin: 0 auto;">
    <el-col :span="4">
      <el-card class="box-card" style="height: 100%;">
        <el-menu  active-text-color="orange" router default-active="/personal/info">
          <el-menu-item index="/personal/info">个人信息</el-menu-item>
          <el-menu-item index="/personal/management">稿件管理</el-menu-item>
        </el-menu>
      </el-card>
    </el-col>
    <el-col :span="20">
      <el-card class="box-card">
        <router-view/>
      </el-card>
    </el-col>
  </el-row>
</template>

<style scoped>

</style>