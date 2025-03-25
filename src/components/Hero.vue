<script setup>
document.addEventListener('DOMContentLoaded', () => {
  const elements = document.querySelectorAll('.scroll-animation');

  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.classList.add('visible');
      } else {
        entry.target.classList.remove('visible');
      }
    });
  });

  elements.forEach(element => {
    observer.observe(element);
  });
});
</script>

<template>
  <div class="hero">
    <div class="hero-content scroll-animation">
      <img class="portrait" src="https://backends.it.ntnu.no/user-profile-service/rest/files/6375c1c4-bde5-3ad1-aec4-7b8a5123edd0" alt="Logo" />
      <div class="hero-text">
        <h1>I'm Matti Kjellstadli</h1>
        <h2>Web Designer & Frontend Developer.</h2>
      </div>
    </div>
  </div>
</template>

<style scoped>
.hero {
  background: url("@/assets/graphics/hero-graphic.svg");
  display: flex;
  align-items: center;
  justify-content: center;
  height: 600px;
  color: black;
  text-align: center;
  margin: 0;
}

.hero-content {
  display: flex;
  align-content: center;
  justify-content: center;
  margin: 0 0 0 10rem;
  width: 60%;
}

.portrait {
  width: 300px;
  height: 300px;
  border-radius: 50%;
  margin: auto;
}

.hero-text {
  margin: auto 0 auto 2rem;
}

h1 {
  font-size: 2.5rem;
  text-align: left;
  color: #007BFF;
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