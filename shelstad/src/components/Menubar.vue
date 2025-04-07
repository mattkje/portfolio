<script setup>
import {ref, watch, onMounted} from 'vue';
import {useDark, useToggle} from '@vueuse/core';

const isDark = useDark();


const updateTheme = () => {
  const theme = isDark.value ? 'main-dark.css' : 'main.css';
  let link = document.getElementById('theme-stylesheet');

  if (!link) {
    link = document.createElement('link');
    link.id = 'theme-stylesheet';
    link.rel = 'stylesheet';
    document.head.appendChild(link);
  }

  link.href = `/src/assets/${theme}`;


};

watch(isDark, updateTheme);

onMounted(() => {
  updateTheme();
});
</script>

<template>
  <nav class="menubar">
    <div class="menu-links">
      <router-link class="nav-link" to="/">Home</router-link>
      <router-link class="nav-link" to="/tools">Apps</router-link>
      <router-link class="nav-link" to="/games">Games</router-link>
      <router-link class="nav-link" to="/icons">Icons</router-link>
    </div>
  </nav>
</template>

<style scoped>
.logo {
  height: 50px;
}

.menu-links {
  list-style: none;
  display: flex;
  padding: 1rem;
  gap: 5rem;
}

.menu-links a {
  font-weight: bold;
  text-decoration: none;
  transition: transform 0.3s;
}

.menu-links a:hover {
  transform: scale(1.1);
}

button {
  padding: 0.7rem 1.2rem;
  border-radius: 1.5rem;
  background-color: hsla(210, 100%, 50%, 1);
  color: #fff;
  cursor: pointer;
  border: none;
}
</style>
