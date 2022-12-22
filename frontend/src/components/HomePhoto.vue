<template>
  <div>
   <div class="mt-4 container">
    <div class="row pb-5">
    <form class="d-flex" role="search">
        <input
          class="form-control"
          placeholder="Search"
          aria-label="Search"
           type="text"
           v-model="searchValue"
        />
        <button class="btn btn-primary ms-2" type="submit" @keyup="getFilteredPhotos()">
          Search
        </button>
      </form>
      <div class="p-3 col-6" v-for="photo in photos"  :key="photo.id" 
      :class="(photo.visible ? ' ' : 'd-none')">
        <div  class="card px-0 ms_bg_light_dark h-100" >
          <div v-if="photo.visible">
            <img class="card-img-top img-fluid" :src="photo.imgUrl" alt="{{photo.title}}">
            <div class="card-body">
              <div class="d-flex justify-content-between">
                <h5 class="card-title">{{photo.title}}</h5>
                <span class="p-2 mb-3 d-inline-block"> {{photo.tag}}</span>
              </div>
              <p class="card-text">Descrizione: {{photo.description}}</p>
            </div>
            <div class="m-3">
                <h4>Comments</h4>
                <ul>
                    <li v-for="comment in photo.comments" :key="comment.id">
                        {{ comment.text }}
                    </li>
                </ul>
              <div class="comment-input-container">
                  <input type="text" name="comment" id="comment-input" placeholder="Write a comment">
                  <button class="btn btn-primary ms-1 p-1">Send</button>
              </div>
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
      userComment: '',
      searchValue: '',
      newComment: { text: '', photo: ''},
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

      getFilteredPhotos(){
        if(this.searchValue === '') 
        
        return this.getPhotos();

        axios.get(API_URL + 'photos/search/' + this.searchValue)
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
