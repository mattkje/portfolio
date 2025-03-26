<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';
import GameCard from '@/components/GameCard.vue';

interface Game {
  id: number;
  name: string;
  description: string;
  iconId: number;
  screenshot: string;
  price: number;
  link: string;
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
    <div class="game-grid">
      <GameCard
          v-for="game in games || []"
          :key="game.id"
          :id="game.id"
          :title="game.name"
          :description="game.description"
          :icon-id="game.iconId"
          :link="game.link"
          :price="game.price"
          @game-clicked="navigateToGameView"
      />
    </div>
  </div>
</template>

<style scoped>
.game-store {
  text-align: center;
  margin-top: 100px;
  padding: 2rem;
}

.game-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(500px, 1fr));
  gap: 1rem;
}
</style>