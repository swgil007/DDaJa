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
            :license-name="licenseName"
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
    licenseName: {}
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
      alert(`[depth] popup close!`)
      this.popupVal = popupVal
      this.$emit('close:popup', popupVal)
      alert(`[depth] after emit close popup`)
    },
    depthChildPopup(childData) {
      alert('[depthChildPopup]' + childData)
      this.$emit('childData', childData)
    }
  }
}
</script>
