<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  images: {
    type: Array,
    required: true,
    default: () => []
  },
  downloadLinks: {
    type: Array,
    required: true,
    default: () => []
  },
  title: {
    type: String,
    required: true
  },
  description: {
    type: String,
    required: true
  },
  releaseDate: {
    type: String,
    required: true
  },
  currentVersion: {
    type: String,
    required: true
  },
  developer: {
    type: String,
    required: false,
    default: 'Unknown Developer'
  },
  genre: {
    type: String,
    required: false,
    default: 'Unknown Genre'
  }
});
</script>

<template>
  <div class="game-view">
    <h1>{{ title }}</h1>
    <p>{{ description }}</p>
    <p><strong>Release Date:</strong> {{ releaseDate }}</p>
    <p><strong>Current Version:</strong> {{ currentVersion }}</p>
    <p><strong>Developer:</strong> {{ developer }}</p>
    <p><strong>Genre:</strong> {{ genre }}</p>
    <div class="images">
      <h2>Screenshots</h2>
      <div class="image-gallery">
        <img v-for="(image, index) in images" :key="index" :src="image" :alt="`Screenshot ${index + 1}`" />
      </div>
    </div>
    <div class="downloads">
      <h2>Download Links</h2>
      <ul>
        <li v-for="(link, index) in downloadLinks" :key="index">
          <a :href="link.url" target="_blank">{{ link.label }}</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<style scoped>
.game-view {
  padding: 2rem;
}

.images {
  margin-top: 2rem;
}

.image-gallery {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
}

.image-gallery img {
  max-width: 200px;
  border-radius: 8px;
}

.downloads {
  margin-top: 2rem;
}

.downloads ul {
  list-style-type: none;
  padding: 0;
}

.downloads li {
  margin-bottom: 0.5rem;
}
</style>