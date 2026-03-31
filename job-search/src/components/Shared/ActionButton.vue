<template>
  <button :class="buttonClass">
    {{ text }}
  </button>
</template>

<script>
import { toRef, computed } from 'vue'
export default {
  name: 'ActionButton',
  props: {
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
  },
  setup(props) {
    const { type } = toRef(props)
    const butonClass = computed(() => {
      return {
        [type.value]: true,
      }
    })

    return { butonClass }
  },
}
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
