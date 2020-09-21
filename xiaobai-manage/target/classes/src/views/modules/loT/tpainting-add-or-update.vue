<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="${column.comments}" prop="dataUuid">
      <el-input v-model="dataForm.dataUuid" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="categoryUuid">
      <el-input v-model="dataForm.categoryUuid" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="paintingName">
      <el-input v-model="dataForm.paintingName" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="author">
      <el-input v-model="dataForm.author" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="paintingPeriod">
      <el-input v-model="dataForm.paintingPeriod" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="paintingOrientation">
      <el-input v-model="dataForm.paintingOrientation" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="description">
      <el-input v-model="dataForm.description" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="topicStr">
      <el-input v-model="dataForm.topicStr" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="paintingUrl">
      <el-input v-model="dataForm.paintingUrl" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="${column.comments}"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          dataUuid: '',
          categoryUuid: '',
          paintingName: '',
          author: '',
          paintingPeriod: '',
          paintingOrientation: '',
          description: '',
          topicStr: '',
          paintingUrl: '',
          remark: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          dataUuid: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          categoryUuid: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          paintingName: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          author: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          paintingPeriod: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          paintingOrientation: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          topicStr: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          paintingUrl: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/loT/tpainting/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.dataUuid = data.tPainting.dataUuid
                this.dataForm.categoryUuid = data.tPainting.categoryUuid
                this.dataForm.paintingName = data.tPainting.paintingName
                this.dataForm.author = data.tPainting.author
                this.dataForm.paintingPeriod = data.tPainting.paintingPeriod
                this.dataForm.paintingOrientation = data.tPainting.paintingOrientation
                this.dataForm.description = data.tPainting.description
                this.dataForm.topicStr = data.tPainting.topicStr
                this.dataForm.paintingUrl = data.tPainting.paintingUrl
                this.dataForm.remark = data.tPainting.remark
                this.dataForm.createTime = data.tPainting.createTime
                this.dataForm.updateTime = data.tPainting.updateTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/loT/tpainting/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'dataUuid': this.dataForm.dataUuid,
                'categoryUuid': this.dataForm.categoryUuid,
                'paintingName': this.dataForm.paintingName,
                'author': this.dataForm.author,
                'paintingPeriod': this.dataForm.paintingPeriod,
                'paintingOrientation': this.dataForm.paintingOrientation,
                'description': this.dataForm.description,
                'topicStr': this.dataForm.topicStr,
                'paintingUrl': this.dataForm.paintingUrl,
                'remark': this.dataForm.remark,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
