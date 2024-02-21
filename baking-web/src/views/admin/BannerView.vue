<script setup>

import {ref} from "vue";
import {ElMessage} from "element-plus";

const arr = ref([
  {imgUrl: '/imgs/banner1.jpg', createTime: '2024年02月20日 10:48:50'},
  {imgUrl: '/imgs/banner2.jpg', createTime: '2024年02月20日 10:48:50'},
  {imgUrl: '/imgs/banner3.jpg', createTime: '2024年02月20日 10:48:50'},
])

const del = (i) => {
  if (confirm('确认删除？')) {
    arr.value.splice(i, 1)
    ElMessage.success('删除成功')
  }
}

</script>
<!--轮播图管理页面-->
<template>
  <el-table :data="arr">
    <!--                                                     align使得元素居中     -->
    <el-table-column align="center" label="编号" type="index" width="100px"></el-table-column>
    <el-table-column align="center" label="轮播图" width="450px">
      <template #default="scope">
        <img :src="scope.row.imgUrl" alt="" style="width: 100%;">
      </template>
    </el-table-column>
    <el-table-column align="center" label="创建时间" prop="createTime"></el-table-column>
    <el-table-column align="center" label="操作">
      <template #default="scope">
        <el-button type="danger" @click="del(scope.$index)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<style scoped>

</style>