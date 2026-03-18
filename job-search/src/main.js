import { createApp } from 'vue'
import App from './App.vue'
import '@/index.css'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faSearch } from '@fortawesome/free-solid-svg-icons'
import router from '@/router'
import { createPinia } from 'pinia'

const pinia = createPinia()
library
  .add(faSearch)
  .use(pinia)
  .createApp(App)
  .use(router)
  .component('font-awesome-icon', FontAwesomeIcon)
  .mount('#app')
