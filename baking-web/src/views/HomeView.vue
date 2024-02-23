<template>
  <div class="common-layout">
    <el-container>
      <el-header style="background-color:#fff;height: 80px;">
        <!--头部-->
        <el-row :gutter="20" style="width: 1200px;margin: 0 auto;">
          <el-col :span="6">
            <!--头部Logo图片 点击logo跳转至 http://localhost:8080/index -->
            <router-link to="/">
              <img src="/imgs/icon.png" style="width: 200px;">
            </router-link>
          </el-col>
          <el-col :span="10">
            <!--头部导航栏-->
            <el-menu @select="handleSelect" mode="horizontal" active-text-color="orange" style="height: 70px;">
              <el-menu-item index="1">食谱</el-menu-item>
              <el-menu-item index="2">视频</el-menu-item>
              <el-menu-item index="3">资讯</el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="6">
            <!--头部搜索框-->
            <el-input placeholder="请输入您要搜索的内容" style="margin-top: 25px;">
              <template #append>
                <el-button :icon="Search"></el-button>
              </template>
            </el-input>
          </el-col>
          <el-col :span="2">
            <!--气泡卡片1-->
            <el-popover title="欢迎访问烘焙坊" v-if="user==null">
              <template #reference>
                <el-icon size="25" color="#666" style="margin-top:30px;">
                  <User/>
                </el-icon>
              </template>
              <div style="text-align:center;">
                <el-button type="info" size="small" @click="router.push('/reg')">注册</el-button>
                <el-button type="warning" size="small" @click="router.push('/login')">登录</el-button>
              </div>
            </el-popover>
            <!--气泡卡片2-->
            <el-popover v-else :title="'欢迎'+user.nickname+'回来!'"
                        :width="200" popper-style="text-align:center;">
              <template #reference>
                <el-icon size="25" color="#666" style="margin-top:30px;">
                  <User/>
                </el-icon>
              </template>
              <div style="text-align:center;">
                <el-button type="success" size="small" @click="router.push('/personal')">个人中心</el-button>
                <el-button type="danger" size="small" @click="logout()">退出登录</el-button>
              </div>
            </el-popover>
          </el-col>
        </el-row>
      </el-header>
      <!--首页中部是可变区域-->
      <el-main>
        <router-view/>
      </el-main>
      <!--首页尾部-->
      <el-footer style="background-color:rgb(50,50,50);color:#666;height:300px;padding:50px;text-align:center;">
        <div style="width: 1200px;margin: 0 auto;">
          <el-row :gutter="10">
            <el-col :span="8">
              <img src="/imgs/icon.png">
              <p>教程灵感就看烘焙坊</p>
              <p>烘焙行业网络社区平台</p>
              <p>全国成百上千个职位等你来</p>
            </el-col>
            <el-col :span="8" id="footer-center">
              <el-row :gutter="10">
                <el-col :span="8">
                  <h3>关于我们</h3>
                  <p>烘焙学院</p>
                  <p>烘焙食谱</p>
                  <p>分类信息</p>
                  <p>求职招聘</p>
                  <p>社区交流</p>
                </el-col>
                <el-col :span="8">
                  <h3>服务与支持</h3>
                  <p>联系我们</p>
                  <p>广告投放</p>
                  <p>用户协议</p>
                  <p>友情链接</p>
                  <p>在线反馈</p>
                </el-col>
                <el-col :span="8">
                  <h3>底部导航</h3>
                  <p>Archiver</p>
                  <p>手机版</p>
                  <p>小黑屋</p>
                </el-col>
              </el-row>
            </el-col>
            <el-col :span="8">
              <p style="font-size:60px;color:#666;margin:10px 0">
                <span style="color:orange;">烘焙</span>坊
              </p>
              <p>烘焙行业社区平台</p>
            </el-col>
          </el-row>
        </div>
      </el-footer>
    </el-container>
  </div>
</template>

<script setup>
import {Search} from '@element-plus/icons-vue';
import router from "@/router";
import {ref} from "vue";

const user = ref(localStorage.user ? JSON.parse(localStorage.user) : null);
//实现退出功能
const logout = () => {
  if (confirm("您确认要退出吗?")) {
    localStorage.clear();
    user.value = null;
    router.push('/');
  }
}

const handleSelect = (key, keyPath) => {
  router.push('/list')
}
</script>

<style>
footer h3 {
  color: #fff;
}

#footer-center p {
  margin: 5px 0;
}
</style>