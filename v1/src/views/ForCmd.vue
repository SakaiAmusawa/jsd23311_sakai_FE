<script setup>
import {ref} from "vue";

const arr = ref(["张三", "李四", "王五", "赵六", "钱七", "周八"])

const productArr = ref([
      {title: "米老鼠手机", price: 5000, num: 8000},
      {title: "华为手机", price: 6000, num: 7000},
      {title: "苹果手机", price: 7000, num: 6000},
      {title: "三星手机", price: 8000, num: 5000}
    ]
)
const del = (index) => {
  if (confirm("确认删除？")) {
    productArr.value.splice(index, 1)
  }
}
</script>

<template>
  <h1>循环指令练习</h1>
  <!-- 遍历arr数组，取出每个值存入uname中，uname就是当前遍历到的元素 -->
  <ul>
    <li v-for="uname in arr">{{ uname }}</li>
  </ul>
  <!-- 从1到X遍历，固定写法，默认从1开始，步长为1，结束数字可以自定义 -->
  <ol>
    <li v-for="item in 5">{{ item }}</li>
  </ol>

  <hr>
  <table border="1px">
    <caption>商品清单</caption>
    <tr>
      <th>编号</th>
      <th>标题</th>
      <th>价格</th>
      <th>库存</th>
    </tr>
    <!--  v-for="(单个对象,下标) in 数组   -->
    <tr v-for="(p,index) in productArr">
      <td>{{ index + 1 }}</td>
      <td>{{ p.title }}</td>
      <td>{{ p.price }}</td>
      <td>{{ p.num }}</td>
      <td>
        <button @click="del(index)">删除</button>
      </td>
    </tr>
  </table>

</template>

<style scoped>

</style>