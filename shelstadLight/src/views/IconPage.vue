<script setup lang="ts">
import {ref, computed, onMounted, getCurrentInstance} from 'vue';
import IconButton from '@/components/IconButton.vue';
import {Icon} from '@/assets/types';
import jsonData from '@/assets/data.json';

const icons = ref<Icon[] | null>(jsonData.tables.icons);

const searchQuery = ref<string>('');
const showModal = ref(false);


const filteredIcons = computed(() => {
  return icons.value.filter(icon =>
      icon.fileName.toLowerCase().includes(searchQuery.value.toLowerCase())
  );
});

</script>

<template>
  <div class="main-store-container">
    <h1>Icons</h1>
    <div class="search-bar">
      <input
          type="text"
          placeholder="Search for icons"
          v-model="searchQuery"
      />
      <div>
        <button @click="showModal = true">Can I Use These Icons?</button>
        <div v-if="showModal" class="modal-overlay" @click.self="showModal = false">
          <div class="modal-content">
            <h2>License Information</h2>
            <p>All icons are available for use under a free license.</p>
            <button @click="showModal = false">Close</button>
          </div>
        </div>
      </div>
    </div>
    <div class="icon-grid">
      <IconButton v-for="icon in filteredIcons" :key="icon.id" :icon="icon"/>
    </div>
  </div>
</template>

<style scoped>
.main-store-container {
  text-align: center;
  margin-top: 100px;
  width: auto;
}

.search-bar {
  width: 100%;
  margin: 0 auto 2rem auto;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: row;
}

.search-bar input {
  padding: 1rem;
  background: none;
  width: 100%;
  max-width: 400px;
  color: var(--text-color-1);;
  border: 2px solid var(--border-color);
  border-radius: 1rem;
}

.search-bar input::placeholder {
  color: var(--text-color-2); /* Set the color of the placeholder text */
}

.search-bar input:focus {
  outline: none;
  border: 3px solid #007bff;
}

.search-bar button {
  padding: 1rem 2rem;
  border: none;
  background: #007bff;
  color: white;
  border-radius: 1rem;
  cursor: pointer;
  margin-left: 1rem;
}

.icon-grid {
  max-width: 1200px;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
  gap: 2rem;
  margin: auto;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content {
  background: var(--border-color);
  padding: 2rem;
  border-radius: 1rem;
  text-align: center;
}

.modal-content h2 {
  margin-bottom: 1rem;
}

.modal-content p {
  margin-bottom: 2rem;
}

.modal-content button {
  padding: 0.5rem 1rem;
  border: none;
  background: #007bff;
  color: white;
  border-radius: 0.5rem;
  cursor: pointer;
}

.modal-content button:hover {
  background: #0056b3;
}
</style>