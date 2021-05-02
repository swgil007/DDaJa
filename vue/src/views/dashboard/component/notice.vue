<template>
<div class="notice-container">
  <div class="title"> <i class="el-icon-check" />  공지사항  </div>
  <div class="notice-div">
    <el-table
      :data="tableData"
      height="250"
      style="width: 100%">
      <el-table-column
        prop="title"
        label="Title">
      </el-table-column>
      <el-table-column
        prop="name"
        label="Name"
        width="180">
      </el-table-column>
      <el-table-column
        prop="date"
        label="Date"
        width="180">
      </el-table-column>
      
    </el-table>    
  </div>
</div>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [{

          date: '2016-05-03',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        }, {
          date: '2016-05-02',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        }, {
          date: '2016-05-04',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        }, {
          date: '2016-05-01',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        }, {
          date: '2016-05-08',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        }, {
          date: '2016-05-06',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        }, {
          date: '2016-05-07',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        }],
      }
    }
  }
</script>

<style lang="scss" scoped>  
.notice-container{
  padding-left: 7%;
  padding-right: 7%;
  padding-bottom: 30px;
  width: 100%;
  background-color:rgb(11, 8, 49);
  .notice-div{
    padding: 30px;
    background-color: white;
  }
}

.title{ 
  color: beige;
  font-size: 35px;
  padding-top: 10px;
  padding-bottom: 20px;
}
</style>