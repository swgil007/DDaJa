<template>
  <div>
    <Login />

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Login from './component/login'

export default {
  name: 'Admin',
  components: { Login },
  computed: {
    ...mapGetters([
      'roles'
    ])
  },
  created() {
    if (!this.roles.includes('admin')) {
      this.currentRole = 'editorDashboard'
    }
  }
}
</script>

