<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  icon: {
    type: String,
    required: true
  },
  title: {
    type: String,
    required: true
  }
});
</script>

<template>
  <button class="icon-button">
    <img :src="icon" :alt="title" class="icon" />
    <span class="title">{{ title }}</span>
  </button>
</template>

<style scoped>
.icon-button {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem;
  border: #e3e3e3 solid 1px;
  border-radius: 1rem;
  background: none;
  cursor: pointer;
  transition: transform 0.3s, background-color 0.3s;
}

.icon-button:hover {
  background-color: #f9f9f9;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  transform: scale(1.05);
}

.icon {
  width: 100px;
  margin-bottom: 0.5rem;
}

.title {
  font-weight: 900;
  color: #444444;
  font-size: 1rem;
  text-align: center;
}
</style>