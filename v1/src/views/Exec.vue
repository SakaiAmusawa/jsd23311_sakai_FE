<script setup>

import {ref} from "vue";

const bannerArr = ref(["/imgs/banner1.jpg", "/imgs/banner2.jpg", "/imgs/banner3.jpg", "/imgs/banner4.jpg", "/imgs/banner5.jpg"]);
const productArr = ref([
  {title: "森马牛仔裤女宽松慢跑裤运动风2022春季新款", price: 233, oldPrice: 598, url: "/imgs/a.jpg", saleCount: 2342},
  {
    title: "茵曼马甲连衣裙两件套春季新款娃娃领色织格长袖背心裙套装",
    price: 233,
    oldPrice: 598,
    url: "/imgs/b.jpg",
    saleCount: 2342
  },
  {
    title: "雪中飞墨绿色短袖t恤女夏2022新款纯棉半袖打底体恤夏季",
    price: 233,
    oldPrice: 598,
    url: "/imgs/c.jpg",
    saleCount: 2342
  },
  {
    title: "【佟丽娅同款】鸭鸭明星同款羽绒服2021年冬季新款时尚",
    price: 233,
    oldPrice: 598,
    url: "/imgs/d.jpg",
    saleCount: 2342
  },
  {
    title: "BEASTER小恶魔鬼脸明星同款夹克毛绒保暖加厚字母印花",
    price: 233,
    oldPrice: 598,
    url: "/imgs/e.jpg",
    saleCount: 2342
  },
  {
    title: "香影毛呢外套女中长款2021年冬季新款气质韩版娃娃领",
    price: 233,
    oldPrice: 598,
    url: "/imgs/f.jpg",
    saleCount: 2342
  },
  {
    title: "SEMIR森马商场同款打底针织毛衣纯色高领新品显瘦",
    price: 233,
    oldPrice: 598,
    url: "/imgs/g.jpg",
    saleCount: 2342
  },
  {title: "美特斯邦威女MTEE 贺岁系列中长款风衣736598", price: 233, oldPrice: 598, url: "/imgs/h.jpg", saleCount: 2342},
  {
    title: "imone2021秋款黑色小西装外套女韩版学生宽松学",
    price: 233,
    oldPrice: 598,
    url: "/imgs/i.jpg",
    saleCount: 2342
  },
  {
    title: "BEASTER 小恶魔明星同款保暖长袖街头潮流连帽卫",
    price: 233,
    oldPrice: 598,
    url: "/imgs/j.jpg",
    saleCount: 2342
  },
  {
    title: "憨厚皇后100%绵羊皮2021秋海宁真皮皮衣女长款修",
    price: 233,
    oldPrice: 598,
    url: "/imgs/k.jpg",
    saleCount: 2342
  },
  {
    title: "美特斯邦威高腰牛仔裤女宽松小脚新款春秋彩色",
    price: 233,
    oldPrice: 598,
    url: "/imgs/l.jpg",
    saleCount: 2342
  }]);
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <!--顶部导航栏-->
        <el-menu mode="horizontal" background-color="#0aa1ed" text-color="#fff" active-text-color="#ff0"
                 default-active="1">
          <el-menu-item index="1">精彩活动</el-menu-item>
          <el-menu-item index="2">精品女装</el-menu-item>
          <el-menu-item index="3">品牌男装</el-menu-item>
          <el-menu-item index="4">母婴产品</el-menu-item>
          <el-menu-item index="5">数码科技</el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
        <!--  轮播图    -->
        <el-carousel height="240px">
          <el-carousel-item v-for="url in bannerArr">
            <img :src="url" style="width: 100%;height: 100%;">
          </el-carousel-item>
        </el-carousel>
        <!--   商品列表     -->
        <el-row :gutter="10">
          <el-col :span="6" v-for="p in productArr" style="margin: 10px 0;">
            <el-card class="box-card" style="padding-bottom: 20px">
              <img :src="p.url" style="width: 100%;height: 100%;" alt="">
              <p>{{ p.title }}</p>
              <div>
                <span style="float: left;color: red">
                  <b>￥{{ p.price }}</b> <s>{{ p.oldPrice }}</s>
                </span>

                <span style="float:right;">
                  销量：{{ p.saleCount }}
                </span>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-main>
      <!--   页脚   -->
      <el-footer style="background-color: #282c30;color: #666;height: 200px;padding-top: 40px;">
        <p>.......</p>
        <p>.......</p>
        <p>.......</p>
      </el-footer>
    </el-container>
  </div>
</template>

<style scoped>
p {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>