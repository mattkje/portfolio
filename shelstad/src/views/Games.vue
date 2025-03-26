<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';
import GameCard from '@/components/GameCard.vue';

interface Game {
  id: number;
  name: string;
  description: string;
  version: string;
  iconId: number;
  screenshot: string;
  price: number;
  link: string;
  createdAt: string;
}

const games = ref<Game[] | null>(null);

const fetchGames = async () => {
  try {
    const response = await fetch('http://localhost:8080/api/games');
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data: Game[] = await response.json();
    games.value = data;
  } catch (error) {
    console.error('Failed to fetch games:', error);
  }
};

const router = useRouter();

const navigateToGameView = (game: Game) => {
  router.push({ name: 'GamePage', params: { id: game.id } });
};

onMounted(fetchGames);
</script>

<template>
  <div class="game-store">
    <h1>Games</h1>
    <div class="game-grid">
      <GameCard
          v-for="game in games || []"
          :key="game.id"
          :id="game.id"
          :title="game.name"
          :description="game.description"
          :version="game.version"
          :icon-id="game.iconId"
          :link="game.link"
          :price="game.price"
          :created-at="game.createdAt"
          @game-clicked="navigateToGameView"
      />
    </div>
  </div>
</template>

<style scoped>
.game-store {
  text-align: left;
  padding: 5rem 2rem 0 2rem;
}

.game-grid {
  max-width: 1920px;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(400px, 1fr));
  gap: 1rem;
  margin: auto;
}
</style>