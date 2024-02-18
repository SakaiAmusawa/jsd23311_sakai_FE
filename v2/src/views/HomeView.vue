<template>
  <div class="common-layout">
    <el-container>
      <el-header>共有的头部区域</el-header>
      <el-main>
        <!--   主体部分是可变区域     -->
        <router-view></router-view>
      </el-main>
      <el-footer>共有的尾部区域</el-footer>
    </el-container>
  </div>
</template>

<script setup>

</script>
