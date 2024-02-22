<template>
  <h1>首页</h1>
  <!-- 如果用户信息为空，显示登录注册 -->
  <div v-if="user==null">
    <router-link to="/reg">注册</router-link>
    <router-link to="/login">登录</router-link>
  </div>
  <div v-else>
    <h2>欢迎{{ user.nickname }}回来！</h2>
    <router-link to="/post">
      <el-button>发微博</el-button>
    </router-link>
    <el-button>退出登录</el-button>
  </div>

  <!-- 如果用户信息不为空，显示欢迎信息，并显示发微博与退出登录 -->
</template>

<script setup>

import {ref} from "vue";

const user = ref(localStorage.user ? JSON.parse(localStorage.user) : null)

</script>
