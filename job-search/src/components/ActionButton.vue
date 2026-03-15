<template>
  <button :class="primary">
    {{ text }}
  </button>
</template>

<script>
export default {
  name: 'ActionButton',
  props: ['text'],
}
</script>

<style scoped>
@reference "../index.css";
button {
  @apply rounded px-5 py-3 font-medium;
}

.primary {
  @apply border-1 bg-brand-blue-1 text-white hover:shadow-blue;
}

.secondary {
}
</style>
