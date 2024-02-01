<script setup>
import {ref} from "vue";

const person = ref({name: "", age: "", imgUrl: "", friends: []});

const load = () => {
  person.value = {name: "fcq", age: "20", imgUrl: "fcq.jpg", friends: ["路飞", "索隆"]}
}
</script>

<template>
  <h1>Resume</h1>
  <table border="1px">
    <tr>
      <td>照片</td>
      <td><img :src="person.imgUrl" width="100px"></td>
    </tr>
    <tr>
      <td>名字</td>
      <td>{{ person.name }}</td>
    </tr>
    <tr>
      <td>年龄</td>
      <td>{{ person.age }}</td>
    </tr>
    <tr>
      <td>朋友</td>
      <td>
        <ul>
          <li v-for="fn in person.friends">{{ fn }}</li>
        </ul>
      </td>
    </tr>
  </table>
  <button @click="load()">加载数据</button>
</template>

<style scoped>

</style>