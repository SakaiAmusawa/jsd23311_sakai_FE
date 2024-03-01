<script setup>

import {onBeforeUpdate, onMounted, ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router";
import qs from "qs";

//保存详情页内容的数组
const detail = ref({});
//otherArr保存作者其他文章
const otherArr = ref([]);
//hotArr用于保存热门文章
const hotArr = ref([]);
//comment用于发布评论
const comment = ref({})
//commentArr用于保存评论
const commentArr = ref([])

//定义一个方法初始化方法
const initDate = () => {
  let id = new URLSearchParams(location.search).get('id')
  axios.get('http://localhost:8080/v1/content/' + id + '/detail')
      .then((response) => {
        if (response.data.code === 2001) {
          detail.value = response.data.data;

          axios.get('http://localhost:8080/v1/content/' + detail.value.userId + '/other')
              .then((response) => {
                if (response.data.code === 2001) {
                  otherArr.value = response.data.data;
                }
              })

          axios.get('http://localhost:8080/v1/content/hot')
              .then((response) => {
                if (response.data.code === 2001) {
                  hotArr.value = response.data.data
                }
              })

          loadComment(detail.value.id);

        }
      })

}

//初始加载
onMounted(() => {
  initDate();
})

//更新后加载
onBeforeUpdate(() => {
  initDate();
})

//发布评论
const pushComment = () => {
  let user = localStorage.user ? JSON.parse(localStorage.user) : null
  if (user == null) {
    ElMessage.error('发送评论前，请先登录')
    router.push('/login')
  }
  comment.value.userId = user.id;
  comment.value.contentId = detail.value.id;
  console.log(comment.value)
  let data = qs.stringify(comment.value);
  axios.post('http://localhost:8080/v1/comment/add-new', data)
      .then((response) => {
        if (response.data.code === 2001) {
          ElMessage.success('发布成功');
          loadComment(detail.value.id);
          //清空残留在输入框的评论
          comment.value.content = '';
        }
      })
}

//加载评论
const loadComment = (id) => {
  let user = localStorage.user ? JSON.parse(localStorage.user) : null
  let queryData = qs.stringify({userId: user.id, contentId: id})
  console.log(queryData)
  axios.get('http://localhost:8080/v1/comment/list?' + queryData)
      .then((response) => {
        if (response.data.code === 2001) {
          commentArr.value = response.data.data;
        }
      })
}
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
        <div v-if="detail.type!==2">
          <el-card class="box-card">
            <span style="color: #0aa1ed;font-weight: bold;">摘要：</span>{{ detail.brief }}
          </el-card>
          <div v-html="detail.content"></div>
        </div>
        <div v-else>
          <video :src="'http://localhost:8080/'+detail.videoUrl" controls style="width: 100%;margin: 5px;"
                 type="video/mp4"></video>
        </div>
      </el-card>
      <!--   评论相关开始   -->
      <el-card style="margin-top: 10px;">
        <p>发布一条友善的评论</p>
        <hr>
        <el-row :gutter="10">
          <el-col :span="22">
            <el-input v-model="comment.content" placeholder="想不想说点什么" @keydown.enter="pushComment()"></el-input>
          </el-col>
          <el-col :span="2">
            <el-button type="primary" @click="pushComment()">发布</el-button>
          </el-col>
        </el-row>
        <el-row v-for="item in commentArr" :gutter="10" style="margin-top: 10px;">
          <el-col :span="2">
            <el-avatar style="margin: 10px;"><img :src="'http://localhost:8080/'+item.userImgUrl" alt=""></el-avatar>
          </el-col>
          <el-col :span="22">
            <p style="color: orange;font-weight: bold;margin: 0;font-size: 15px">{{ item.nickname }}</p>
            <p style="margin: 2px 0;font-size: 12px">{{ item.content }}</p>
            <p style="color: #666;font-size: 12px;margin: 0;">{{ item.createTime }}</p>
          </el-col>
        </el-row>
      </el-card>
    </el-col>
    <el-col :span="6">
      <el-card>
        <div id="head-div"></div>
        <div style="text-align: center;position: relative;bottom: 45px">
          <el-avatar :size="90" style="border: 5px solid #fff"><img :src="'http://localhost:8080/'+detail.userImgUrl"
                                                                    alt="">
          </el-avatar>
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
        <el-row v-for="item in hotArr" :gutter="10">
          <el-col :span="10">
            <router-link :to="'/detail?id='+item.id">
              <img :src="'http://localhost:8080'+item.imgUrl" alt="" style="width: 100%;">
            </router-link>
          </el-col>
          <el-col :span="14">
            <router-link :to="'/detail?id='+item.id">
              <p class="title_p">{{ item.title }}</p>
            </router-link>
            <p style="color: #666666;font-size: 12px;margin: 0;">{{ item.createTime }}</p>
          </el-col>
        </el-row>
      </el-card>

      <el-card style="margin-top: 10px;">
        <h2>作者其他文章</h2>
        <hr>
        <el-row v-for="item in otherArr" :gutter="10">
          <el-col :span="10">
            <router-link :to="'/detail?id='+item.id">
              <img :src="'http://localhost:8080'+item.imgUrl" alt="" style="width: 100%;">
            </router-link>
          </el-col>
          <el-col :span="14">
            <router-link :to="'/detail?id='+item.id">
              <p class="title_p">{{ item.title }}</p>
            </router-link>
            <p style="color: #666666;font-size: 12px;margin: 0;">{{ item.createTime }}</p>
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


.title_p {
  height: 40px;
  margin-top: 0;
  overflow: hidden;
  display: -webkit-box;
  /*显示的行数为两行*/
  -webkit-line-clamp: 2;
  /*水平排列*/
  -webkit-box-orient: vertical;

  color: orange;
}

a {
  color: #333;
  text-decoration: none;
}

a:hover {
  font-weight: bolder;
}
</style>