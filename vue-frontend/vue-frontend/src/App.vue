<template>
  <div id="app">
    <div>
    <h1>FOTOGRAFIA TONINO</h1>
    <ul>
      <li
        v-for="foto in foto"
        :key="foto.id"
      >{{ foto.titolo }}
      </li>
    </ul>
  </div>
  </div>
</template>

<script>
import axios from 'axios';
const API_URL = "http://localhost:8080/api/1";

export default {
  name: 'App',
  components: {
   
  },
  data() {
    return {
      foto: [],
   
    };
  },
  mounted() {
    axios.get(API_URL + '/foto/all')
         .then(res => {
     
        const foto = res.data;
        if (foto == null) return;
        this.foto= foto;
    });
  }}
</script>

<style lang="scss">

</style>
