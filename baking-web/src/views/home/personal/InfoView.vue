<script setup>
import {ref} from 'vue'
import {Plus} from '@element-plus/icons-vue'

const fileList = ref([])

const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handleRemove = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
}

const handlePictureCardPreview = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url
  dialogVisible.value = true
}
</script>
<!--个人中心页面-->
<template>
  <el-form label-width="100px" style="width: 500px;">
    <el-form-item label="头像">
      <el-upload
          v-model:file-list="fileList"
          action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
      >
        <el-icon>
          <Plus/>
        </el-icon>
      </el-upload>

      <el-dialog v-model="dialogVisible">
        <img w-full :src="dialogImageUrl" alt="Preview Image"/>
      </el-dialog>
    </el-form-item>
    <el-form-item label="昵称">
      <el-input placeholder="请输入昵称"></el-input>
    </el-form-item>
    <el-form-item label="用户名">
      <el-input placeholder="请输入用户名" value="tom" disabled></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary">保存修改</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped>

</style>