<template>
  <div class="main-container">
    <div class="main-title">
      <div class="div-1">
        <font class="title-font1">자격증 관리</font>
        {{ childData }}
      </div>
    </div>
    <div class="table-box">
      <el-table
        :data="tableData"
        style="width: 100%"
      >
        <el-table-column
          label="자격증 ID"
          prop="item.id"
        />
        <el-table-column
          label="자격증 명"
          prop="item.name"
        />
        <el-table-column>
          <template slot-scope="props">
            <el-button
              size="mini"
              @click="popupState(props.row.licenseName, true)"
            >상세 보기</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="paging-box">
      <el-pagination
        class="paging"
        layout="prev, pager, next"
        :total="50"
      />
    </div>
    <popup
      :popup-val="popupVal"
      :license-name="licenseName"
      @close:popup="popupClose"
      @childData="childPopup"
    />
    <api-request
      @licenseInfo="getLicenseInfo"
    />
  </div>
</template>

<script>
import popup from './component/licensePopup.vue'
import apiRequest from './component/licenseApiRequest.vue'
export default {
  name: '',
  components: {
    popup,
    apiRequest
  },
  data() {
    return {
      tableData: [],
      totalCount: 0,
      popupVal: false,
      childData: ''
    }
  },
  methods: {
    popupState(licenseName, popupVal) {
      this.licenseName = licenseName
      this.popupVal = popupVal
    },
    popupClose(popupVal) {
    },
    childPopup(childData) {
      this.childData = childData
    },
    getLicenseInfo(data) {
      this.tableData = data.items
      this.totalCount = data.totalCount
    }
  }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap');
.main-container{
    width: 100%;
    text-align: center;
    padding: 30px;
    overflow:auto;
    background-color: rgb(255, 255, 255);
    .main-title{
        text-align: left;
        margin-top: 5px;
        margin-bottom: 30px;
        color: rgb(0, 0, 0);
        margin-left: 1%;
        margin-right: 1%;
        padding: 1.5% 2% 0% 4%;
        .div-1{
            width: 80%;
            float: left;
            .title-font1{
                font-size: 50px;
                font-family: 'Do Hyeon', sans-serif;
            }
            .title-font2{
                font-size: 40px;
                padding: 0 0 0 30px;
                font-family: 'Do Hyeon', sans-serif;
            }
        }
        .div-2{
            width: 20%;
            float: left;
            .btn1{
                float: right;
                height: 50px;
                width: 200px;
            }
        }
    }
    .table-box{
        padding: 1.5% 2% 0% 4%;
        margin: 0 0 30px 0 ;
        float:left;
        width: 100%;
        max-height:550px;
        .title{ font-size: 20px; font-weight: bold; }
        .scrore{ font-size: 14px; font-weight: bold; }
        .content{ padding: 1.5%; font-size: 14px; }
    }
    .paging-box{
        float:left;
        padding: 2% 11% 2% 0;
        text-align: center;
        position: fixed;
        bottom: 0;
        width: 100%;
        .paging{
            display: inline-block;
        }
    }
}
</style>
