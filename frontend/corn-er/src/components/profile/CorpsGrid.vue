<script setup>
    import axios from 'axios'
</script>

<template>
    <div class="container">
         <div>
            <vue-final-modal v-model="showModal" classes="modal-container dark-mode" content-class="modal-content">
            <button class="modal__close" @click="showModal = false">
                &#10006;
            </button>
            <span class="modal__title">Nova kultura</span>
            <div class="modal__content">

                <div>
                    <input type="radio" v-model="newCorp.plantType" name="corp-type" id="CORN" value="CORN">
                    <label for="CORN"> Kukuruz</label>
                </div>
                
                <div>
                    <input type="radio" v-model="newCorp.plantType" name="corp-type" id="WHEAT" value="WHEAT">
                    <label for="WHEAT"> Pšenica</label>
                </div>

                <div>
                    <input type="radio" v-model="newCorp.plantType" name="corp-type" id="SOY" value="SOY">
                    <label for="SOY"> Soja</label>
                </div>


                <label for="psw"><b>Naziv (identifikator)</b></label>
                <input type="text" v-model="newCorp.name" name="" id="">

                <label for="psw"><b>Datum sejanja</b></label>
                <input type="date" v-model="newCorp.planted" name="" id="">


            </div>
            <div class="modal__action">
                <button class="btn gray-btn" @click="showModal = false">cancel</button>
                <button class="btn green-btn" @click="createCorp">confirm</button>
            </div>
            </vue-final-modal>
        </div>
                
        <div class="corps">
            <div v-for="plant in allPlants" :key="plant.id" class="corp-box">
                <router-link :to="{ name: 'plant', params: { id: user_id, plant_id: plant.id } }"  class="crop-title stretched-link">{{plant.name}}</router-link>
            </div>



            <div class="corp-box">
                <a class="crop-title-plus stretched-link" @click="showModal = true">+</a>
            </div>
        </div>
    </div>
</template>

<script>
export default {

    setup() {
        const route = useRoute();
        // const id = computed(() => route.params.id);
    },

    data: () => ({
        showModal: false,


        newCorp: {
            plantType: 'CORN',
            name: "Kukuruz",
            planted: new Date().toISOString().slice(0,10)
        },

        allPlants: []

    }),

    computed: {
        user_id() {
            return this.$route.params.id;
        },
        plant_id() {
            return this.$route.params.plant_id
        },
    },

    methods: {
        openModalExample() {
            this.$vfm.show('example')
        },


        async createCorp() {
            await axios.post("http://localhost:8080/plants", this.newCorp);
            this.loadPlants();
            this.showModal = false;
        },

        async loadPlants() {
            let result = await axios.get("http://localhost:8080/plants");
            this.allPlants = result.data;
        }
    },

    created() {
        this.loadPlants();
    }

    
}
</script>

<style>

.corps {
    display: flex;
    flex-wrap: wrap;
}

.corp-box {
    position: relative;
    min-width: 100px;
    height: 100px;
    background-color: rgb(40, 40, 40);
    border: 1px solid rgb(65, 65, 65);
    margin-right: 1em;
    margin-bottom: 1em;
}


.corp-box .crop-title {
    padding: 0.3em;
    text-align: center;
    margin-top: 30px;
    display: block;
}


.corp-box .crop-title-plus {
    text-align: center;
    margin-top: 10px;
    font-size: 3em;
    font-weight: bold;
    display: block;
    cursor: pointer;
}

.corp-box:hover {
    background-color: rgb(55, 55, 55);
}
</style>

<style scoped>
::v-deep .modal-content {
  display: inline-block;
  padding: 1rem;
  border: 1px solid #2d3748;
  border-radius: 0.25rem;
  background: #1a202c;
}
.modal__title {
  font-size: 1.5rem;
  font-weight: 700;
}
</style>

<style scoped>
::v-deep .modal-container {
  display: flex;
  justify-content: center;
  align-items: center;
}
::v-deep .modal-content {
  position: relative;
  display: flex;
  flex-direction: column;
  max-height: 90%;
  margin: 0 1rem;
  padding: 1rem;
  border: 1px solid #2d3748;
  border-radius: 0.25rem;
  background: #1a202c;
}
.modal__title {
  margin: 0 2rem 0 0;
  font-size: 1.5rem;
  font-weight: 700;
}
.modal__content {
  flex-grow: 1;
  overflow-y: auto;
}
.modal__action {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-shrink: 0;
  padding: 1rem 0 0;
}
.modal__close {
    background: none;
    border: none;
    position: absolute;
    color: rgb(195, 195, 195);
    cursor: pointer;
    /* font-weight: bold; */
    font-size: 1.2em;
    top: 0.5rem;
    right: 0.5rem;
}
</style>

<style scoped>
.dark-mode div::v-deep .modal-content {
  border-color: #2d3748;
  background-color: #1a202c;
}
</style>