<script setup lang="ts">
import { getCurrentInstance, onMounted, ref} from 'vue';
import { useRoute } from 'vue-router';
import { marked } from 'marked';
import { Tool} from '@/assets/types';
import jsonData from "@/assets/data.json";
import {Carousel, Navigation, Pagination, Slide} from "vue3-carousel";

const route = useRoute();
const tool = ref<Tool | null>(jsonData.tables.tools.find((tool) => tool.id === Number(route.params.id)) || null);
const toolLinks = ref<{ [key: string]: string | null }>({});


const fetchToolLinks = async () => {
  if (!tool.value) return;

  const platforms = ['win', 'mac', 'lin'];
  for (const platform of platforms) {
    const filePath = `/data/${tool.value.name.trim().replace(/ /g, '')}-${platform}.zip`;

    try {
      const response = await fetch(filePath, { method: 'GET' });

      const contentType = response.headers.get('Content-Type');
      contentLength = response.headers.get('Content-Length');
      const isZip = contentType?.includes('application/zip');

      if (response.ok && isZip) {
        // Only set the filePath if the file exists and is a valid zip
        toolLinks.value[platform] = filePath;
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
  if (tool.value?.link) {
    const url = new URL(tool.value.link);
    if (url.hostname.includes('appstore')) {
      return 'App Store';
    } else if (url.hostname.includes('playstore')) {
      return 'Play Store';
    } else if (url.hostname.includes('itch')) {
      return 'Itch.io';
    } else if (url.hostname.includes('steam')) {
      return 'Steam';
    } else if (url.hostname.includes('epicgames')) {
      return 'Epic Games';
    } else if (url.hostname.includes('origin')) {
      return 'Origin';
    } else if (url.hostname.includes('battle.net')) {
      return 'Battle.net';
    } else if (url.hostname.includes('uplay')) {
      return 'Uplay';
    } else if (url.hostname.includes('github')) {
      return 'GitHub';
    }
  }

};

const getLocalCurrency = () => {
  const locale = 'en-US';
  const currency = 'USD';
  const conversionRate = 1;

  if (tool.value.price != null) {
    const convertedPrice = tool.value.price * conversionRate;
    return new Intl.NumberFormat(locale, { style: 'currency', currency }).format(convertedPrice);
  }
  return 'N/A';
};

const carouselConfig = {
  itemsToShow: 2.5,
  wrapAround: true,
  autoplay: 5000,
  transition: 300
};

onMounted(() => {
  fetchToolLinks()
});
</script>

<template>
  <div v-if="tool" class="tool-page">
    <Carousel v-bind="carouselConfig">
      <Slide v-if="tool.video">
        <iframe
            v-if="tool?.video"
            :src="tool.video"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
        ></iframe>
      </Slide>
      <Slide v-for="slide in parseInt(tool?.screenshot || '0')" :key="slide ">
        <img
            :src="`/data/tool${tool?.id}-${slide}.png`"
            :alt="`Screenshot ${slide}`"
        />
      </Slide>

      <template #addons>
        <Navigation />
        <Pagination />
      </template>
    </Carousel>
    <div class="tool-info">
      <div class="left-part">
        <div class="image-stack">
          <div class="background-square"></div>
          <img class="game-icon" :src="`/data/tool${tool.id}.png`" alt="Tool Icon" />
        </div>
        <div class="tool-details">
          <h1>{{ tool.name }}</h1>
          <p><strong>Release Date:</strong> {{ new Date(tool.created_at).toLocaleDateString() }}</p>
          <p><strong>Current Version:</strong> {{ tool.version }}</p>
          <p v-if="contentLength"><strong>File Size:</strong>
            {{ contentLength && !isNaN(Number(contentLength))
                ? (Number(contentLength) / 1024 / 1024).toFixed(2) + ' MB'
                : 'Not Available' }}
          </p>
        </div>
      </div>
      <div class="download-box">
        <div class="download-buttons">
          <p v-if="tool.price === 0">Download for Free</p>
          <p v-else-if="tool.price === -1">This tool is unavailable</p>
          <p v-else-if="tool.price === -2">Coming Soon</p>
          <p v-else>{{ getLocalCurrency() }}</p>
          <a v-if="toolLinks.win" class="download-button" :href="toolLinks.win" download>Download Windows</a>
          <a v-if="toolLinks.mac" class="download-button" :href="toolLinks.mac" download>Download Mac</a>
          <a v-if="toolLinks.lin" class="download-button" :href="toolLinks.lin" download>Download Linux</a>
          <a v-if="tool.link" class="download-button" :href="tool.link" target="_blank">Download from {{ checkPlatform() }}</a>
          <p v-if="!toolLinks.win && !toolLinks.mac && !toolLinks.lin && !tool.link">No downloads</p>
        </div>
      </div>
    </div>
    <hr class="horizontal-separator">
    <div class="description-text" v-html="marked(tool.description)"></div>
  </div>
  <div v-else>
    <p>Loading...</p>
  </div>
</template>
<style scoped>
.tool-page {
  text-align: left;
  margin-top: 100px;
  padding: 2rem 0;
}

.tool-page h1 {
  font-size: 2rem;
}

.tool-page p {
  font-size: 1rem;
}

.tool-page img {
  aspect-ratio: 16 / 10;
  margin: 1rem;
  border-radius: 3rem;
}

.tool-info {
  display: flex;
  width: 70%;
  margin: auto;
  flex-direction: row;
  justify-content: space-between;
}

.tool-info img {
  width: 200px;
  height: 200px;
  margin: auto 1.5rem auto 0;
}

.horizontal-separator {
  border: none;
  border-top: 3px solid #e3e3e3;
  width: 70%;
  border-radius: 5px;
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

.image-stack {
  width: 200px;
  height: 200px;
  aspect-ratio: 1 / 1;
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
  border-radius: 3rem; /* Rounded corners */
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

.tool-details p {
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