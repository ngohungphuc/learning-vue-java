import { createApp } from 'vue'
import App from './App.vue'
import '@/index.css'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faSearch, faAngleUp, faAngleDown } from '@fortawesome/free-solid-svg-icons'
import router from '@/router'
import { createPinia } from 'pinia'

// 1. Add icons to the library first
library.add(faSearch)
library.add(faAngleUp)
library.add(faAngleDown)
// 2. Create the Pinia instance
const pinia = createPinia()

// 3. Create the App instance
const app = createApp(App)

// 4. Chain the plugins and components onto the 'app' instance
app.use(pinia)
app.use(router)
app.component('font-awesome-icon', FontAwesomeIcon)

// 5. Finally, mount the app
app.mount('#app')
