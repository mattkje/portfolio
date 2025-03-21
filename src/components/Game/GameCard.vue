<script setup>
const props = defineProps({
  title: String,
  description: String,
  image: String,
  link: String,
  price: String
});

const emit = defineEmits(['click']);
</script>

<template>
  <div class="game-card" @click="$emit('click', title)">
    <img :src="image" :alt="title" class="game-image" />
    <div class="game-info">
      <h2>{{ title }}</h2>
      <p>{{ description }}</p>
      <p class="price">{{ price }}</p>
    </div>
  </div>
</template>

<style scoped>
.game-card {
  border: 1px solid #ccc;
  display: flex;
  flex-direction: row;
  border-radius: 8px;
  padding: 1rem;
  text-align: left;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s, box-shadow 0.3s;
}

.game-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.game-info {
  margin-left: 1rem;
}

.game-info h2 {
  font-size: 1.2rem;
}

.game-info p {
  font-size: 0.8rem;
}

.game-image {
  width: 150px;
  height: 150px;
  object-fit: cover;
  border-radius: 8px;
}

.game-link {
  display: inline-block;
  margin-top: 1rem;
  color: #42b983;
  font-size: 0.8rem;
  text-decoration: none;
}
</style>