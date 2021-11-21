<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Test Two</h2>
    <ul>
      <li>
        <button v-on:click="testAxios">Axios Test</button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Test! Two!!', 
      posts: []
    }
  },
  methods: {
    testAxios: function () {
      const baseURI = 'http://localhost/users/3';
      this.$http.get(baseURI)
      .then((result) => {
        console.log(result)
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
