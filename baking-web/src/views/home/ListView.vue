<script setup>

import {onMounted, ref} from "vue";
import axios from "axios";

onMounted(() => {
  initData();
})

const contentList = ref([]);

const initData = () => {
  let type = new URLSearchParams(location.search).get('type');
  axios.get('http://localhost:8080/v1/content/' + type + '/type')
      .then((response) => {
        if (response.data.code === 2001) {
          contentList.value = response.data.data;
        }
      })
}

</script>

<template>
  <div style="width: 1200px;margin: 0 auto;">
    <el-row :gutter="10" style="margin-top: 5px;">
      <el-col v-for="item in contentList" :span="6">
        <el-card class="box-card">
          <router-link style="text-decoration: none" :to="'/detail?id='+item.id">
            <img alt="" src="/imgs/a.jpg" style="width: 100%;height: 150px;">
            <p style="height: 40px;">{{ item.title }}</p>
          </router-link>
          <el-row :gutter="10" style="margin-top: 5px;">
            <el-col :span="4">
              <el-avatar :src="'http://localhost:8080'+item.userImgUrl"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size: 20px;line-height: 40px">{{ item.nickname }}</el-col>
            <el-col :span="4" style="line-height: 40px">{{ item.categoryName }}</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>

  </div>
</template>

<style scoped>

</style>