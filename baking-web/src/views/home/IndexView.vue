<script setup>

import router from "@/router";
</script>

<template>
  <div style="width: 1200px;margin: 0 auto;">

    <el-carousel height="150px">
      <el-carousel-item v-for="item in 3">
        <img :src="'/imgs/banner'+item+'.jpg'" alt="轮播图" style="width: 100%;height: 100%;">
      </el-carousel-item>
    </el-carousel>

    <el-row :gutter="10" style="background-color: #fff; margin-top: 10px;">
      <el-col :span="3">
        <p style="font-size: 28px;margin: 10px">烘焙食谱</p>
      </el-col>
      <el-col :span="21">
        <el-menu mode="horizontal" active-text-color="orange">
          <el-menu-item index="1">全部</el-menu-item>
          <el-menu-item index="2">面包</el-menu-item>
          <el-menu-item index="3">小食</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10" style="margin-top: 5px;">
      <el-col :span="6" v-for="item in 4">
        <el-card class="box-card">
          <router-link to="/detail" style="text-decoration: none;color: #333">
            <img src="/imgs/a.jpg" alt="" style="width: 100%;height: 150px;">
            <p style="height: 40px;">奶油面包</p>
          </router-link>
          <!--作者与分类-->
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size: 20px;line-height: 40px">传奇哥</el-col>
            <el-col :span="4" style="line-height: 40px">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center;margin: 10px;">
      <el-button @click="router.push('/list')">点击加载更多</el-button>
    </div>
    <el-row :gutter="10" style="background-color: #fff; margin-top: 10px;">
      <el-col :span="3">
        <p style="font-size: 28px;margin: 10px">烘焙视频</p>
      </el-col>
      <el-col :span="21">
        <el-menu mode="horizontal" active-text-color="orange">
          <el-menu-item index="1">全部</el-menu-item>
          <el-menu-item index="2">面包</el-menu-item>
          <el-menu-item index="3">小食</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10" style="margin-top: 5px;">
      <el-col :span="6" v-for="item in 4">
        <el-card class="box-card">
          <router-link to="/detail" style="text-decoration: none;color: #333">
            <img src="/imgs/a.jpg" alt="" style="width: 100%;height: 150px;">
            <p style="height: 40px;">奶油面包</p>
          </router-link>
          <!--作者与分类-->
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size: 20px;line-height: 40px">传奇哥</el-col>
            <el-col :span="4" style="line-height: 40px">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center;margin: 10px;">
      <el-button @click="router.push('/list')">点击加载更多</el-button>
    </div>
    <el-row :gutter="10" style="background-color: #fff; margin-top: 10px;">
      <el-col :span="3">
        <p style="font-size: 28px;margin: 10px">行业资讯</p>
      </el-col>
      <el-col :span="21">
        <el-menu mode="horizontal" active-text-color="orange">
          <el-menu-item index="1">全部</el-menu-item>
          <el-menu-item index="2">面包</el-menu-item>
          <el-menu-item index="3">小食</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10" style="margin-top: 5px;">
      <el-col :span="6" v-for="item in 4">
        <el-card class="box-card">
          <router-link to="/detail" style="text-decoration: none;color: #333">
            <img src="/imgs/a.jpg" alt="" style="width: 100%;height: 150px;">
            <p style="height: 40px;">奶油面包</p>
          </router-link>
          <!--作者与分类-->
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size: 20px;line-height: 40px">传奇哥</el-col>
            <el-col :span="4" style="line-height: 40px">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center;margin: 10px;">
      <el-button @click="router.push('/list')">点击加载更多</el-button>
    </div>
  </div>
</template>

<style scoped>

</style>