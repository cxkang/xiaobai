<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="${column.comments}" prop="dataUuid">
      <el-input v-model="dataForm.dataUuid" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="appName">
      <el-input v-model="dataForm.appName" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="appVer">
      <el-input v-model="dataForm.appVer" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="fileUrl">
      <el-input v-model="dataForm.fileUrl" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="updateDescription">
      <el-input v-model="dataForm.updateDescription" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="confirmFlag">
      <el-input v-model="dataForm.confirmFlag" placeholder="${column.comments}"></el-input>
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
          appName: '',
          appVer: '',
          fileUrl: '',
          updateDescription: '',
          confirmFlag: '',
          remark: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          dataUuid: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          appName: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          appVer: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          fileUrl: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          updateDescription: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          confirmFlag: [
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
              url: this.$http.adornUrl(`/loT/tapp/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.dataUuid = data.tApp.dataUuid
                this.dataForm.appName = data.tApp.appName
                this.dataForm.appVer = data.tApp.appVer
                this.dataForm.fileUrl = data.tApp.fileUrl
                this.dataForm.updateDescription = data.tApp.updateDescription
                this.dataForm.confirmFlag = data.tApp.confirmFlag
                this.dataForm.remark = data.tApp.remark
                this.dataForm.createTime = data.tApp.createTime
                this.dataForm.updateTime = data.tApp.updateTime
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
              url: this.$http.adornUrl(`/loT/tapp/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'dataUuid': this.dataForm.dataUuid,
                'appName': this.dataForm.appName,
                'appVer': this.dataForm.appVer,
                'fileUrl': this.dataForm.fileUrl,
                'updateDescription': this.dataForm.updateDescription,
                'confirmFlag': this.dataForm.confirmFlag,
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
