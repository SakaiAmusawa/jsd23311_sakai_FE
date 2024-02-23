<script setup>

import {ref} from "vue";
import qs from "qs"
import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router";

const user = ref({username: '', password: ''})

const login = () => {
  let data = qs.stringify(user.value)
  axios.post('http://localhost:8080/v1/users/login', data).then(
      (response) => {
        if (response.data.code === 2001) {
          ElMessage.success('登录成功')
          localStorage.setItem('user', JSON.stringify(user))
          router.push('/index')
        } else {
          ElMessage.error(response.data.msg)
        }
      }
  )
}

</script>

<template>
  <div id="main-div">
    <!--                                                                        设置距离原来自己的顶部位置有100像素  -->
    <el-card class="box-card" style="width: 500px ;height: 300px;margin: 0 auto;position:relative;top: 100px">
      <el-form label-width="60px">
        <el-form-item label="用户名" style="margin-top: 60px;">
          <el-input placeholder="请输入用户名" v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input placeholder="请输入密码" type="password" v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;" type="primary" @click="login()">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<style scoped>
#main-div {
  height: 500px;
  background-image: url("/public/imgs/loginbg.gif");
  background-size: cover;
  background-position: center;

  .box-card {
    background-color: transparent;
  }

  ::v-deep(*.el-input__wrapper) {
    background-color: transparent;
  }
}
</style>