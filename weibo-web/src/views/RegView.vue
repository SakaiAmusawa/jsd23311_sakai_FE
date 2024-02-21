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
import axios from "axios";
import router from "@/router";
import qs from "qs"

/*创建一个user对象用于储存输入框输入的信息*/
const user = ref({
  username: '',
  password: '',
  nickname: ''
})

const reg = () => {
  let data = qs.stringify(user.value);
  //console.log(user.value)
  //前端向服务器发出注册请求，需要工具axios，注意需要导入
  axios.post('http://localhost:8080/v1/users/reg', data).then((response) => {
    //response对象装载着相应内容，我们可以通过response.data得到服务器响应的数据
    //console.log(response.data);
    if (response.data.code === 2001) {
      ElMessage.success('注册成功');
      router.push('/')
    } else {
      ElMessage.error(response.data.msg)
    }
  })
}

</script>

<style scoped>
::v-deep(*.el-input__wrapper) {
  background-color: transparent;
}
</style>