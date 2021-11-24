<template>
  <div id="app">
    <img src="./assets/logo.png">
    <layout>
      <router-view />
    </layout>
  </div>
</template>

<script>
import Layout from '@/layout/Layout'
export default {
  name: 'App',
  components: {
    Layout
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
