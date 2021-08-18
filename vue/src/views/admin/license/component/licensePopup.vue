<template>
  <div>
    <el-dialog
      :visible.sync="popupVal"
      :before-close="handleClose"
    >
      <div>
        <template>
          <article-detail
            :is-edit="isEdit"
            :license-info="licenseInfo"
            @close:popup="popupClose"
            @depthChildData="depthChildPopup"
          />
        </template>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import ArticleDetail from './components/ArticleDetail'
export default {
  name: '',
  components: {
    ArticleDetail
  },
  props: {
    popupVal: {},
    licenseInfo: {}
  },
  data() {
    return {
      isEdit: false
    }
  },
  created() { },
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
    depthChildPopup(childData) {
      this.$emit('childData', childData)
    }
  }
}
</script>
