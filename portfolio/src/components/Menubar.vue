<script setup>
</script>

<template>
  <nav class="menubar">
    <ul class="menu-links">
      <img class="logo" src="@/assets/logo.svg" alt="Logo" />
      <router-link class="nav-link" to="/">Home</router-link>
      <router-link class="nav-link" to="/projects">Projects</router-link>
      <router-link class="nav-link" to="/about">CV</router-link>
    </ul>
  </nav>
</template>

<style scoped>
.menubar {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 5rem;
  color: #18212c;
  background-color: white;
}

.logo {
  height: 50px;
}

.menu-links {
  list-style: none;
  display: flex;
  padding: 1rem;
  gap: 5rem;
  align-items: center;
}

.nav-link {
  color: #18212c;
  font-weight: bold;
  text-decoration: none;
  transition: transform 0.3s;
}

.nav-link:hover {
  color: #608AFF;
  transform: scale(1.1);
}
</style>