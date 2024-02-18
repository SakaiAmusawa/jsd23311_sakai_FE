<template>
  <h1>菜单组件</h1>
  <!-- mode="horizontal"修改为横置的模式 默认是垂直的vertical -->
  <!--handleSelect是调用组件内部的功能，我们这里只需要写方法名就可以了  -->
  <el-menu mode="horizontal" @select="handleSelect">
    <!--菜单项的index必须是唯一的!-->
    <el-menu-item index="1">首页</el-menu-item>
    <el-menu-item index="2">免费课</el-menu-item>
    <el-menu-item index="3">直播课</el-menu-item>
    <el-menu-item index="4">线上班</el-menu-item>
    <el-menu-item index="5">脱产班</el-menu-item>
    <!--el-sub-menu添加子菜单    -->
    <el-sub-menu index="6">
      <!--非文字部分都需要使用template包裹 #title表示这里是菜单项的名字-->
      <template #title>关于我们</template>
      <el-menu-item index="6-1">联系方式</el-menu-item>
      <el-menu-item index="6-2">求职招聘</el-menu-item>
      <el-menu-item index="6-3">公司地址</el-menu-item>
    </el-sub-menu>
  </el-menu>

  <!--侧边栏  -->
  <el-menu active-text-color="#f00" background-color="#0aa1ed"
           style="width: 300px;" text-color="#fff">
    <el-menu-item index="1">魏国</el-menu-item>
    <el-sub-menu index="2">
      <template #title>蜀国</template>
      <el-menu-item index="2-1">联系方式</el-menu-item>
      <el-menu-item index="2-2">求职招聘</el-menu-item>
      <el-menu-item index="2-3">公司地址</el-menu-item>
    </el-sub-menu>
    <el-menu-item index="3">吴国</el-menu-item>
  </el-menu>
</template>

<script setup>
//index表示当前点击的是哪个菜单项 5 或 6-2
//indexPath表示如何到达选中的菜单项5 或 6,6-2,6-2-4
import {ElMessage} from "element-plus";

const handleSelect = (index, indexPath) => {
  console.log(index + "********" + indexPath);
  if (index == 3) {
    ElMessage.success("点击了直播课~");
  }
}
</script>

<style scoped>

</style>