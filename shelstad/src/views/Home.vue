<script setup>
import { ref } from 'vue';

const welcomeMessage = ref('Welcome to Shelstad Studios!');
</script>

<template>
  <div class="home">
    <div class="home-items">
      <img src="../assets/images/game/shelstad-color.svg" alt="Shelstad Studios Logo" class="main-logo" />
      <h1>{{ welcomeMessage }}</h1>
      <p>Independent solo developer</p>
      <div class="links">
        <router-link to="/games" class="link-button">View Games</router-link>
        <router-link to="/icons" class="link-button">View Icons</router-link>
      </div>
    </div>
  </div>
</template>

<style scoped>

html, body {
  height: 100%;
  margin: 0;
}

.home-items {
  margin: 10rem auto 0 auto;
}

.main-logo {
  height: 200px;
}

.links {
  display: flex;
  justify-content: center;
  gap: 2rem;
  margin-top: 2rem;
}

.link-button {
  padding: 1rem 2rem;
  border-radius: 1.5rem;
  background-color: hsla(210, 100%, 50%, 1);
  color: white;
  text-decoration: none;
  font-weight: bold;
  transition: transform 0.3s, color 0.3s;
}

.link-button:hover {
  transform: scale(1.1);
}
</style>