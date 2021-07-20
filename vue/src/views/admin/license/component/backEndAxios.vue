<template>
  <div>
    <h1>License Data</h1>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      licenseId: null,
      licenseName: null,
      licenseInfo: {}
    }
  },
  created() {
    alert('api')
    this.fetchData(this.pageNum)
  },
  methods: {
    fetchData(pageNum) {
      axios
        .get('http://localhost/test/vue')
        .then(res => {
          alert('success')
          console.log(res)
          this.$emit('licenseInfo', res.data)
        })
        .catch(err => {
          alert('fail')
          console.log(err)
        })
    }
  }
}
</script>
