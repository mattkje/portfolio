<script setup lang="ts">
import { onMounted, ref } from 'vue'

const showContent = ref(false)

onMounted(() => {
  setTimeout(() => {
    showContent.value = true
  }, 100)
})
</script>

<template>
  <div class="about-wrapper">
    <div class="about-container" v-show="showContent" v-motion-fade>
      <img
          src="@/assets/images/game/shelstad-color.svg"
          alt="Shelstad Studios Logo"
          class="about-logo"
      />
      <h1 class="about-title">About Shelstad Studios</h1>
      <transition-group name="fade-up" tag="div">
        <p key="p1" class="about-text">
          Welcome to Shelstad Studios! This site is created and maintained by a solo developer passionate about building innovative tools, games, and applications.
        </p>
        <p key="p2" class="about-text">
          Here, you'll find all my major personal projects – including apps, games, and free-to-use custom icons.
        </p>
        <p key="p3" class="about-text">
          Thanks for visiting and supporting this creative journey!
        </p>
      </transition-group>
    </div>
  </div>
</template>

<style scoped>
.about-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 6rem;
}

.about-container {

  border-radius: 2rem;
  padding: 2rem;
  max-width: 600px;
  width: 100%;
  text-align: center;
  background: rgba(255, 255, 255, 0.05);
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
  backdrop-filter: blur(10px);
  border: 1px solid var(--border-color);
}

.about-logo {
  width: 80px;
  height: 80px;
  margin-bottom: 1rem;
  border-radius: 50%;
}

.about-title {
  font-size: 2.5rem;
  margin-bottom: 1rem;
  transition: 0.3s ease;
}

.about-title.hover-glow:hover {
  color: #7bdff2;
  text-shadow: 0 0 10px #7bdff2;
}

.about-text {
  font-size: 1.1rem;
  line-height: 1.6;
  margin: 1rem 0;
  transition: all 0.3s ease;
}

.fade-up-enter-active {
  transition: all 0.6s ease;
}
.fade-up-enter-from {
  opacity: 0;
  transform: translateY(20px);
}
</style>
