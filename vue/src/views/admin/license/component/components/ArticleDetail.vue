<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container">
      <div class="createPost-main-container">
        <h1>자격증 정보 수정</h1>
        <el-row>
          <el-col
            :span="24"
          >
            {{ licenseName }}
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <div class="choice-box">
              <el-radio v-model="radio1" label="1" border>노출</el-radio>
              <el-radio v-model="radio1" label="2" border>비 노출</el-radio>
              <el-input v-model="childData" />
            </div>
            {{ childData }}
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24" align="right">
            <el-button @click="popupClose()">저장</el-button>
          </el-col>
        </el-row>
      </div>
    </el-form>
  </div>
</template>

<script>
export default {
  name: '',
  props: {
    isEdit: {},
    licenseName: {}
  },
  data() {
    return {
      childData: ''
    }
  },
  methods: {
    popupClose() {
      this.$emit('close:popup', false)
      this.$emit('depthChildData', this.childData)
    }
  }
}
</script>

<style lang="scss" scoped>
@import "~@/styles/mixin.scss";

.createPost-container {
  position: relative;

  .createPost-main-container {
    padding: 40px 45px 20px 50px;

    .postInfo-container {
      position: relative;
      @include clearfix;
      margin-bottom: 10px;

      .postInfo-container-item {
        float: left;
      }
    }
  }

  .word-counter {
    width: 40px;
    position: absolute;
    right: 10px;
    top: 0px;
  }
}

.article-textarea ::v-deep {
  textarea {
    padding-right: 40px;
    resize: none;
    border: none;
    border-radius: 0px;
    border-bottom: 1px solid #bfcbd9;
  }
}

.choice-box{
    padding: 0 5.5% 1.5% 0;
    float: right;
}
</style>
