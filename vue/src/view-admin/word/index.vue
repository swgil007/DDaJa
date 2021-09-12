<template>
  <div class="main-container">
    <div class="main-title">
      <font class="font1">Word Manager</font>
    </div>

    <div class="div1" style="padding:0px 0px 75px 29%;">
      <div style="float:left; padding:1px 20px 0px 0px">

        <el-select v-model="param.licenseID" placeholder="Select" style="width:500px">
          <el-option
            v-for="item in licenseOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>

      </div>
      <div style="float:left; padding:0px 20px 0px 0px">
        <el-input
          v-model="param.name"
          style="width:500px"
          placeholder="검색 조건을 입력 하세요."
          @keyup.enter.native="clickSearch"
        />
      </div>
      <div style="float:left; padding:0px 0px 0px 0px">
        <el-button
          type="primary"
          @click="clickSearch"
        >검 색</el-button>
      </div>
    </div>

    <div class="div2">
      <el-table
        :data="tableData"
        :header-cell-style="{textAlign:'center'}"
        style="width:100%; height:100%;"
      >
        <el-table-column
          label="ID"
          prop="item.id"
          width="100"
          align="center"
        />

        <el-table-column
          label="License"
          prop="item.license.name"
        />

        <el-table-column
          label="Title"
          prop="item.title"
        />

        <el-table-column
          label="Questions Count"
          prop="item.wordQuestionsCount"
          width="200"
          align="center"
        />

        <el-table-column
          label="등록일"
          width="180"
          align="center"
        >
          <template slot-scope="scope">
            {{ $moment(scope.row.item.createDate).format('YYYY-MM-DD') }}
          </template>
        </el-table-column>

        <el-table-column
          label="수정일"
          width="180"
          align="center"
        >
          <template slot-scope="scope">
            {{ $moment(scope.row.item.modifiedDate).format('YYYY-MM-DD') }}
          </template>
        </el-table-column>

        <el-table-column
          align="right"
          width="100"
        >
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="updateDrawerStatus(true, scope.row)"
            >수정</el-button>
          </template>
        </el-table-column>

        <el-table-column
          align="right"
          width="100"
        >
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="detailDrawerStatus(true, scope.row)"
            >상세</el-button>
          </template>
        </el-table-column>
      </el-table>

      <div class="divpage">
        <pagination
          v-show="totalCount>0"
          :total="totalCount"
          :page.sync="param.page"
          :limit.sync="param.size"
          @pagination="fetchList"
        />
      </div>
      <div>
        <el-divider />
      </div>
    </div>
    <detailDrawer
      :id="id"
      :size="size"
      :popup-val="detailDrawerVal"
      @close:detaildrawer="detailDrawerStatus"
    />
    <updateDrawer
      :id="id"
      :size="size"
      :popup-val="updateDrawerVal"
      @close:updatedrawer="updateDrawerStatus"
    />

  </div>
</template>

<script>

import Pagination from '@/components/Pagination'
import { licenseList, wordList, wordListTotalCount } from '@/ddaja-api/admin/word/Word'
import detailDrawer from './components/detailDrawer'
import updateDrawer from './components/updateDrawer'

export default {
  name: '',

  components: {
    Pagination
    , detailDrawer
    , updateDrawer
  },

  data() {
    return {
      licenseOptions: []
      , tableData: []
      , id: 1
      , totalCount:0
      , param: {
        licenseID: undefined
        , name: ''
        , page: 1
        , size: 10
      },
      detailDrawerVal: false,
      updateDrawerVal: false,
      size :0
    }
  },

  created() {
    this.getLicense()
    this.fetchList()
  },

  methods: {

    async getLicense (){
      await licenseList().then( response => {
        response.items.forEach( x => {
          var type = (x.item.type === 'WRITING') ? '필기' : '실기'
          var label = '[' + type + '] ' + x.item.name
          this.licenseOptions.push({value:x.item.id, label:label})
        })
      })
    }

    , async fetchList() {
      await wordList(this.param).then(response => {
        this.tableData = response.items
        this.page = response.page
      })

      await wordListTotalCount(this.param).then(response => {
        this.totalCount = response.totalCount
      })
    },

    updateDrawerStatus(val, row) {
      this.updateDrawerVal = val
      this.id = (row == undefined) ? 0 : row.item.id
      this.size = (row == undefined) ? 0 : row.item.wordQuestionsCount
    },
    detailDrawerStatus(val, row) {
      this.detailDrawerVal = val
      this.id = (row == undefined) ? 0 : row.item.id
      this.size = (row == undefined) ? 0 : row.item.wordQuestionsCount
    },
    clickSearch() {
      this.param.page = 0
      this.param.size = 10
      this.fetchList()
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
