<template>
  <div class = "main-container">
    <div class = "main-title">
      <font class = "font1">단어 암기</font><font font class="font2"> - {{ licenseInfo.licenseName }}</font>
    </div>


<div class="div1">
  <el-input placeholder="Please input"  v-model="input3" class="input1"> 
    <el-select v-model="select" slot="prepend" placeholder="Select"  class="select1">
      <el-option label="Restaurant" value="1"></el-option>
      <el-option label="Order No." value="2"></el-option>
      <el-option label="Tel" value="3"></el-option>
    </el-select>
    <el-button slot="append" icon="el-icon-search" class="btn1"></el-button>
  </el-input>
</div>


    <div class = "div2">
      <el-table
        :data = "tableData"
        style = "width: 100%; height: 100%;"
      >
        <el-table-column
          label = "Title"
          prop  = "item.title"
        />

        <el-table-column
          label = "등록일"
          width = "400"
        >
          <template slot-scope="scope">
            {{ $moment(scope.row.item.createDate).format('YYYY-MM-DD') }}
          </template>
        </el-table-column>

        <el-table-column
          label = "단어 수"
          width = "100"
          prop  = "item.wordQuestionsCount"
        />
        <el-table-column
          align = "right"
        >
          <template slot-scope = "scope">
            <el-button
              size   = "mini"
              @click = "examPopupStatus(true, scope.row)"
            >암기 하기</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <examinationPopup
      :word-i-d           = "wordID"
      :popup-val          = "examPopupStatusVal"
      :wordQuestionsCount = "wordQuestionsCount"
      @close:examination  = "examPopupStatus"
    />
  </div>
</template>

<script>

import examinationPopup from './component/examinationPopup'
import { fetchList } from '@/ddaja-api/explore/examination-word/ExaminationWord'

export default {
  name: ''

  , components: {
    examinationPopup
  }


  , data() {
    return {
      tableData            : []
      , search             : ''
      , wordID             : 1
      , totalCount         : 0
      , examPopupStatusVal : false
      , wordQuestionsCount : 1
      , page: {}
      , param: {
        licenseID : 0
        , page    : 1
        , size    : 10
      }
    }
  }


  , created() {
    this.licenseInfo     = this.$session.get('licenseInfo')
    this.param.licenseID = this.licenseInfo.licenseID
    this.subject         = this.licenseInfo.subject
    this.fetchList()
  }


  , methods: {

    fetchList() {
      fetchList(this.param).then(response => {
        this.page       = response.page
        this.tableData  = response.items
        this.totalCount = response.totalCount
      })
    }


    , examPopupStatus(val, row) {

      if (val === true) {
        if( row.item.wordQuestionsCount === 0){
          alert('단어가 없습니다')
          return
        }

        this.wordID = row.item.id
        this.examPopupStatusVal = val
        this.wordQuestionsCount = row.item.wordQuestionsCount

      } else {
        this.examPopupStatusVal = val
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
        padding: 2% 0 3% 0;
        .select1{
          width: 200px;
        }
        .btn1{
          width: 100px;
        }
    }
    .div2{
      width: 90%;
        margin: 0 5% 0 5%;
    }
}
</style>
