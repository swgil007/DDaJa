<template>
  <el-table
    :data="tableData"
    style="width: 100%"
  >
    <el-table-column
      fixed
      prop="date"
      label="가입일"
      width="150"
    />
    <el-table-column
      prop="name"
      label="아이디"
      width="120"
    />
    <el-table-column
      prop="state"
      label="닉네임"
      width="120"
    />
    <el-table-column
      prop="city"
      label="상태"
      width="120"
    />
    <el-table-column
      prop="address"
      label="Address"
      width="300"
    />
    <el-table-column
      prop="zip"
      label="Zip"
      width="120"
    />
    <el-table-column
      fixed="right"
      label="관리"
      width="120"
    >
      <template>
        <el-button type="text" size="middle" @click="handleClick">관리</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        date: '2016-05-03',
        name: 'Tom',
        state: 'California',
        city: 'Los Angeles',
        address: 'No. 189, Grove St, Los Angeles',
        zip: 'CA 90036',
        tag: 'Home'
      }, {
        date: '2016-05-02',
        name: 'Tom',
        state: 'California',
        city: 'Los Angeles',
        address: 'No. 189, Grove St, Los Angeles',
        zip: 'CA 90036',
        tag: 'Office'
      }, {
        date: '2016-05-04',
        name: 'Tom',
        state: 'California',
        city: 'Los Angeles',
        address: 'No. 189, Grove St, Los Angeles',
        zip: 'CA 90036',
        tag: 'Home'
      }, {
        date: '2016-05-01',
        name: 'Tom',
        state: 'California',
        city: 'Los Angeles',
        address: 'No. 189, Grove St, Los Angeles',
        zip: 'CA 90036',
        tag: 'Office'
      }]
    }
  },
  methods: {
    handleClick() {
      alert('관리할게요')
    }
  }
}
</script>
