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
    <div class="left-part">
      <div class="image-stack">
        <div class="background-square"></div>
        <img :src="image" alt="title Icon" class="game-icon" />
      </div>
    </div>
    <div class="right-part">
      <div class="game-info">
        <h2>{{ title }}</h2>
        <p>{{ description }}</p>
      </div>
      <p class="price">{{ price }}</p>
    </div>
  </div>
</template>

<style scoped>
.game-card {
  height: 200px;
  border: 1px solid #e3e3e3;
  border-radius: 4rem;
  justify-content: space-between;
  display: flex;
  flex-direction: row;
  padding: 1rem 3rem 1rem 1rem;
  margin: 1rem 0;
  transition: background-color 0.3s, border-color 0.3s, transform 0.3s;
}

.left-part {
  display: flex;
  flex-direction: row;
  gap: 1rem;
}

.right-part {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.price {
  align-self: flex-end;
  text-align: center;
  color: white;
  padding: 0.7rem 3rem;
  border-radius: 1.5rem;
  background-color: hsla(210, 100%, 50%, 1); /* Blue color */
  text-decoration: none;
  font-weight: bold;
  font-size: 1rem;
  transition: color 0.3s, transform 0.3s;
}

.game-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.game-info {
  display: flex;
  flex-direction: column;
  text-align: left;
}

.game-info h2 {
  margin-bottom: 0; /* Adjust this value as needed */
}

.game-info p {
  font-size: 0.8rem;
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

.game-icon {
  position: relative;
  z-index: 1;
  height: 100%;
  aspect-ratio: 1 / 1;
  object-fit: contain;
  border-radius: 3rem;
}
.game-link {
  display: inline-block;
  margin-top: 1rem;
  color: #42b983;
  font-size: 0.8rem;
  text-decoration: none;
}
</style>