<template>
    <div class="py-5 bg-dark text-white">
        <div>
            <h1 class="text-center text-warning">FOTOGRAFIA EUROPA</h1>
        <ul class="d-flex flex-wrap">
            <li class="col-4 my-4" v-for="foto in fotos" :key="foto.id" >
                <h3><strong>{{ foto.titolo }}</strong></h3>
                <img :src="foto.url" :alt="foto.titolo" />
                <p>{{ foto.descrizione }}</p>
                    <h4>Category</h4>
                    <ul>
                        <li v-for="cat in foto.categories" :key="cat.id">
                        {{ cat.nome }}
                        </li>
                    </ul> 
            </li>
        </ul>
        </div>
    
    </div>
    
</template>

<script>
import axios from 'axios';
const api_url = 'http://localhost:8080/api/1/foto';
export default {
  name: "FotoComp",
  data() {
    return {
        serverError: false,
      fotos: [],
   
    };
  },
   methods: {
    getAllPhotos() {
			axios.get(api_url + '/all')
				.then(res => {
					const fotos = res.data;
                    this.fotos = fotos;
				})
				.catch(() => this.serverError = true)
		},
  },
  mounted() {
		this.getAllPhotos();
	}
}
</script>


<style>
ul{
    list-style-type: none;
}
</style>



