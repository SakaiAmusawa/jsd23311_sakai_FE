<template>
  <h1>表格组件</h1>
  <el-table :data="tableData">
    <el-table-column label="日期" prop="date"></el-table-column>
    <el-table-column label="姓名" prop="name"></el-table-column>
    <el-table-column label="地址" prop="address"></el-table-column>
  </el-table>
  <h3>员工列表</h3>
  <el-table :data="arr" style="width: 430px;margin: 0 auto;">
    <!-- v-bind="col" 每一列就是当前遍历到的tableColumns对象{prop:'job',label:'岗位'}
    label控制标题显示的文字 prop对应arr数组数据的属性名  -->
    <el-table-column v-for="col in tableColumns" v-bind="col"></el-table-column>
  </el-table>
  <hr>
  <h3>新员工列表</h3>
  <el-table :data="arr" style="width: 430px;margin: 0 auto;">
    <el-table-column label="编号" type="index" width="60px"></el-table-column>
    <el-table-column label="姓名" prop="name"></el-table-column>
    <el-table-column label="工资" prop="salary"></el-table-column>
    <el-table-column label="岗位" prop="job"></el-table-column>
    <el-table-column>
      <!--表格添加非文本类型的自定义内容,都需要使用template标签包裹 -->
      <!--#default="scope"是VUE3的一种写法 作用:起到一个数据传递的作用
      我们可以从scope变量中获取到表格的数据-->
      <template #default="scope">
        <!--@click="del(scope.$index,scope.row) 给按钮绑定删除函数del()
            scope.$index被删除元素的下标
            scope.row表示当前行对应的对象-->
        <el-button type="danger" @click="del(scope.$index,scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup>
import {ref} from "vue";

const arr = ref([
  {name: "张三", salary: "5000", job: "销售员"},
  {name: "李四", salary: "6000", job: "维修员"},
  {name: "王五", salary: "7000", job: "护林员"},
  {name: "赵六", salary: "8000", job: "程序猿"},
]);
const del = (i, emp) => {
  if (confirm("您确认删除" + emp.name + "吗?")) {
    arr.value.splice(i, 1);
  }
}
const tableColumns = ref([
  {label: '编号', type: 'index', width: 80},
  {label: '姓名', prop: 'name'},
  {label: '工资', prop: 'salary'},
  {label: '岗位', prop: 'job'},
]);

const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]
</script>

<style scoped>

</style>