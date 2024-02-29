<script setup>

import {onMounted, ref} from "vue";
import axios from "axios";

const detail = ref({});

onMounted(() => {
  let id = new URLSearchParams(location.search).get('id')
  axios.get('http://localhost:8080/v1/content/' + id + '/detail')
      .then((response) => {
        if (response.data.code === 2001) {
          detail.value = response.data.data;
        }
      })
})

</script>

<template>
  <el-row :gutter="10" style="width: 1200px;margin: 0 auto;">
    <el-col :span="18">
      <el-card class="box-card">
        <h1 style="color: orange;text-align: center">{{ detail.title }}</h1>
        <p style="color: #666;font-size: 12px ;text-align: center ">作者：{{ detail.nickname }}|发布时间：{{
            detail.createTime
          }}|阅读次数：{{ detail.viewCount }}</p>
        <hr>
        <el-card class="box-card" v-if="detail.content!=null">
          <span style="color: #0aa1ed;font-weight: bold;" >摘要：</span>{{ detail.brief }}
        </el-card>
        <p v-if="detail.content!=null">{{ detail.content }}</p>
        <video v-else :src="'http://localhost:8080/'+detail.videoUrl" type="video/mp4" style="width: 100%;margin: 5px;"></video>
        <img alt="" :src="'http://localhost:8080'+detail.imgUrl" style="width: 100%;">
      </el-card>
      <!--   评论相关开始   -->
      <el-card style="margin-top: 10px;">
        <p>发布一条友善的评论</p>
        <hr>
        <el-row :gutter="10">
          <el-col :span="22">
            <el-input placeholder="想不想说点什么"></el-input>
          </el-col>
          <el-col :span="2">
            <el-button type="primary">发布</el-button>
          </el-col>
        </el-row>
        <el-row v-for="item in 10" :gutter="10" style="margin-top: 10px;">
          <el-col :span="2">
            <el-avatar style="margin: 10px;"><img alt="" :src="'http://localhost:8080/'+detail.userImgUrl"></el-avatar>
          </el-col>
          <el-col :span="22">
            <p style="color: orange;font-weight: bold;margin: 0;font-size: 15px">{{ detail.nickname }}</p>
            <p style="margin: 2px 0;font-size: 12px">看起来很好吃的样子</p>
            <p style="color: #666;font-size: 12px;margin: 0;">2024年02月19日 15:38:45</p>
          </el-col>
        </el-row>
      </el-card>
    </el-col>
    <el-col :span="6">
      <el-card>
        <div id="head-div"></div>
        <div style="text-align: center;position: relative;bottom: 45px">
          <el-avatar :size="90" style="border: 5px solid #fff"><img alt="" :src="'http://localhost:8080/'+detail.userImgUrl"></el-avatar>
          <p style="font-size: 20px;font-weight: bold;margin: 5px 0;">{{ detail.nickname }}</p>
          <el-icon class="head-icon">
            <Edit/>
          </el-icon>
          <span>本文作者</span><br>
          <el-icon class="head-icon">
            <Clock/>
          </el-icon>
          <span>{{ detail.createTime }}</span>
        </div>

      </el-card>

      <el-card style="margin-top: 10px;">
        <h2>热门文章</h2>
        <hr>
        <el-row v-for="item in 4" :gutter="10">
          <el-col :span="10">
            <img alt="" src="/imgs/a.jpg" style="width: 100%;">
          </el-col>
          <el-col :span="14">
            <h3 style="height: 40px;margin-top: 0;">这是标题内容</h3>
            <p style="color: #666666;font-size: 12px;margin: 0;">2024年02月19日 16:24:21</p>
          </el-col>
        </el-row>
      </el-card>

      <el-card style="margin-top: 10px;">
        <h2>作者其他文章</h2>
        <hr>
        <el-row v-for="item in 4" :gutter="10">
          <el-col :span="10">
            <img alt="" src="/imgs/a.jpg" style="width: 100%;">
          </el-col>
          <el-col :span="14">
            <h3 style="height: 40px;margin-top: 0;">这是标题内容</h3>
            <p style="color: #666666;font-size: 12px;margin: 0;">2024年02月19日 16:24:21</p>
          </el-col>
        </el-row>
      </el-card>
    </el-col>
  </el-row>
</template>

<style scoped>
#head-div {
  height: 90px;
  background-image: url(/public/imgs/avarbg.jpg);
}

.head-icon {
  color: orange;
  font-weight: bold;
  position: relative;
  top: 3px;
  right: 5px;
}
</style>