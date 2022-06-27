<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from '@/components/HelloWorld.vue'
</script>

<template>

  <RouterView />
</template>

<style>
@import '@/assets/base.css';

*, ::after, ::before {
    box-sizing: border-box;
}

#app {
  max-width: 1280px;
  margin: 0 auto;
  padding: 2rem;

  font-weight: normal;
}

header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

a,
.green {
  text-decoration: none;
  color: hsla(160, 100%, 37%, 1);
  transition: 0.4s;
}


body {
  display: flex;
  place-items: centerw;
}


input[type=text], input[type=password], input[type=date], input[type=number] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  font-family: inherit;
}

/* Set a style for all buttons */
button.green-btn {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  border: none;
  cursor: pointer;
  display: block;
  width: 100%;
}

button.btn {
  color: white;
  padding: 14px 20px;
  border: none;
  cursor: pointer;
  display: block;
  width: 100%;
}

button.green-btn {
  background-color: #04AA6D;
}

button.gray-btn {
  background-color: #4b4a4a;
}





button:hover {
  opacity: 0.8;
}


.stretched-link::after {
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    z-index: 1;
    pointer-events: auto;
    content: "";
}
</style>
