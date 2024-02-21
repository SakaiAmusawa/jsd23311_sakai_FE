<script setup>
import {ref} from "vue";

const arr = ref([
  {name: "tom", salary: 3000, job: "emp"},
  {name: "sam", salary: 3000, job: "hr"},
  {name: "amy", salary: 3000, job: "java"}
])

const e = ref({name: "", salary: "", job: ""})
const add = () => {
  // arr.value.push(e.value);
  /*  let newEmp = {
      name: e.value.name,
      salary: e.value.salary,
      job: e.value.job,
    }*/
  let newEmp = {...e.value}
  arr.value.push(newEmp)
  // 以下语句的作用是重置输入框内的内容，对整体逻辑无影响
  e.value = {name: "", salary: "", job: ""}
}
</script>

<template>
  <h1>员工列表练习</h1>

  <input v-model="e.name" placeholder="please input name" type="text">
  <input v-model="e.salary" placeholder="please input salary" type="text">
  <input v-model="e.job" placeholder="please input job" type="text">

  <button @click="add()">添加</button>

  <table border="1px">
    <caption>员工列表</caption>
    <tr>
      <th>id</th>
      <th>name</th>
      <th>salary</th>
      <th>job</th>
    </tr>
    <tr v-for="(a,id) in arr">
      <td>{{ id + 1 }}</td>
      <td>{{ a.name }}</td>
      <td>{{ a.salary }}</td>
      <td>{{ a.job }}</td>
    </tr>
  </table>
</template>

<style scoped>

</style>