<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  name: {
    type: String,
    required: true
  },
  description: {
    type: String,
    required: true
  },
  image: {
    type: String,
    required: true
  },
  links: {
    type: Array,
    required: true
  }
});
</script>

<template>
  <div class="container">
    <img class="brand-logo" :src="props.image" alt="LOGO"/>
    <h1>{{ props.name }}</h1>
    <p>{{ props.description }}</p>
    <ul>
      <li v-for="(link, index) in props.links" :key="index">
        <a :href="link">{{ link }}</a>
      </li>
    </ul>
  </div>
</template>

<style scoped>
.container {
  text-align: center;
  margin: 20px;
}

.brand-logo {
  max-width: 100px;
  border-radius: 1.5rem;
  margin-bottom: 10px;
}

h1 {
  font-size: 1.5em;
  margin-bottom: 10px;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin: 5px 0;
}

a {
  color: #007BFF;
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}
</style>