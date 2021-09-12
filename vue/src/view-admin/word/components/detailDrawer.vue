<template>
  <div class="main-container">
    <el-drawer
      title="I am the title"
      :visible.sync="popupVal"
      :with-header="false"
      style="width:100%"
      :before-close="handleClose"
    >
      <div class="div1">
        <span class="span1">Word Questions 상세</span>
      </div>
      <div  style="">
      <el-table
        :data="tableData"
        height="730"
        style="width: 100%">
        <el-table-column type="expand">
        <template slot-scope="props">
        <p><i class="el-icon-check"></i> createdDate</p>
        <p>{{ props.row.createdDate }}</p>
        <br>
        <p><i class="el-icon-check"></i> modifiedDate</p>
        <p>{{ props.row.modifiedDate }}</p>
        <br>
        <p><i class="el-icon-check"></i> content </p>
        <p>{{ props.row.content }}</p>
        </template>
        </el-table-column>
        <el-table-column
        label="id"
        prop="id"
        width="100">
        </el-table-column>
        <el-table-column
        label="answer"
        prop="answer">
        </el-table-column>
      </el-table>       
      </div>
    </el-drawer>
  </div>
</template>

<script>

import { wordQuestionList } from '@/ddaja-api/admin/word/Word'

export default {
  name: 'Community',
  props: {
    popupVal: false
    , id: {}
    , size: {}
  },
  data() {
    return {
      param: {
        wordID: 0
        , page : 0
        , size : 0
      }
      , tableData: []
    }
  },
  watch: {
    popupVal(val) {
      if (val) {
        this.param.wordID = this.id
        this.param.size = this.size
        this.fetchInfo()
      }
    }
  },
  methods: {
    async fetchInfo() {
      await wordQuestionList(this.param).then(response => {
        response.items.forEach(x => {
          this.tableData.push({id : x.item.id, answer : x.item.answer, content : x.item.content, createdDate : x.item.createdDate, modifiedDate : x.item.modifiedDate })
        });
      })
    }

    , popupClose() {
      this.$emit('close:updatedrawer', false)
    },

    handleClose() {
      this.popupClose()
    }
  }
}

</script>

<style lang="scss" scoped>

@import url('https://fonts.googleapis.com/css2?family=Kirang+Haerang&display=swap');

.main-container{
    width: 100%;
    .div1{
        text-align: left;
        margin-top: 5px;
        margin-bottom: 30px;
        color: rgb(0, 0, 0);
        margin-left: 1%;
        margin-right: 1%;
        padding: 4% 2% 2% 4%;
        .span1{
            font-size: 50px;
            font-family: 'Do Hyeon', sans-serif;
        }
    }
.div2{
  width : 100%; margin: 1% 4% 2% 4%;
  overflow:auto; 
.div2-1{
width : 100%; float :left ; padding: 1% 1% 1% 0%;text-align : right; font-weight:bold;
.div2-1-1{
  width : 5%;
  padding: 1% 3% 1% 6%;
  float :left ;
}
.div2-1-2{
  width : 82%;
  padding: 1% 1% 1% 1%;
  float :left ;
  text-align: left;
}
}
.div2-2{
width : 100%; text-align : left;float :left ; padding: 1% 10% 1% 10%;
}
}
    .pointer{
        cursor:pointer;
    }
}

::v-deep .el-drawer{
width: 70% !important;
}

// rtl
</style>
