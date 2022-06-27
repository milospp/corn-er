<script setup>
    import axios from 'axios'
</script>


<template>
    <div v-if="plant_id" :key="$route.params.plant_id">
        <div class="input-status"></div>
        
        

        <div class="d-flex">
            
        </div>
        <div class="corp-info">
            <table>
                <tr>
                    <th>Naziv: </th>
                    <td>{{plant.name}}</td>
                </tr>
                <tr>
                    <th>TIP: </th>
                    <td>{{plant.plantType}}</td>
                </tr>
                <tr>
                    <th>Posejano dana: </th>
                    <td>{{plant.planted}}</td>
                </tr>
            </table>
        </div>

        <hr>
        <h3>Istorija tretiranja</h3>
        <table>
            <tr>
                <td>Tretiranje</td>
            </tr>
            <tr v-for="treatment in plant.treatments" :key="treatment.id">
                <td>
                    {{treatment}}
                </td>
            </tr>
        </table>



        <hr>
        <h3>Istorija merenja zemljista</h3>
        <table>
            <tr>
                <td>Merenja</td>
            </tr>
            <tr v-for="measurement in plant.soilMeasurements" :key="measurement.id">
                <td>
                    {{measurement.ph}}    --- {{measurement.datetime}}
                </td>
            </tr>
        </table>

        <hr>
        
        <div class="d-flex">

            <div class="sympthoms-select">
                <h2>Simptomi biljke</h2>
                <select name="" id="" v-model="sympthoms" multiple>
                    <option value="DRY_LEAFS">Suvo lisce</option>
                    <option value="GRAY_LEAF_SPOT">Sive pege</option>
                    <option value="COMMON_RUST">Budj</option>
                    <option value="SOUTHERN_RUST">Crne tackice</option>
                    <option value="TAR_SPOT">CRNE MRLJE</option>
                    <option value="RED_LEAFS">Crvenilo na liscu</option>
                    <option value="SHOT_HOLES">Rupice na listu</option>
                    <option value="DEAD_PLANT">Mrtva biljak</option>
                    <option value="ROOT_DAMAGE">Ostecen koren</option>
                    <option value="SMALL_LAYED_EGG">Polozena jaja</option>
                    <option value="WHITE_MASS_LEAFS">Mela masa na liscu</option>
                    <option value="WHITE_MASS_STALK">mela masa na stablu</option>
                    <option value="EATEN_LEAF">Pojedeno lisce</option>
                    <option value="EATEN_COB">Pojeden plod</option>
                    <option value="HOLE_COB">Ruepe u plodu</option>
                    <option value="CATERPILLAR">Gusenica</option>
                    <option value="BUTTERFLY_LIKE">Leptir (nalik na leptir)</option>
                </select>
            </div>

            <div class="pest-select">
                <h2>Prepoznata zivotinja</h2>
                <select name="" id="" v-model="pestAttributes" multiple>
                    <option value="WORM">Crv</option>
                    <option value="BUTTERFLY">Leptir</option>
                    <option value="LEGS2">2 noge</option>
                    <option value="LEGS4">4 noge</option>
                    <option value="LEGS6">6 nogu</option>
                    <option value="LEGS8">8 nogu</option>
                    <option value="ANTENA">antene</option>
                    <option value="BLACK">Crn</option>
                    <option value="GRAY">Sivi</option>
                    <option value="GOLD">Zlatna boja</option>
                    <option value="DOTTED">Tačkice</option>
                    <option value="INCH1">1cm</option>
                    <option value="INCH2">2cm</option>
                    <option value="INCH4">5cm</option>
                </select>

                <button class="green-btn pest-button">Rezonuj zivotinju</button>
            </div>

            <div class="ph-input">
                <h2>Novo ph merenje</h2>
                <input type="number" v-model=ph min="0" max="12" step="0.1" name="" id="">
            </div>


        </div>

        <button class="green-btn start-reasoning" @click="fireMainDrool">Obradi simptome</button>

        <div>

            <hr>
            <h3>Stadijum: {{plant.growStage}}</h3>
            <br />
            <h3 v-if="plant.currentDiagnose">Dijagnoza: {{plant.currentDiagnose}}</h3>
            <h3 v-if="plant.currentPestDiagnose">Dijagnoza (Zivotinja): {{plant.currentPestDiagnose}}</h3>
            <br />
            <table>
                <tr>
                    <th>Tretiranje</th>
                </tr>
                <tr v-for="treatment in plant.treatmentsSugestion" :key="treatment.id">
                    <td>
                        {{treatment}}
                    </td>
                </tr>
            </table>

            <h5>{{plant.description}}</h5>
        </div>
    </div>


</template>

<script>
export default {

    data() {
        return {
            plant: {

            },

            pestAttributes: [],
            sympthoms: [],
            ph: 7
        }
    },

    computed: {
        user_id() {
            return this.$route.params.id;
        },
        plant_id() {
            this.loadPlant(this.$route.params.plant_id);
            return this.$route.params.plant_id
        },

    },

    methods: {
        async loadPlant(id) {
            if (id == null && !this.plant_id) return null;
            if (!id) id = this.plant_id 

            let result = await axios.get("http://localhost:8080/plants/" + id);
            this.plant = result.data
            return result.data;        
        },

        async fireMainDrool(id) {
            let data = {
                plantId: this.plant_id,
                symptoms: this.sympthoms,
                pestAttributes: this.pestAttributes,
                ph: this.ph
            }

            let result = await axios.post(`http://localhost:8080/plants/${this.plant_id}/calculate`, data);
            console.log(result);
            this.plant = result.data;
        }
    },

    updated() {
        // this.loadPlant();
    },

    created() {
        this.loadPlant();
        
    },
    beforeRouteUpdate(to, from, next) {
        // Call the API query method when the URL changes
        this.getContent(to.params.uid)
        next()
    }
}
</script>

<style>


.sympthoms-select {
    margin-right: 1em;
}

.sympthoms-select select {
    width: 200px;
    height: 300px;
}


.pest-select {
    margin-right: 1em;
}

.pest-select select {
    width: 200px;
    height: 245px;

}

.pest-button {
    margin: 0 !important;
    background-color: rgb(109, 114, 108) !important;
}

.start-reasoning {
    margin-top: 1em;
}
</style>

<style scoped>
    table th {
        text-align: left;
    }

    table td {
        padding-left: 1em;
        text-align: left;
    }
</style>