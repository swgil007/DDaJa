<template>
  <div class="main-container">
    <div class="main-title">
      <div class="div-1">
        <font class="title-font1">자격증 관리</font>
        {{ childData }}
      </div>
      <el-button
        size="mini"
        @click="createPopupState(true)"
      >자격증 생성</el-button>
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
          :min-width="200"
          label="자격증 명"
          prop="item.name"
        />
        <el-table-column
          label="관리 코드"
          prop="item.code"
        />
        <el-table-column
          :min-width="100"
          label="주최 기관"
          prop="item.agency"
        />
        <el-table-column
          label="시험 구분"
          prop="item.type"
        />
        <el-table-column
          label="합격 점수"
          prop="item.passScore"
        />
        <el-table-column
          label="사용 여부"
          prop="item.inUse"
        />
        <el-table-column>
          <template slot-scope="props">
            <el-button
              size="mini"
              @click="popupState(props.row.name, true)"
            >상세 보기</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <popup
      :popup-val="popupVal"
      :license-name="name"
      @close:popup="popupClose"
      @childData="childPopup"
    />
    <api-request
      @licenseInfo="getLicenseInfo"
    />
    <license-create-popup
      :create-popup-val="createPopupVal"
      @close:popup="createPopupClose"
    />

    <div class="paging-box">
      <pagination
        class="paging"
        layout="prev, pager, next"
        :total="page.totalItems"
        :page.sync="page.page"
        :limit.sync="page.size"
        @pagination="getList"
      />
    </div>
  </div>

</template>

<script>
import popup from './component/licensePopup.vue'
import apiRequest from './component/licenseApiRequest.vue'
import licenseCreatePopup from './component/licenseCreatePopup.vue'
import Pagination from '@/components/Pagination'
import axios from 'axios'

export default {
  name: '',
  components: {
    popup,
    apiRequest,
    licenseCreatePopup,
    Pagination
  },
  data() {
    return {
      tableData: [],
      page: [],
      popupVal: false,
      createPopupVal: false,
      childData: '',
      name: ''
    }
  },
  methods: {
    popupState(name, popupVal) {
      this.name = name
      this.popupVal = popupVal
    },
    createPopupState(createPopupVal) {
      this.createPopupVal = createPopupVal
    },
    popupClose(popupVal) {
      this.popupVal = popupVal
    },
    createPopupClose(createPopupVal) {
      this.createPopupVal = createPopupVal
    },
    childPopup(childData) {
      this.childData = childData
    },
    getLicenseInfo(data) {
      this.tableData = data.items
      this.page = data.page
    },
    getList(data) {
      const page = data.page
      const size = data.limit
      axios
        .get('http://localhost/licenses?page=' + page + '&size=' + size)
        .then(res => {
          console.log(res.data)
          this.tableData = res.data.items
          this.page = res.data.page
        })
        .catch(err => {
          alert('fail')
          console.log(err)
        })
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
        text-align: center;
        position: fixed;
        bottom: 0;
        width: 100%;
        margin-top: 100px;
        .paging{
            display: inline-block;
        }
    }
}
</style>
