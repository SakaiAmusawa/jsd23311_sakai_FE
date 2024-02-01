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

  e.value = {name: "", salary: "", job: ""}
}
</script>

<template>
  <h1>员工列表练习</h1>

  <input type="text" placeholder="please input name" v-model="e.name">
  <input type="text" placeholder="please input salary" v-model="e.salary">
  <input type="text" placeholder="please input job" v-model="e.job">

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