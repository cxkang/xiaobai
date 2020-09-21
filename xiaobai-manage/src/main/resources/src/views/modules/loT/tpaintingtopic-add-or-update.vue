<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="${column.comments}" prop="dateUuid">
      <el-input v-model="dataForm.dateUuid" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="paintingUuid">
      <el-input v-model="dataForm.paintingUuid" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="topicUuid">
      <el-input v-model="dataForm.topicUuid" placeholder="${column.comments}"></el-input>
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
          dateUuid: '',
          paintingUuid: '',
          topicUuid: '',
          remark: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          dateUuid: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          paintingUuid: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          topicUuid: [
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
              url: this.$http.adornUrl(`/loT/tpaintingtopic/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.dateUuid = data.tPaintingTopic.dateUuid
                this.dataForm.paintingUuid = data.tPaintingTopic.paintingUuid
                this.dataForm.topicUuid = data.tPaintingTopic.topicUuid
                this.dataForm.remark = data.tPaintingTopic.remark
                this.dataForm.createTime = data.tPaintingTopic.createTime
                this.dataForm.updateTime = data.tPaintingTopic.updateTime
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
              url: this.$http.adornUrl(`/loT/tpaintingtopic/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'dateUuid': this.dataForm.dateUuid,
                'paintingUuid': this.dataForm.paintingUuid,
                'topicUuid': this.dataForm.topicUuid,
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
