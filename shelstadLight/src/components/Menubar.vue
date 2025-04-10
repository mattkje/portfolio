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
      <router-link class="nav-link" active-class="active-link" to="/">
        <img src="@/assets/icons/home.svg" alt="Logo" />
        Home
      </router-link>
      <router-link class="nav-link" active-class="active-link" to="/tools">
        <img src="@/assets/icons/apps.svg" alt="Logo" />
        Apps
      </router-link>
      <router-link class="nav-link" active-class="active-link" to="/games">
        <img src="@/assets/icons/games.svg" alt="Logo" />
        Games
      </router-link>
      <router-link class="nav-link" active-class="active-link" to="/icons">
        <img src="@/assets/icons/icons.svg" alt="Logo" />
        Icons
      </router-link>
    </div>
    <div class="about">
    <router-link class="about-nav-link" active-class="active-link" to="/about">
      ?
    </router-link>
    </div>
  </nav>
</template>

<style scoped>
.logo {
  height: 50px;
}

.menu-links {
  border: 1px solid var(--border-color-2);
  border-radius: 2rem;
  padding: 0.5rem;
  list-style: none;
  display: flex;
  gap: 0.4rem;
}

.about {
  border: 1px solid var(--border-color-2);
  border-radius: 2rem;
  padding: 0.5rem;
  position: absolute;
  width: 3rem;
  right: 1rem;
  top: 0;
}

.about-nav-link {
  padding: 0.8rem;
  font-weight: bold;
  font-size: 0.8rem;
  display: flex;
  align-content: center;
  justify-content: center;
  border-radius: 2rem;
  text-decoration: none;
  transition: transform 0.3s ease-in-out, background-color 0.3s ease-in-out, filter 0.3s ease-in-out;
}

.nav-link {
  padding: 0.8rem 2rem;
  font-weight: bold;
  font-size: 0.8rem;
  display: flex;
  align-content: center;
  justify-content: center;
  border-radius: 2rem;
  text-decoration: none;
  transition: transform 0.3s ease-in-out, background-color 0.3s ease-in-out, filter 0.3s ease-in-out;
}

.nav-link:hover {
  background-color: #efefef;
}

.active-link {
  background-color: #007bff;
  color: white;
}

.active-link:hover {
  background-color: #0056b3;
}

.active-link img {
  filter: invert(1);
}
.nav-link img {
  width: 15px;
  height: 15px;
  margin-right: 0.5rem;
}


</style>
