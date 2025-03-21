<script setup>
import { ref } from 'vue';

const searchQuery = ref('');
const handleSearch = () => {
  console.log('Search query:', searchQuery.value);
};
</script>

<template>
  <nav class="gameMenubar">
    <img src="@/assets/images/game/shelstad-color.svg" alt="Shelstad Studios Logo" class="logo" />
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
.gameMenubar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 1rem;
  background-color: white;
  border-bottom: #e3e3e3 solid 1px;
  color: #000;
}

.logo {
  height: 50px;
}

.menu-links {
  list-style: none;
  display: flex;
  gap: 5rem;
}

.menu-links a {
  color: #0071FF;
  font-weight: bold;
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
  border: none;
  padding: 0.7rem 1.2rem;
  border-radius: 1.5rem;
  background-color: hsla(210, 100%, 50%, 1);
  color: #fff;
  cursor: pointer;
  margin-left: 0.5rem;
}
</style>