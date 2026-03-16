<template>
  <div class="h-16 w-full border-b border-solid border-brand-gray-1 bg-white">
    <div class="flex h-full items-center px-8">
      <div><font-awesome-icon :icon="['fas', 'search']" class="mr-3"></font-awesome-icon></div>
      <span><span class="text-brand-green-1"> x</span> jobs matched</span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Subnav',
}
</script>
