<template>
  <HomePhoto />
</template>

<script>
import HomePhoto from './components/HomePhoto.vue'

export default {
  name: 'App',
  components: {
    HomePhoto
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
