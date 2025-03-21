<script setup>
import { ref } from 'vue';

const searchQuery = ref('');
const handleSearch = () => {
  console.log('Search query:', searchQuery.value);
};
</script>

<template>
  <nav class="menubar">
    <img src="@/assets/images/game/shelstad-light.svg" alt="Shelstad Studios Logo" class="logo" />
    <ul class="menu-links">
      <li><a href="/">Home</a></li>
      <li><a href="/all-games">All Games</a></li>
    </ul>
    <div class="search-bar">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Search games..."
      />
      <button @click="handleSearch">Search</button>
    </div>
  </nav>
</template>

<style scoped>
.menubar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 1rem;
  background-color: #333;
  color: #fff;
}

.logo {
  height: 50px;
}

.menu-links {
  list-style: none;
  display: flex;
  gap: 1rem;
}

.menu-links a {
  color: #fff;
  text-decoration: none;
}

.search-bar {
  display: flex;
  align-items: center;
}

.search-bar input {
  padding: 0.5rem;
  border: none;
  border-radius: 4px;
}

.search-bar button {
  padding: 0.5rem 1rem;
  border: none;
  border-radius: 4px;
  background-color: #42b983;
  color: #fff;
  cursor: pointer;
  margin-left: 0.5rem;
}
</style>