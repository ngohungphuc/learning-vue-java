<template>
  <button :class="buttonClass">
    {{ text }}
  </button>
</template>

<script setup>
import { toRefs, computed } from 'vue'
const props = defineProps({
  text: {
    type: String,
    required: true,
  },
  type: {
    type: String,
    required: false,
    default: 'primary',
    validator(val) {
      return ['primary', 'secondary'].includes(val)
    },
  },
})

const { type } = toRefs(props)

const buttonClass = computed(() => {
  return {
    [type.value]: true,
  }
})
</script>

<style scoped>
@reference "../../index.css";
button {
  @apply rounded px-5 py-3 font-medium;
}

.primary {
  @apply border-1 bg-brand-blue-1 text-white hover:shadow-blue;
}

.secondary {
  @apply bg-transparent text-brand-blue-1 hover:bg-brand-blue-2 hover:text-white;
}
</style>
