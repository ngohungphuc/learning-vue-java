<template>
  <button :class="buttonClass">
    {{ text }}
  </button>
</template>

<script>
export default {
  name: 'ActionButton',
  props: ['text'],
  data() {
    return {
      primary: true,
    }
  },
  computed: {
    buttonClass() {
      return { primary: this.primary }
    },
  },
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
