<template>
  <div>
    <ul>
      <li v-for="foto in foto" :key="foto.id">
               <strong>{{ foto.name }}</strong>
               <strong>{{ foto.descrizione }}</strong>
              <img :src="foto.url">
      </li>
    </ul>
  </div>
  
</template>

<script>
import axios from 'axios';

const API_URL = "http://localhost:8080/api/1"
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
   mounted() {
    axios.get(API_URL + '/foto/all')
         .then(res => {
     
        const foto = res.data;
        if (foto == null) return;
        this.foto = foto;
    });
   
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">

</style>
