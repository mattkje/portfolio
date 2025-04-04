<script setup lang="ts">
import { ref, onMounted, getCurrentInstance } from 'vue';

const props = defineProps({
  id: Number,
  title: String,
  description: String,
  version: String,
  iconId: Number,
  link: String,
  price: Number,
  createdAt: String,
});

const emit = defineEmits(['game-clicked']);
const iconUrl = ref('');

const getIcon = async (iconId: number) => {
  const { appContext } = getCurrentInstance()!;
  const apiAddress = appContext.config.globalProperties.$apiAddress;
  const response = await fetch(`${apiAddress}/files/tool${iconId}.png`);
  return response.url;
};

const handleClick = () => {
  emit('game-clicked', props.id);
};

onMounted(async () => {
  iconUrl.value = await getIcon(props.iconId);
});
</script>

<template>
  <router-link class="game-card" :to="'/tool/' + id">
    <div class="left-part">
      <div class="image-stack">
        <div class="background-square"></div>
        <img :src="iconUrl" alt="title Icon" class="game-icon" />
      </div>
    </div>
    <div class="right-part">
      <div class="game-info">
        <h2>{{ title }}</h2>
        <p v-if="createdAt"><strong>Release Date:</strong> {{ new Date(createdAt).toLocaleDateString() }}</p>
        <p v-else><strong>Release Date:</strong> Not Available</p>
        <p v-if="version"><strong>Current Version:</strong> {{ version }}</p>
      </div>
      <p class="pre-release-price" v-if="price === -2">Coming Soon</p>
      <p class="unavailable-price" v-else-if="price === -1">Unavailable</p>
      <p class="price" v-else-if="price === 0">Free</p>
      <p class="price" v-else>{{ price }}</p>
    </div>
  </router-link>
</template>

<style scoped>
.game-card {
  height: 150px;
  border: 1px solid var(--border-color);
  text-decoration: none;
  color: inherit; /* Inherit color from parent */
  border-radius: 3rem;
  display: flex;
  flex-direction: row;
  padding: 1rem 2rem 1rem 1rem;
  margin: 1rem 0;
  transition: background-color 0.3s, border-color 0.3s, transform 0.3s;
}

.left-part {
  display: flex;
  flex-direction: row;
  aspect-ratio: 1 / 1;
}

.right-part {
  display: flex;
  margin-left: 1.5rem;
  width: 100%;
  line-height: 1rem;
  flex-direction: column;
  justify-content: space-between;
}

.price {
  align-self: flex-end;
  text-align: center;
  color: white;
  padding: 0.5rem 2rem;
  border-radius: 1.5rem;
  background-color: hsla(210, 100%, 50%, 1); /* Blue color */
  text-decoration: none;
  font-weight: 900;
  font-size: 0.8rem;
  transition: color 0.3s, transform 0.3s;
}

.unavailable-price {
  align-self: flex-end;
  text-align: center;
  color: white;
  padding: 0.5rem 2rem;
  border-radius: 1.5rem;
  background-color: hsl(0, 0%, 53%); /* Blue color */
  text-decoration: none;
  font-weight: 900;
  font-size: 0.8rem;
  transition: color 0.3s, transform 0.3s;
}

.pre-release-price {
  align-self: flex-end;
  text-align: center;
  color: white;
  padding: 0.5rem 2rem;
  border-radius: 1.5rem;
  background-color: hsl(215, 35%, 32%); /* Blue color */
  text-decoration: none;
  font-weight: 900;
  font-size: 0.8rem;
  transition: color 0.3s, transform 0.3s;
}

.game-card:hover {
  transform: scale(1.02);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
}

.game-info {
  display: flex;
  flex-direction: column;
  text-align: left;
}

.game-info h2 {
  font-size: 1.2rem;
}

.game-info p {
  font-size: 0.7rem;
  line-height: 0.1rem;
  color: #797979;
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
  background-color: var(--border-color);
  border-radius: 2rem; /* Rounded corners */
  z-index: 0;
}

.game-icon {
  position: relative;
  z-index: 1;
  height: 100%;
  aspect-ratio: 1 / 1;
  object-fit: contain;
  border-radius: 2rem;
}
</style>