<template>
  <div>
    <a> 길로그 관리자 </a>
    {{ currentRole }}, {{ test }}
  </div>
</template>

<script>

import { mapGetters } from 'vuex'
export default {

  data() {
    return {
      currentRole: 'nope :(',
      test: 'not works :('
    }
  },
  computed: {
    ...mapGetters([
      'roles'
    ]),
    ...mapGetters([
      'test'
    ])
  },
  created() {
    if (this.roles.includes('admin')) {
      this.currentRole = 'admin :) :)'
    } else if (this.roles.includes('editor')) {
      this.currentRole = 'editor :)'
    }

    if (this.test.includes('test')) {
      this.test = 'it works! :)'
    }
  }
}
</script>
