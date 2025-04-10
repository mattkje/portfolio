<script setup lang="ts">
import { ref } from 'vue';

const welcomeMessage = ref('Welcome to Shelstad Studios!');

</script>

<template>
  <div class="home">
    <div class="home-items">
      <img src="../assets/images/game/shelstad-color.svg" alt="Shelstad Studios Logo" class="main-logo" />
      <h1>{{ welcomeMessage }}</h1>
      <p>Independent Solo Developer</p>
    </div>
    <div class="update-box">
      <h2>Welcome!</h2>
      <p>Thank you for visiting my project website. Here, you can explore my projects and games.</p>
      <p>Feel free to look around and discover my work! Most of the downloads are free</p>
      <p>Best regards,</p>
      <p>Matt</p>
      <h2>Socials</h2>
      <div class="social-icons">
        <a href="https://www.youtube.com/@Shelstad" target="_blank" rel="noopener noreferrer">
          <img src="../assets/icons/youtube.svg" alt="YouTube" />
        </a>
        <a href="https://github.com/mattkje" target="_blank" rel="noopener noreferrer">
          <img src="../assets/icons/github.svg" alt="GitHub" />
        </a>
        <a href="https://www.linkedin.com/in/matti-kjellstadli-39a0a028a" target="_blank" rel="noopener noreferrer">
          <img src="../assets/icons/linkedin.png" alt="LinkedIn" />
        </a>
      </div>
    </div>
  </div>
</template>

<style scoped>
html, body {
  height: 100%;
  margin: 0;
}

.home {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  margin: auto;
}

.home-items {
  position: absolute;
}

.main-logo {
  height: 200px;
}

.update-box {
  position: absolute;
  width: 20%;
  right: 2rem;
  border: 1px solid var(--border-color);
  padding: 1rem;
  border-radius: 1.5rem;
}

.social-icons {
  display: flex;
  gap: 1rem;
  width: 100%;
  justify-content: center;
}

.social-icons img {
  width: 40px;
  height: 40px;
  object-fit: contain;
  filter: brightness(0);
  transition: transform 0.3s ease, filter 0.3s ease;
}

.social-icons img:hover {
  transform: scale(1.1);
  filter: brightness(1);
}
</style>