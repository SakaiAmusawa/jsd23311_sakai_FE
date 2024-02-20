<script setup>
import {ref} from "vue";
import {ElMessage} from "element-plus";

const arr = ref([
  {nickname: '汤姆', username: 'tom', isAdmin: true, imgUrl: '/imgs/head.jpg', createTime: '2024年02月20日 10:19:04'},
  {nickname: '杰瑞', username: 'jerry', isAdmin: false, imgUrl: '/imgs/a.jpg', createTime: '2024年02月20日 10:19:08'},
  {nickname: '露西', username: 'lucy', isAdmin: true, imgUrl: '/imgs/b.jpg', createTime: '2024年02月20日 10:19:12'},
  {nickname: '丽丽', username: 'lily', isAdmin: true, imgUrl: '/imgs/c.jpg', createTime: '2024年02月20日 10:19:16'}
])

const del = (i, user) => {
  if (confirm('确认是否删除' + user.nickname + '吗？')) {
    arr.value.splice(i, 1)
    ElMessage.success(user.nickname + '已被删除！')
  }
}
</script>
<!--用户管理页面-->
<template>
  <el-table :data="arr">
    <el-table-column type="index" label="编号" width="100px"></el-table-column>
    <el-table-column label="用户名" prop="username"></el-table-column>
    <el-table-column label="昵称" prop="nickname"></el-table-column>
    <el-table-column label="头像">
      <template #default="scope">
        <el-avatar :src="scope.row.imgUrl"></el-avatar>
      </template>
    </el-table-column>
    <el-table-column label="管理员">
      <template #default="scope">
        <el-switch v-model="scope.row.isAdmin">
        </el-switch>
      </template>
    </el-table-column>
    <el-table-column label="创建时间" prop="createTime"></el-table-column>
    <el-table-column label="操作">
      <template #default="scope">
        <el-button type="danger" @click="del(scope.$index,scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<style scoped>

</style>