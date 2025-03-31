<script setup>
import { ref, onMounted } from 'vue';

const avatarUrl = ref('');

onMounted(async () => {
  try {
    const response = await fetch('https://api.github.com/users/mattkje');
    const data = await response.json();
    avatarUrl.value = data.avatar_url;
  } catch (error) {
    console.error('Error fetching GitHub profile image:', error);
  }
});
</script>

<template>
  <div class="hero">
    <div class="floating-shapes">
      <img class="shape shape1" src="@/assets/graphics/swirl.svg"/>
      <img class="shape shape2" src="@/assets/graphics/swirl.svg"/>
    </div>
    <div class="hero-content scroll-animation">
      <div class="portrait-container">
        <div class="portrait-box">
          <div class="floating-planets">
            <img class="planet planet1" src="@/assets/graphics/ball.svg"/>
            <img class="planet planet2" src="@/assets/graphics/ball.svg"/>
            <img class="planet planet3" src="@/assets/graphics/ball.svg"/>
          </div>
          <img class="portrait"
               :src="avatarUrl"
               alt="Logo"/>

        </div>
      </div>
      <div class="hero-text">
        <h1>I'm Matti Kjellstadli</h1>
        <h2>Web Designer & Frontend Developer.</h2>
      </div>
    </div>
  </div>
</template>

<style scoped>
.hero {
  display: flex;
  align-items: center;
  justify-content: center;
  aspect-ratio: 1920 / 700;
  color: black;
  text-align: center;
  margin: 0;
}

.hero-content {
  background-image: url("@/assets/graphics/portrait-background.png");
  background-size: contain;
  background-repeat: no-repeat;
  background-position: left;
  display: flex;
  align-content: center;
  justify-content: center;
  object-fit: contain;
  margin: 0 0 0 10rem;
  width: 60%;
  height: 70%;
}

.portrait-container {
  width: 60%;
  height: 60%;
}

.portrait-box {
  position: relative;
  width: 100%;
  padding-top: 100%; /* 1:1 Aspect Ratio */
  overflow: hidden;
}

.portrait {
  position: absolute;
  top: 20%;
  left: 20%;
  transform: translate(-50%, -50%);
  width: 60%;
  height: 60%;
  border-radius: 50%;
  animation: float 30s ease-in-out infinite;
  box-shadow: 0 0 40px rgba(0, 0, 0, 0.2);
}

@keyframes float {
  0%, 100% {
    transform: translateY(0) translateX(0);
  }
  25% {
    transform: translateY(-10px) translateX(10px);
  }
  50% {
    transform: translateY(0) translateX(-10px);
  }
  75% {
    transform: translateY(10px) translateX(10px);
  }
}

.floating-shapes {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.floating-planets {
  position: absolute;
  top: 20%;
  left: -30%;
  width: 100%;
  height: 100%;
}

.shape {
  position: absolute;
  width: 10rem;
  height: 10rem;
  transition: transform 0.3s ease-in-out;
  animation: swirl 30s ease-in-out infinite;
}

@keyframes swirl {
  0%, 100% {
    transform: translateY(0) rotateZ(-10deg);
  }
  50% {
    transform: translateY(-10px) rotateZ(10deg);
  }
}

.planet {
  position: absolute;
  width: 15%;
  animation: floatAndSwirl 20s ease-in-out infinite;
  transition: transform 0.3s ease-in-out;
}

@keyframes floatAndSwirl {
  0%, 100% {
    transform: translateY(0) translateX(0) rotateZ(0);
  }
  25% {
    transform: translateY(-10px) translateX(10px) rotateZ(20deg);
  }
  50% {
    transform: translateY(0) translateX(-10px) rotateZ(0deg);
  }
  75% {
    transform: translateY(10px) translateX(10px) rotateZ(-20deg);
  }
}

.planet1 {
  top: 0;
  left: 100%;
  rotate: 90deg;
  scale: 0.9;
  animation-delay: 0s;
}

.planet2 {
  top: 56%;
  left: 70%;
  rotate: -90deg;
  scale: 1.1;
  animation-delay: 2.5s;
}

.planet3 {
  top: 30%;
  left: 40%;
  animation-delay: 2.5s;
}

@keyframes orbit {
  0% {
    transform: rotate(0deg) translateX(10rem) rotate(0deg);
  }
  100% {
    transform: rotate(360deg) translateX(10rem) rotate(-360deg);
  }
}

.shape1 {
  top: 50%;
  left: 10%;
  rotate: 90deg;
  animation-delay: 0s;
}

.shape2 {
  top: 20%;
  right: 10%;
  rotate: 90deg;
  animation-delay: 5s;
}

.shape3 {
  top: 80%;
  left: 20%;
}

.hero-text {
  font-size: 2vw; /* Adjust the value as needed */
  margin: auto 0 auto 2rem;
}

h1 {
  font-size: 2.5rem;
  text-align: left;
  color: #608AFF;
  font-weight: 900;
  margin-bottom: 0;
}

h2 {
  text-align: left;
  margin-top: 0;
  font-weight: 900;
  font-size: 2.5rem;
}

p {
  font-size: 1.25rem;
}

.scroll-animation {
  opacity: 0;
  transform: translateY(20px);
  transition: opacity 0.6s ease-out, transform 0.6s ease-out;
}

.scroll-animation.visible {
  opacity: 1;
  transform: translateY(0);
}
</style>