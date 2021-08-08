<script>
import axios from 'axios'

export default {
  data() {
    return {
    }
  },
  created() {
    this.fetchData(this.pageNum)
  },
  methods: {
    fetchData(pageNum) {
      axios
        .get('http://localhost/licenses')
        .then(res => {
          console.log(res.data)
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
