import { createStore } from 'vuex'
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/vuex.js'
import vfmPlugin from 'vue-final-modal'



const app = createApp(App)


app.use(router)
app.use(store)
app.use(vfmPlugin)


app.mount('#app')
