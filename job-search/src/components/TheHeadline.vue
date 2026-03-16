<template>
  <section>
    <h1>{{ action }} for everyone</h1>
    <h2>Find your next job at</h2>
  </section>
</template>

<script>
export default {
  name: 'TheHeadLine',
  data() {
    return {
      action: 'Build',
      interval: null,
    }
  },
  created() {
    this.changedTitle()
  },
  beforeUnmount() {
    clearInterval(this.interval)
  },
  methods: {
    changedTitle() {
      this.interval = setInterval(() => {
        const actions = ['Build', 'Create', 'Design', 'Code']
        const currentActionindex = actions.indexOf(this.action)
        const nextActionIndex = (currentActionindex + 1) % 4
        const nextAction = actions[nextActionIndex]
        this.action = nextAction
      }, 500)
    },
  },
}
</script>
