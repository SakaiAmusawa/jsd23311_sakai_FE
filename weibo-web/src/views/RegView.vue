<template>
  <h1>注册页面</h1>
  <el-card style="width: 450px;margin: 0 auto;padding: 20px 10px 0 0;">
    <el-form label-width="60px">
      <el-form-item label="用户名">
        <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="user.password" placeholder="请输入密码" type="password"></el-input>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="user.nickname" placeholder="请输入昵称"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width: 100%;" @click="reg()">注册</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script setup>

import {ref} from "vue";
import {ElMessage} from "element-plus";

/*创建一个user对象用于储存输入框输入的信息*/
const user = ref({
  username: '',
  password: '',
  nickname: ''
})

const reg = () => {
  console.log(user.value)
  ElMessage.success("注册成功")
}

</script>

<style scoped>
::v-deep(*.el-input__wrapper) {
  background-color: transparent;
}
</style>