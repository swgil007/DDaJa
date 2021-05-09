<template>
  <div>
    <el-dialog
      title="공지사항"
      :visible.sync="popupVal"
      width="1000px"
      top="2%"
      :before-close="handleClose"
    >
      <div>
        <el-form ref="form" :model="vo" label-width="120px">
          <el-form-item label="작성자">
            {{ vo.notis_user }}
          </el-form-item>
          <el-form-item label="제목">
            {{ vo.notis_title }}
          </el-form-item>
          <el-form-item label="공지사항 유형">
            {{ vo.notis_type }}
          </el-form-item>
          <el-form-item label="공지사항 등록일">
            {{ vo.notis_date }}
          </el-form-item>
          <el-form-item label="공지사항 기간">
            {{ vo.notis_date1 }} ~ {{ vo.notis_date2 }}
          </el-form-item>
          <el-col>
            <el-form-item class="notis-board" style="margin-bottom: 15px; width: 100%">
              <p v-html="notisBoard" />
            </el-form-item>
          </el-col>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="popupClose()">Close</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  name: 'SelectPopup',
  components: {
  },
  props: {
    popupVal: {},
    voData: {}
  },
  data() {
    return {
      vo: {},
      notisBoard: {}
    }
  },
  computed: {
    localPopupVal: {
      get() {
        return this.localPopupVal
      },
      set(newVal) {
        if (newVal === 'close') {
          this.$emit('close:selectPopup', false)
        }
      }
    }
  },
  watch: {
    voData() {
      this.vo = this.voData
      this.notisBoard = this.vo.notisBoard
    }
  },
  methods: {
    popupClose() {
      this.localPopupVal = 'close'
    },
    handleClose(done) {
      this.popupClose()
    }
  }
}
</script>

<style scoped>
::v-deep .el-dialog__header {
  position: relative;
  height: 45px;
  padding: 0 !important;
  background: #1890ff;
}
::v-deep .el-dialog__title {
  position: absolute;
  height: auto !important;
  top: 50%;
  transform: translateY(-50%);
  height: 24px;
  padding: 0 0 0 20px;
  color: #fff;
  font-size: 16px;
}
::v-deep .el-dialog__headerbtn {
  position: absolute;
  top: 50%;
  right: 0;
  transform: translateY(-50%);
  padding: 0 20px 0 0;
}
::v-deep .el-dialog__close {
  color: #fff !important;
}
/* dialog title */
.dialog-title {
  color: black;
}
.notis-board{
    border: 4px solid gainsboro;
    padding-right: 7%;
}
</style>
