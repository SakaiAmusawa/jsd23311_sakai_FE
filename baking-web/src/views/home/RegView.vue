<script setup>

import {ref} from "vue";
import qs from "qs"
import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router";

const user = ref({username: '', password: '', nickname: ''})

const reg = () => {

  let data = qs.stringify(user.value);

  axios.post('http://localhost:8080/v1/users/reg', data).then(
      (response) => {
        if (response.data.code === 2001) {
          ElMessage.success('注册成功');
          router.push('/login')
        } else {
          ElMessage.error(response.data.msg)
        }
      }
  )
  console.log(data)
}

</script>
<!--注册页-->
<template>
  <!-- 布局分为左右两列 各占12列 -->
  <div style="width: 1200px;margin: 0 auto;">
    <el-row :gutter="10">
      <!--   左侧为一张卡片    -->
      <el-col :span="12">
        <el-card>
          <img alt="reg" src="/imgs/reg.png" style="width: 100%;">
        </el-card>
      </el-col>
      <!--   右侧为注册表单   -->
      <el-col :span="12">
        <el-form label-width="80px" style="margin-top: 100px;">
          <el-form-item>
            <h1 style="width: 515px;font-size: 40px;position: relative;">立即注册
              <router-link style="font-size: 20px;color: #0aa1ed;text-decoration: none;position:absolute;right: 0"
                           to="login">
                已有账号？立即登录
              </router-link>
            </h1>
          </el-form-item>
          <el-form-item label="用户名">
            <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="user.password" placeholder="请输入密码" type="password"></el-input>
          </el-form-item>
          <el-form-item label="昵称">
            <el-input v-model="user.nickname" placeholder="请输入昵称" @keydown.enter="reg()"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button style="width: 100%;" type="primary" @click="reg()">注册</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>

</style>