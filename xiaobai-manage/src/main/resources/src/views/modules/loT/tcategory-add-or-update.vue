<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="${column.comments}" prop="dataUuid">
      <el-input v-model="dataForm.dataUuid" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="category">
      <el-input v-model="dataForm.category" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="parentUuid">
      <el-input v-model="dataForm.parentUuid" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="categoryName">
      <el-input v-model="dataForm.categoryName" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="enableFlag">
      <el-input v-model="dataForm.enableFlag" placeholder="${column.comments}"></el-input>
    </el-form-item>
    <el-form-item label="${column.comments}" prop="seqNo">
      <el-input v-model="dataForm.seqNo" placeholder="${column.comments}"></el-input>
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
    <el-form-item label="${column.comments}" prop="cateLevel">
      <el-input v-model="dataForm.cateLevel" placeholder="${column.comments}"></el-input>
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
          category: '',
          parentUuid: '',
          categoryName: '',
          enableFlag: '',
          seqNo: '',
          remark: '',
          createTime: '',
          updateTime: '',
          cateLevel: ''
        },
        dataRule: {
          dataUuid: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          parentUuid: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          categoryName: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          enableFlag: [
            { required: true, message: '${column.comments}不能为空', trigger: 'blur' }
          ],
          seqNo: [
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
          ],
          cateLevel: [
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
              url: this.$http.adornUrl(`/loT/tcategory/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.dataUuid = data.tCategory.dataUuid
                this.dataForm.category = data.tCategory.category
                this.dataForm.parentUuid = data.tCategory.parentUuid
                this.dataForm.categoryName = data.tCategory.categoryName
                this.dataForm.enableFlag = data.tCategory.enableFlag
                this.dataForm.seqNo = data.tCategory.seqNo
                this.dataForm.remark = data.tCategory.remark
                this.dataForm.createTime = data.tCategory.createTime
                this.dataForm.updateTime = data.tCategory.updateTime
                this.dataForm.cateLevel = data.tCategory.cateLevel
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
              url: this.$http.adornUrl(`/loT/tcategory/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'dataUuid': this.dataForm.dataUuid,
                'category': this.dataForm.category,
                'parentUuid': this.dataForm.parentUuid,
                'categoryName': this.dataForm.categoryName,
                'enableFlag': this.dataForm.enableFlag,
                'seqNo': this.dataForm.seqNo,
                'remark': this.dataForm.remark,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'cateLevel': this.dataForm.cateLevel
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
