<script setup lang="ts">
import { computed, getCurrentInstance, onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import { marked } from 'marked';
import { Game } from "@/assets/types";
import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'
import 'vue3-carousel/carousel.css'
import jsonData from '@/assets/data.json';



const route = useRoute();
const game = ref<Game | null>(jsonData.tables.games.find((game) => game.id === Number(route.params.id)) || null);
const gameLinks = ref<{ [key: string]: string | null }>({});
let contentLength = ref<string | null>(null);


const carouselConfig = {
  itemsToShow: 2.5,
  wrapAround: true,
  autoplay: 5000,
  transition: 300
};
const fetchGameLinks = async () => {
  if (!game.value) return;

  const platforms = ['win', 'mac', 'lin'];
  for (const platform of platforms) {
    const filePath = `/data/${game.value.name.trim().replace(/ /g, '')}-${platform}.zip`;

    try {
      const response = await fetch(filePath, { method: 'GET' });

      const contentType = response.headers.get('Content-Type');
      contentLength = response.headers.get('Content-Length');
      const isZip = contentType?.includes('application/zip');

      if (response.ok && isZip) {
        gameLinks.value[platform] = filePath;
      } else {
        console.warn(`File not found or not a zip: ${filePath}`, contentType);
      }
    } catch (error) {
      console.error(`Error checking file: ${filePath}`, error);
    }
  }
};

const checkPlatform = () => {
  // what is the website name from game.link itch or github
  if (game.value?.link) {
    const url = new URL(game.value.link);
    if (url.hostname.includes('itch')) {
      return 'Itch.io';
    } else if (url.hostname.includes('github')) {
      return 'GitHub';
    }
  }

};

const getLocalCurrency = () => {
  const locale = 'en-US';
  const currency = 'USD';
  const conversionRate = 1;

  if (game.value.price != null) {
    const convertedPrice = game.value.price * conversionRate;
    return new Intl.NumberFormat(locale, { style: 'currency', currency }).format(convertedPrice);
  }
  return 'N/A';
};

onMounted(() => {
  fetchGameLinks()
});
</script>

<template>
  <div v-if="game" class="game-page">
    <Carousel v-bind="carouselConfig">
      <Slide v-if="game.video">
      <iframe
          v-if="game?.video"
          :src="game.video"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
      ></iframe>
      </Slide>
      <Slide v-for="slide in parseInt(game?.screenshot || '0')" :key="slide ">
        <img
          :src="`/data/game${game?.id}-${slide}.png`"
          :alt="`Screenshot ${slide}`"
        />
      </Slide>

      <template #addons>
        <Navigation />
        <Pagination />
      </template>
    </Carousel>
    <div class="game-info">
      <div class="left-part">
        <img :src="`/data/game${game.icon_id}.png`" alt="Game Icon"/>
        <div class="game-details">
          <h1>{{ game.name }}</h1>
          <p><strong>Release Date:</strong> {{ new Date(game.created_at).toLocaleDateString() }}</p>
          <p><strong>Current Version:</strong> {{ game.version }}</p>
          <p v-if="contentLength && Number(contentLength) === 0"><strong>File Size:</strong>
            {{ contentLength && !isNaN(Number(contentLength))
                ? (Number(contentLength) / 1024 / 1024).toFixed(2) + ' MB'
                : 'Not Available' }}
          </p>
        </div>
      </div>
      <div class="download-box">
        <div class="download-buttons">
          <p v-if="game.price === 0">Download for Free</p>
          <p v-else-if="game.price === -1">This game is unavailable</p>
          <p v-else-if="game.price === -2">Coming Soon</p>
          <p v-else>{{ getLocalCurrency() }}</p>
          <a v-if="gameLinks.win" class="download-button" :href="gameLinks.win" download>Download Windows</a>
          <a v-if="gameLinks.mac" class="download-button" :href="gameLinks.mac" download>Download Mac</a>
          <a v-if="gameLinks.lin" class="download-button" :href="gameLinks.lin" download>Download Linux</a>
          <a v-if="game.link" class="download-button" :href="game.link" target="_blank">See on {{ checkPlatform() }}</a>
          <p v-if="!gameLinks.win && !gameLinks.mac && !gameLinks.lin && !game.link">No downloads</p>
        </div>
      </div>
    </div>
    <hr class="horizontal-separator">
    <div class="description-text" v-html="marked(game.description)"></div>
  </div>
  <div v-else>
    <p>Loading...</p>
  </div>
</template>

<style scoped>
.game-page {
  text-align: left;
  margin-top: 100px;
  padding: 2rem 0;
}

.game-page h1 {
  font-size: 2rem;
}

.game-page p {
  font-size: 1rem;
}

.game-page img {
  aspect-ratio: 16 / 10;
  margin: 1rem;
  border-radius: 3rem;
}

.game-info {
  display: flex;
  width: 70%;
  margin: auto;
  flex-direction: row;
  justify-content: space-between;
}

.game-info img {
  width: 200px;
  height: 200px;
  margin: auto 1.5rem auto 0;
}

.left-part {
  display: flex;
  flex-direction: row;
  gap: 1rem;
}

.download-buttons {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  justify-content: center;
  margin: auto;
}

.download-buttons p {
  font-size: 1rem;
  margin: 0 auto;
}


.download-button {
  align-self: flex-end;
  text-align: center;
  width: 250px;
  color: white;
  padding: 0.6rem 2rem;
  border-radius: 1.5rem;
  background-color: hsla(210, 100%, 50%, 1); /* Blue color */
  text-decoration: none;
  font-weight: bold;
  font-size: 1rem;
  transition: transform 0.3s, color 0.3s;
}

.download-button:hover {
  transform: scale(1.1);
}

iframe {
  width: 100%;
  height: 100%;
  aspect-ratio: 16 / 10;
  object-fit: cover;
  border-radius: 3rem;
  scroll-snap-align: center;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  transition: transform 0.3s;
}

.download-box {
  display: flex;
  padding: 1rem;
  border-radius: 4rem;
  gap: 2rem;
  justify-content: space-between;
  align-items: center;
}

.description-text {
  width: 70%;
  margin: 2rem auto;
  font-size: 1rem;
}

.horizontal-separator {
  border: none;
  border-top: 3px solid #e3e3e3;
  width: 70%;
  border-radius: 5px;
}

.game-details p {
  margin: 0.5rem 0;
  font-size: 1rem;
  color: #8c8c8c;
}

.carousel {
  --vc-pgn-background-color: rgba(255, 255, 255, 0.7);
  --vc-pgn-active-color: rgba(255, 255, 255, 1);
  --vc-nav-background: rgba(255, 255, 255, 0.7);
  --vc-nav-border-radius: 100%;
}

img {
  border-radius: 8px;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.carousel__viewport {
  perspective: 2000px;
}

.carousel__track {
  transform-style: preserve-3d;
  transition: transform 0.5s ease-in-out, left 0.5s ease-in-out;
}

.carousel__slide--sliding {
  transition:
      opacity 0.5s ease-in-out,
      transform 0.5s ease-in-out;
}

.carousel.is-dragging .carousel__slide {
  transition:
      opacity 0.5s ease-in-out,
      transform 0.5s ease-in-out;
}


.carousel__slide {
  opacity: 0.3;
  transform: translateX(10px) rotateY(-12deg) scale(0.8);
}

.carousel__slide--prev {
  opacity: 0.3;
  transform: rotateY(-10deg) scale(0.8);
}

.carousel__slide--active {
  opacity: 1;
  transform: rotateY(0) scale(1);
}

.carousel__slide--next {
  opacity: 0.3;
  transform: rotateY(10deg) scale(0.8);
}

.carousel__slide--next ~ .carousel__slide {
  opacity: 0.3;
  transform: translateX(-10px) rotateY(12deg) scale(0.8);
}
</style>