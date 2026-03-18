import JobResultsView from '@/views/JobResultsView.vue'
import HomeView from '@/views/HomeView.vue'
import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView,
  },
  {
    path: '/jobs/results',
    name: 'JobResults',
    component: JobResults,
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes,
})

export default router
