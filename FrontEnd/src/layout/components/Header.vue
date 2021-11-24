<template>
  <div id="nav">
    <router-link class="menu" to="/">Home</router-link>
    <router-link class="menu" to="/about">About</router-link>
  </div>
</template>

<script>
export default {
}
</script>

<style>
#nav {
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}

#nav .menu{
  color: white;
  padding: 0px;
  margin: 10px;
  text-decoration: none;
}
</style>