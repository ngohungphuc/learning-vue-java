<template>
  <main class="flex-auto bg-brand-gray-2 p-8">
    <ol>
      <job-listing v-for="job in displayedJobs" :key="job.id" :job="job" />
    </ol>

    <div class="mx-auto mt-8">
      <div class="flex flex-row flex-nowrap">
        <p class="flex-grow text-sm">Page {{ currentPage }}</p>

        <div class="flex items-center justify-center">
          <router-link
            v-if="previousPage"
            role="link"
            :to="{ name: 'JobResults', query: { page: previousPage } }"
            class="mx-3 text-sm font-semibold text-brand-blue-1"
          >
            Previous
          </router-link>

          <router-link
            v-if="nextPage"
            role="link"
            :to="{ name: 'JobResults', query: { page: nextPage } }"
            class="mx-3 text-sm font-semibold text-brand-blue-1"
          >
            Next
          </router-link>
        </div>
      </div>
    </div>
  </main>
</template>

<script setup>
import { computed, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import JobListing from '@/components/JobResults/JobListing.vue'
import { useJobsStore } from '@/stores/jobs'

const route = useRoute()
const jobsStore = useJobsStore()

const currentPage = computed(() => Number.parseInt(route.query.page || '1'))

const previousPage = computed(() => {
  const prevPage = currentPage.value - 1
  const firstPage = 1
  return prevPage >= firstPage ? prevPage : undefined
})

const nextPage = computed(() => {
  const nextPg = currentPage.value + 1
  const maxPage = Math.ceil(jobsStore.FILTERED_JOBS.length / 10)
  return nextPg <= maxPage ? nextPg : undefined
})

const displayedJobs = computed(() => {
  const pageNumber = currentPage.value
  const firstJobIndex = (pageNumber - 1) * 10
  const lastJobIndex = pageNumber * 10
  return jobsStore.FILTERED_JOBS.slice(firstJobIndex, lastJobIndex)
})

onMounted(() => {
  jobsStore.FETCH_JOBS()
})
</script>
