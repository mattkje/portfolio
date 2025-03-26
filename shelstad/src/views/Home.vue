<script setup>
import { ref } from 'vue';

const welcomeMessage = ref('Welcome to Shelstad Studios!');
</script>

<template>
  <div class="home">
    <img src="../assets/images/game/shelstad-color.svg" alt="Shelstad Studios Logo" class="main-logo" />
    <h1>{{ welcomeMessage }}</h1>
    <p>Independent solo developer</p>
    <div class="links">
      <router-link to="/games" class="link-button">View Games</router-link>
      <router-link to="/icons" class="link-button">View Icons</router-link>
    </div>
  </div>
</template>

<style scoped>

html, body {
  height: 100%;
  margin: 0;
}

.home {
  background: url("@/assets/graphics/background-home-2.svg") no-repeat 0 calc(100% + 10rem);
  background-size: calc(100% + 1rem);
  text-align: center;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}

.home img {
  margin-top: 10rem;
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