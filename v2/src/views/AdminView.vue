<script setup>

</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <h1 style="background-color: #0aa1ed">后台管理系统</h1>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu router>
            <el-menu-item index="/admin/user">用户管理</el-menu-item>
            <el-menu-item index="/admin/banner">轮播图管理</el-menu-item>
            <el-menu-item index="/admin/product">商品管理</el-menu-item>
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