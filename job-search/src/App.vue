<template>
  <div>
    <MainNav></MainNav>
    <SubNav></SubNav>
  </div>
  <router-view />
</template>

<script>
import MainNav from '@/components/Navigation/MainNav.vue'
import SubNav from './components/Navigation/SubNav.vue'
export default {
  name: 'App',
  components: { MainNav, SubNav },
}
</script>
