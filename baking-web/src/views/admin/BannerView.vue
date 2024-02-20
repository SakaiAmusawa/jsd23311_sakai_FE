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
    <el-table-column type="index" label="编号" width="100px" align="center"></el-table-column>
    <el-table-column label="轮播图" width="450px" align="center">
      <template #default="scope">
        <img :src="scope.row.imgUrl" alt="" style="width: 100%;">
      </template>
    </el-table-column>
    <el-table-column label="创建时间" prop="createTime" align="center"></el-table-column>
    <el-table-column label="操作" align="center">
      <template #default="scope">
        <el-button type="danger" @click="del(scope.$index)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<style scoped>

</style>