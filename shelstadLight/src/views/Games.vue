<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import GameCard from '@/components/GameCard.vue';
import { Game } from '@/assets/types';
import jsonData from '@/assets/data.json';

const games = ref<Game[] | null>(jsonData.tables.games);

const router = useRouter();

const navigateToGameView = (game: Game) => {
  router.push({ name: 'GamePage', params: { id: game.id } });
};

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
          :icon-id="game.icon_id"
          :link="game.link"
          :price="game.price"
          :created-at="game.created_at"
          @game-clicked="navigateToGameView"
      />
    </div>
  </div>
</template>

<style scoped>
.game-store {
  max-width: 1920px;
  text-align: left;
  padding: 5rem 2rem 0 2rem;
}

.game-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(400px, 1fr));
  gap: 1rem;
  margin: auto;
}
</style>