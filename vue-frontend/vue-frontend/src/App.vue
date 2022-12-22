<template>
  <div id="app">
    <container>
      <h1 class="text-center text-warning">FOTOGRAFIA TONINO</h1>
      <ul>
        <li
           v-for="foto in foto"
          :key="foto.id" >
          <strong>{{ foto.titolo }}</strong>
          <br>
          <img :src="foto.url" :alt="foto.titolo"/>
          <br>
          <p>{{ foto.descrizione }}</p>
        </li>
      </ul>
    </container>
  </div>
</template>

<script>
import axios from 'axios';


export default {
  name: 'App',
  data() {
    return {
      foto: [],
      api_url:'http://localhost:8080/api/1',
   
    };
  },
   methods: {
    getFotoIndexById(id) {
      for (let x=0;x<this.foto.length;x++) {
        const foto = this.foto[x];
        if (foto.id == id)
          return x;
      }
      return -1;
    },
     getFotoById(id) {
      return this.foto[this.getFotoIndexById(id)];
    },


  mounted() {
    axios.get(this.api_url + '/foto/all')
         .then(res => {
     
        const foto = res.data;
        if (foto == null) return;
        this.foto= foto;
    });
  }}}
</script>

<style lang="scss">

</style>
