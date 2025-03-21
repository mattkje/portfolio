<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  date: String,
  icon: String,
  name: String,
  description: String,
  link: String
});

</script>

<template>
  <div class="project-box">
    <img :src="icon" alt="Project Icon" class="project-icon" />
    <div class="project-details">
      <h2 class="project-name">{{ name }}</h2>
      <p class="project-date">{{ date }}</p>
      <p class="project-description">{{ description }}</p>
      <a class="link" :href="link"> Project Website </a>
    </div>
  </div>
</template>

<style scoped>
.project-box {
  height: 200px;
  border: 1px solid #e3e3e3;
  border-radius: 4rem;
  align-content: flex-start;
  display: flex;
  flex-direction: row;
  padding: 1rem;
  margin: 1rem 0;
  transition: background-color 0.3s, border-color 0.3s;
}

.project-box:hover {

}

.project-icon {
  height: 100%;
  aspect-ratio: 1 / 1;
  object-fit: contain;
  border-radius: 3rem;
  margin-right: 1rem;
}

.project-details {
  text-align: left;
}

.project-name {
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
}

.project-date {
  font-size: 0.875rem;
  color: var(--color-text);
  margin-bottom: 1rem;
}

.project-description {
  font-size: 1rem;
  margin-bottom: 1rem;
}

.project-links a {
  display: inline-block;
  margin-right: 0.5rem;
  color: hsla(160, 100%, 37%, 1);
  text-decoration: none;
  transition: color 0.3s;
}

.project-links a:hover {
  color: hsla(160, 100%, 37%, 0.7);
}
</style>