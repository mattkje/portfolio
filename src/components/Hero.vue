<script setup>
</script>

<template>
  <div class="hero">
    <div class="hero-content">
      <img class="portrait" src="https://avatars.githubusercontent.com/u/40216910?v=4" alt="Logo" />
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
</style>