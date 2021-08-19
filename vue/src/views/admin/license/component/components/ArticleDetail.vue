<template>
  <div class="createPost-container">
    <el-form ref="licenseForm" :model="license" class="form-container">
      <div class="createPost-main-container">
        <h1>자격증 정보 수정</h1>

        <el-form-item label="자격증 이름">
          <el-input v-model="license.name" />
        </el-form-item>

        <el-form-item label="관리코드">
          <el-select v-model="license.lCode">
            <el-option
              v-for="item in codeOptions"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="주최 기관">
          <el-input v-model="license.agency" />
        </el-form-item>

        <el-form-item label="시험 구분">
          <el-radio-group v-model="license.type">
            <el-radio
              v-for="item in typeOptions"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-radio-group>
        </el-form-item>

        <el-row>
          <el-col
            :span="24"
          >
            {{ licenseInfo }}
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <div class="choice-box">
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

        <el-form-item label="Resources">
          <el-radio-group v-model="license.inUse">
            <el-radio label="Sponsor" />
            <el-radio label="Venue" />
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button type="primary">Create</el-button>
          <el-button>Cancel</el-button>
        </el-form-item>

      </div>
    </el-form>

  </div>
</template>

<script>
export default {
  name: '',
  props: {
    isEdit: {},
    licenseInfo: {},
    typeOptions: {},
    codeOptions: {}
  },
  data() {
    return {
      childData: '',
      license: {
        name: this.licenseInfo.name,
        agency: this.licenseInfo.agency,
        inUse: this.licenseInfo.inUse,
        type: this.licenseInfo.type,
        lCode: this.licenseInfo.code,
        passScore: this.licenseInfo.passScore
      }
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
