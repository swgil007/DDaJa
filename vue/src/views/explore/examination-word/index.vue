<template>
  <div class="main-container">
    <div class="main-title">
      <font class="font1">단어 암기</font><font font class="font2"> - {{ licenseInfo.licenseName }}</font>
    </div>
    <div class="div1">
      <el-table
        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
        style="width: 100%; height: 100%;"
      >
        <el-table-column
          label="Title"
          prop="item.title"
        />

        <el-table-column
          label="등록일"
          width="400"
        >
          <template slot-scope="scope">
            {{ $moment(scope.row.item.createDate).format('YYYY-MM-DD') }}
          </template>

        </el-table-column>

        <el-table-column
          label="단어 수"
          width="100"
          prop="item.wordNum"
        />
        <el-table-column
          label="정답 수"
          width="100"
          prop="item.answer"
        />
        <el-table-column
          align="right"
        >
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="examPopupStatus(scope.$index, scope.row, true)"
            >암기 하기</el-button>

          </template>
        </el-table-column>
      </el-table>
    </div>
    <examinationPopup
      :popup-val="examPopupStatusVal"
      @close:examination="examPopupStatus"
    />
  </div>
</template>

<script>

import examinationPopup from '@/views/explore/examination-word/component/examinationPopup'
import { fetchList } from '@/ddaja-api/explore/examination-word/ExaminationWord'

export default {
  name: '',
  components: {
    examinationPopup
  },

  data() {
    return {
      tableData: [],
      search: '',
      radio1: '1',
      examPopupStatusVal: false,

      totalCount: 0,
      page: {},
      param: {
        licenseID: 0,
        page: 1,
        size: 10
      }
    }
  },

  created() {
    this.licenseInfo = this.$session.get('licenseInfo')
    this.subject = this.licenseInfo.subject
    this.param.licenseID = this.licenseInfo.licenseID

    this.fetchList()
  },

  methods: {
    fetchList() {
      fetchList(this.param).then(response => {
        console.log(response)
        this.tableData = response.items
        this.totalCount = response.totalCount
        this.page = response.page
      })
    },

    examPopupStatus(index, row, val) {
      if (val === true) {
        this.examPopupStatusVal = val
      } else {
        this.examPopupStatusVal = val
      }
    },

    createDate(item) {
      console.log(item)
      return '2020'
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
        .font1{
            font-size: 50px;
            font-family: 'Do Hyeon', sans-serif;
        }
        .font2{
            font-size: 40px;
            padding: 0 0 0 30px;
            font-family: 'Do Hyeon', sans-serif;
        }
    }
    .div1{
        width: 90%;
        margin: 0 5% 0 5%;
    }
}
</style>
