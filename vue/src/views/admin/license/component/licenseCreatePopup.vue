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
            :options="options"
            @close:popup="popupClose"
          />
        </template>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import CreateLicenseDetail from './components/createLicenseDetail.vue'
import axios from 'axios'
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
      isEdit: false,
      options: []
    }
  },
  created() {
    this.requestTypeList()
  },
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
    },
    requestTypeList() {
      axios.get('http://localhost/licenses/type')
        .then(res => {
          console.log('optionsss')
          console.log(res.data)
          this.options = res.data.items
        })
        .catch(err => {
          alert('fail')
          console.log(err)
        })
    }
  }
}
</script>
