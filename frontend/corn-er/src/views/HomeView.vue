<script setup>
import TheWelcome from '@/components/TheWelcome.vue'
import Login from '@/components/login/Login.vue'
import { mapState } from 'vuex'


</script>

<template>
  <main>
    <Login />
  </main>
</template>


<script>
export default {
  setup() {
    
  },
  data() {
    return {
      stor: 22,
    }
  },

  computed: {
    ...mapState([
      'count'
    ])
  }
}
</script>