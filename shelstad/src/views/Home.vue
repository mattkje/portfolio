<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import GameCard from '@/components/GameCard.vue';
import Menubar from "@/components/Menubar.vue";
import partyPoopersImage from '@/assets/images/projects/party-poopers.svg';
import pathsImage from '@/assets/images/projects/paths.png';

const games = ref([
  {
    title: 'Paths',
    description: 'Final Project for Programming 2 Course',
    image: pathsImage,
    link: 'https://mattkje.github.io/',
    price: 'Free'
  },
  {
    title: 'Party Poopers',
    description: 'Final Project for Game Development Course',
    image: partyPoopersImage,
    link: 'https://shelstad.itch.io/party-poopers',
    price: 'Free',
    screenshots: [
      'https://example.com/screenshot3.png',
      'https://example.com/screenshot4.png'
    ],
    downloadLinks: [
      { url: 'https://shelstad.itch.io/party-poopers', label: 'Download' }
    ],
    genre: 'Party',
    version: '1.1.0',
    releaseDate: '2023-02-01'
  },
]);

const router = useRouter();

const navigateToGameView = (title) => {
  router.push({ name: 'GameView', params: { title } });
};
</script>

<template>
  <div class="game-store">
    <div class="game-grid">
      <GameCard
        v-for="game in games"
        :key="game.title"
        :title="game.title"
        :description="game.description"
        :image="game.image"
        :link="game.link"
        :price="game.price"
        @click="navigateToGameView"
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