<template>
  <div :class="{'has-logo':showLogo}">
<<<<<<< HEAD
    <logo v-if="showLogo" />
=======
    <logo v-if="showLogo"/>
>>>>>>> 8c648e9c4372be86d077b18e1b33d4ea0edea249
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Logo from './Logo'

export default {
<<<<<<< HEAD
  components: {
    Logo
  },

  computed: {

    ...mapGetters([
      'permission_routes'
    ]),

    activeMenu() {
=======
  components: { 
    Logo 
  }


  , computed: {

    ...mapGetters([
      'permission_routes'
    ])
    

    , activeMenu() {

>>>>>>> 8c648e9c4372be86d077b18e1b33d4ea0edea249
      const route = this.$route
      const { meta, path } = route

      if (meta.activeMenu) {
        return meta.activeMenu
      }
      return path
<<<<<<< HEAD
    },

    showLogo() {
=======
    }

    , showLogo() {
>>>>>>> 8c648e9c4372be86d077b18e1b33d4ea0edea249
      return this.$store.state.settings.sidebarLogo
    }
  }
}
</script>
