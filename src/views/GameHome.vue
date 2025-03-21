<script setup>
import { ref } from 'vue';
import GameCard from '@/components/Game/GameCard.vue';
import GameMenubar from "@/components/Game/GameMenubar.vue";

const games = ref([
  {
    title: 'Paths',
    description: 'Final Project for Programming 2 Course',
    image: 'https://yt3.googleusercontent.com/IxJunmeSafWr3Y81_N_g1CZVHUuY6AOAHSOx2AFuetArLsSVojwksdHV2kyqkFzan5Kc_DhvDA=s160-c-k-c0x00ffffff-no-rj',
    link: 'https://mattkje.github.io/',
    price: 'Free'
  },
  {
    title: 'Party Poopers',
    description: 'Final Project for Game Development Course',
    image: 'https://img.itch.zone/aW1nLzE4OTY2NDE5LnBuZw==/original/nveufF.png',
    link: 'https://shelstad.itch.io/party-poopers',
    price: 'Free'
  },
]);
</script>

<template>
  <GameMenubar/>
  <div class="game-store">
    <h1>Shelstad Studios Store</h1>
    <div class="game-grid">
      <GameCard
        v-for="game in games"
        :key="game.title"
        :title="game.title"
        :description="game.description"
        :image="game.image"
        :link="game.link"
        :price="game.price"
      />
    </div>
  </div>
</template>

<style scoped>
.game-store {
  text-align: center;
  padding: 2rem;
}

.game-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 1rem;
}
</style>