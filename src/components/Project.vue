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
    <div class="left-part">
      <div class="image-stack">
        <div class="background-square"></div>
        <img :src="icon" alt="Project Icon" class="project-icon" />
      </div>
      <div class="project-details">
        <h2 class="project-name">{{ name }}</h2>
        <p class="project-date">{{ date }}</p>
        <p class="project-description">{{ description }}</p>
      </div>
    </div>
    <a class="link" :href="link"> Learn more </a>
  </div>
</template>

<style scoped>
.project-box {
  height: 200px;
  border: 1px solid #e3e3e3;
  border-radius: 4rem;
  justify-content: space-between;
  display: flex;
  flex-direction: row;
  padding: 1rem 3rem 1rem 1rem;
  margin: 1rem 0;
  transition: background-color 0.3s, border-color 0.3s;
}

.left-part {
  display: flex;
  flex-direction: row;
  gap: 1rem;
}

.image-stack {
  aspect-ratio: 1 / 1;
  height: 100%;
  position: relative;
  display: inline-block;
}

.background-square {
  position: absolute;
  top: 0;
  left: 0;
  aspect-ratio: 1 / 1;
  height: 100%;
  background-color: #f5f5f5; /* Dark color */
  border-radius: 3rem; /* Rounded corners */
  z-index: 0;
}

.project-icon {
  position: relative;
  z-index: 1;
  height: 100%;
  aspect-ratio: 1 / 1;
  object-fit: contain;
  border-radius: 3rem;
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
  font-size: 0.8rem;
  margin-bottom: 1rem;
}

.link {
  align-self: flex-end;
  color: white;
  padding: 0.7rem 1.2rem;
  border-radius: 1.5rem;
  background-color: hsla(210, 100%, 50%, 1); /* Blue color */
  text-decoration: none;
  font-weight: bold;
  transition: color 0.3s, transform 0.3s;
  white-space: nowrap;
}
.link:hover {
  color: hsl(210, 100%, 92%); /* Lighter blue on hover */
  transform: scale(1.1); /* Slightly enlarge on hover */
}
</style>