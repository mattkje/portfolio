<script setup>
</script>

<template>
  <nav class="menubar">
    <div class="logo">
      <img src="@/assets/images/mk.png" alt="Logo" />
    </div>
    <ul class="nav-links">
      <li><router-link to="/">Home</router-link></li>
      <li><router-link to="/about">About</router-link></li>
      <li><router-link to="/projects">Projects</router-link></li>
      <li><router-link to="/contact">Contact</router-link></li>
    </ul>
  </nav>
</template>

<style scoped>
.menubar {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 1rem 2rem;
  color: black;
}

.logo img {
  height: 50px;
  padding: 0 5rem;
}

.nav-links {
  list-style: none;
  display: flex;
  justify-content: space-between;
  width: 40%;
  gap: 1.5rem;
}

.nav-links a {
  color: black;
  text-decoration: none;
  font-size: 1rem;
  transition: color 0.3s;
}

.nav-links a:hover {
  color: #00bfa5;
}
</style>