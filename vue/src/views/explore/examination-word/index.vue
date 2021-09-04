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
          prop="title"
        />
        <el-table-column
          label="등록일"
          width="400"
          prop="createdDate"
        />
        <el-table-column
          label="단어 수"
          width="100"
          prop="wordNum"
        />
        <el-table-column
          label="정답 수"
          width="100"
          prop="answer"
        />
        <el-table-column
          align="right"
        >
          <template slot="header" slot-scope="{}">
            <el-input
              v-model="search"
              size="mini"
              placeholder="Type to search"
            />
          </template>
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
    examinationPopup,
    fetchList
  }


  , data() {
    return {
      tableData: [
        { date: '2011-05-03', wordNum: '23', answer: '12', name: '데이터 베이스 요약 정리 암기 하기' },
        { date: '2012-05-03', wordNum: '30', answer: '8', name: 'java 요약 정리 암기 하기' },
        { date: '2013-05-03', wordNum: '40', answer: '7', name: '운영체제 요약 정리 암기 하기' },
        { date: '2014-05-03', wordNum: '20', answer: '0', name: '전자계산기 요약 정리 암기 하기' },
        { date: '2015-05-03', wordNum: '23', answer: '0', name: '알고리즘  요약 정리 암기 하기' },
        { date: '2016-05-03', wordNum: '36', answer: '0', name: 'OSI 7계층  요약 정리 암기 하기' },
        { date: '2017-05-03', wordNum: '90', answer: '0', name: 'C 언어 함수  요약 정리 암기 하기' },
        { date: '2018-05-03', wordNum: '96', answer: '0', name: '리눅스 용어  요약 정리 암기 하기' }
      ],
      search: '',
      radio1: '1',
      examPopupStatusVal: false
    }
  }


  , created() {
    this.licenseInfo = this.$session.get('licenseInfo')
    this.subject = this.licenseInfo.subject
    this.fetchList()
  }


  , methods: {
    fetchList (){
      fetchList(this.tableData).then(response => {
        this.tableData = response._embedded.words
      })
    }
    
    , examPopupStatus(index, row, val) {
      if (val == true) {
        this.examPopupStatusVal = val;
      } else {
        this.examPopupStatusVal = val;
      }
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
