<template>
  <div>
   <a href="http://localhost:8080/photo"><h1>ADMIN</h1></a>
   <div class="mt-4 ms_container">
    <div class="row pb-5">
      <div class="col-12 d-flex justify-content-between">
        <h1 class="text-primary mb-2">Le mie foto</h1>
      </div>
      <div class="p-3 col-12" v-for="photo in photos"  :key="photo.id" 
      :class="(photo.visible ? ' ' : 'd-none')">
        <div  class="card px-0 ms_bg_light_dark text-white h-100" >
          <div v-if="photo.visible">
            <img class="card-img-top img-fluid" :src="photo.imgUrl" alt="Card image cap ">
            <div class="card-body">
              <div class="d-flex justify-content-between">
                <h5 class="card-title text-primary">{{photo.title}}</h5>
                <span class="bg-primary rounded text-white p-2 mb-3 d-inline-block"> {{photo.tag}}</span>
              </div>
              <p class="card-text"><strong>Descrizione: </strong> {{photo.description}}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import axios from 'axios';
const API_URL = 'http://localhost:8080/api/1/';
export default {
  name: 'HomePhoto',
  data() {
    return {
      photos: [],
    }
  },
  methods: {
    getPhotos() {
      axios.get(API_URL + 'photos')
        .then(response => {
          this.photos = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
  },
  mounted() {
    this.getPhotos();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
