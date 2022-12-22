<template>
  <div id='App'>
    <HeaderComponent />
    <HomePhoto />
  </div>
</template>

<script>
import HomePhoto from './components/HomePhoto.vue'
import HeaderComponent from './components/partials/HeaderComponent.vue'


export default {
  name: 'App',
  components: {
    HomePhoto,
    HeaderComponent
    
  }
}
</script>

<style lang="scss">
 @import "~bootstrap/scss/bootstrap.scss";
 #App{
  background-color:#434b53;
 }
</style>
