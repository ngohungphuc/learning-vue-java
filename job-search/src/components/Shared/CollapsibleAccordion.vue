<template>
  <div class="border-b border-solid border-brand-gray-2 py-5">
    <div
      class="flex cursor-pointer flex-wrap items-center justify-between"
      role="button"
      @click="open"
    >
      <h3 class="text-base font-semibold">{{ header }}</h3>

      <font-awesome-icon :icon="caretIcon" />
    </div>

    <div v-if="isOpen" class="mt-5 w-full">
      <slot>
        <p>Whoops, somebody forgot to populate me!</p>
      </slot>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'

export default {
  name: 'CollapsibleAccordion',
  setup() {
    const header = ref('Title')
    const isOpen = ref(false)
    const open = () => {
      header.value = 'New title'
      isOpen.value = !isOpen.value
    }
    return { header, isOpen, open }
  },
  // props: {
  //   header: {
  //     type: String,
  //     required: true,
  //   },
  // },
  // data() {
  //   return {
  //     isOpen: false,
  //   };
  // },
  // computed: {
  //   caretIcon() {
  //     return this.isOpen ? ["fas", "angle-up"] : ["fas", "angle-down"];
  //   },
  // },
  // methods: {
  //   open() {
  //     this.isOpen = !this.isOpen;
  //   },
  // },
}
</script>
