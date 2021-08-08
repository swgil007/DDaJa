<template>
  <div>
    <el-dialog
      :visible.sync="createPopupVal"
      :before-close="handleClose"
    >
      <div>
        <template>
          <create-license-detail
            :is-edit="isEdit"
            @close:popup="popupClose"
          />
        </template>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import CreateLicenseDetail from './components/createLicenseDetail.vue'
export default {
  name: '',
  components: {
    CreateLicenseDetail
  },
  props: {
    createPopupVal: {}
  },
  data() {
    return {
      isEdit: false
    }
  },
  created() { },
  methods: {
    handleClose(done) {
      this.$confirm('자격증 생성을 취소 하시겠습니까 ?')
        .then(_ => {
          this.popupClose()
        })
        .catch(_ => {})
    },
    popupClose(createPopupVal) {
      this.createPopupVal = createPopupVal
      this.$emit('close:popup', createPopupVal)
    }
  }
}
</script>
