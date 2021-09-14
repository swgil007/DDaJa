<template>
  <div>
    <el-dialog
      :visible.sync="popupVal"
      :before-close="handleClose"
    >
      <div><h1>www</h1></div>
    </el-dialog>
  </div>
</template>
<script>
export default {
  name: '',
  props: {
    popupVal: {}
  },
  data() {
    return {
      isEdit: false
    }
  },
  methods: {
    handleClose(done) {
      this.$confirm('작성을 취소 하시겠습니까 ?')
        .then(_ => {
          this.popupClose()
        })
        .catch(_ => {})
    },
    popupClose(popupVal) {
      this.popupVal = popupVal
      this.$emit('close:popup', popupVal)
    },
    requestTypeList() {
      // this.$http.get('http://localhost/licenses/type')
      //   .then(res => {
      //     this.typeOptions = res.data
      //   })
      //   .catch(err => {
      //     console.log(err)
      //   })
    }
  }
}
</script>
