<script setup lang="ts">
import { getCurrentInstance, onMounted, ref} from 'vue';
import { useRoute } from 'vue-router';
import { marked } from 'marked';
import { Tool} from '@/assets/types';
import jsonData from "@/assets/data.json";

const route = useRoute();
const tool = ref<Tool | null>(jsonData.tables.tools.find((tool) => tool.id === Number(route.params.id)) || null);
const toolLinks = ref<{ [key: string]: string | null }>({});
const activeIndex = ref(0);


const fetchToolLinks = async () => {
  if (!tool.value) return;

  const platforms = ['win', 'mac', 'lin'];
  for (const platform of platforms) {
    const filePath = `/data/${tool.value.name.trim().replace(/ /g, '')}-${platform}.zip`;

    try {
      const response = await fetch(filePath, { method: 'GET' });

      const contentType = response.headers.get('Content-Type');
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
const nextSlide = () => {
  if (!tool.value) return;

  const maxIndex = Number(tool.value.screenshot);
  if (tool.value.video) {
    activeIndex.value = (activeIndex.value + 1) % (maxIndex + 1);
  } else {
    activeIndex.value = (activeIndex.value + 1) % (maxIndex);
  }

  setTimeout(() => {
    const gallery = document.querySelector('.screenshot-gallery');
    if (gallery) {
      const childWidth = gallery.firstElementChild?.clientWidth || 0;
      const gap = parseInt(getComputedStyle(gallery).gap) || 0;
      if (tool.value?.video) {
        if (activeIndex.value === 1) {
          gallery.scrollTo({ left: (childWidth + gap) * 2 * activeIndex.value, behavior: 'smooth' });
        }
        else {
          gallery.scrollTo({ left: (childWidth + gap) * (activeIndex.value + 1), behavior: 'smooth' });
        }
      }
      else {
        if (activeIndex.value === 1) {
          gallery.scrollTo({ left: (childWidth + gap) * 2 * activeIndex.value, behavior: 'smooth' });
        }
        else {
          gallery.scrollTo({ left: (childWidth + gap) * (activeIndex.value + 1), behavior: 'smooth' });
        }
      }


    }
  }, 0);
  console.log('Next:', activeIndex.value);
};

const prevSlide = () => {
  if (!tool.value) return;

  const maxIndex = Number(tool.value.screenshot);
  if (tool.value.video) {
    activeIndex.value = (activeIndex.value - 1 + (maxIndex + 1)) % (maxIndex + 1);
  } else {
    activeIndex.value = (activeIndex.value - 1 + (maxIndex)) % (maxIndex);
  }

  setTimeout(() => {
    const gallery = document.querySelector('.screenshot-gallery');
    if (gallery) {
      const childWidth = gallery.firstElementChild?.clientWidth || 0;
      const gap = parseInt(getComputedStyle(gallery).gap) || 0;
      if (tool.value?.video) {
        if (activeIndex.value === 1) {
          gallery.scrollTo({ left: (childWidth + gap) * 2 * activeIndex.value, behavior: 'smooth' });
        }
        else {
          gallery.scrollTo({ left: (childWidth + gap) * (activeIndex.value + 1), behavior: 'smooth' });
        }
      }
      else {
        if (activeIndex.value === 1) {
          gallery.scrollTo({ left: (childWidth + gap) * 2 * activeIndex.value, behavior: 'smooth' });
        }
        else {
          gallery.scrollTo({ left: (childWidth + gap) * (activeIndex.value + 1), behavior: 'smooth' });
        }
      }
    }
  }, 0);
};

const updateActiveIndex = () => {
  const gallery = document.querySelector('.screenshot-gallery');
  if (gallery) {
    const scrollLeft = gallery.scrollLeft;
    const childWidth = gallery.clientWidth || 0;
    const gap = parseInt(getComputedStyle(gallery).gap) || 0;
    activeIndex.value = Math.round(scrollLeft / (childWidth + gap));
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

onMounted(() => {
  fetchToolLinks()
  const gallery = document.querySelector('.screenshot-gallery');
  if (gallery) {
    gallery.scrollLeft = 0; // Set initial scroll position to 0
    gallery.addEventListener('scroll', updateActiveIndex);
    updateActiveIndex(); // Ensure the active index is correctly set initially
  }
});
</script>

<template>
  <div v-if="tool" class="tool-page">
    <div class="screenshots">
      <div class="screenshot-gallery" v-if="tool.video">
        <iframe
            v-if="tool.video"
            :src="tool.video"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
            class="youtube-miniplayer"
            :class="{ active: activeIndex === 0 }"
        ></iframe>
        <img  v-for="index in parseInt(tool.screenshot)" :key="index"
              :src="`/data/tool${tool.id}-${index}.png`" :alt="`Screenshot ${index + 1}`"
              :class="{ active: index === activeIndex}"/>
      </div>
      <div class="screenshot-gallery" v-else>
        <img  v-for="index in parseInt(tool.screenshot)" :key="index"
              :src="`/data/tool${tool.id}-${index}.png`" :alt="`Screenshot ${index + 1}`"
              :class="{ active: index === activeIndex + 1}"/>
      </div>
      <div class="dots" v-if="tool.video">
        <button @click="prevSlide" class="carousel-button prev">‹</button>
        <span v-for="index in parseInt(tool.screenshot) + 1" :key="index"
              :class="{ active: index === activeIndex + 1 }"></span>
        <button @click="nextSlide" class="carousel-button next">›</button>
      </div>
      <div class="dots" v-else>
        <button @click="prevSlide" class="carousel-button prev">‹</button>
        <span v-for="index in parseInt(tool.screenshot) " :key="index"
              :class="{ active: index === activeIndex +1 }"></span>
        <button @click="nextSlide" class="carousel-button next">›</button>
      </div>
    </div>
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
        </div>
      </div>
      <div class="download-box">
        <div class="download-buttons">
          <p v-if="tool.price === 0">Download for Free</p>
          <p v-else-if="tool.price === -1">This tool is unavailable</p>
          <p v-else-if="tool.price === -2">Coming Soon</p>
          <p v-else>{{ tool.price }}</p>
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
  width: 200px;
  height: auto;
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

.screenshot-gallery {
  display: flex;
  gap: 1rem;
  width: 100%;
  padding: 0 0 2.5rem 0;
  overflow-x: scroll;
  user-select: none;
  scroll-snap-type: x mandatory;
  position: relative;
  scrollbar-width: none; /* Firefox */
  -ms-overflow-style: none; /* Internet Explorer 10+ */
}

.screenshot-gallery::-webkit-scrollbar {
  display: none; /* Safari and Chrome */
}

.screenshot-gallery::before,
.screenshot-gallery::after {
  content: '';
  min-width: 50%;
  flex-shrink: 0;
}

.screenshot-gallery img {
  min-width: 50%;
  aspect-ratio: 16 / 10;
  object-fit: contain;
  background-color: #444444;
  border-radius: 3rem;
  scroll-snap-align: center;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  transition: transform 0.3s, opacity 0.3s;
}

.screenshot-gallery img.active{
  transform: scale(1);
}

.screenshot-gallery img:not(.active) {
  transform: scale(0.8);
  opacity: 0.3;
}

.screenshot-gallery iframe {
  min-width: 50%;
  aspect-ratio: 16 / 10;
  object-fit: cover;
  border-radius: 3rem;
  scroll-snap-align: center;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  transition: transform 0.3s;
}

.screenshot-gallery iframe.active{
  transform: scale(1);
  transition: transform 0.3s, opacity 0.3s;
}

.screenshot-gallery iframe:not(.active) {
  transform: scale(0.8);
  opacity: 0.3;
}

.dots {
  display: flex;
  justify-content: center;
  margin-top: 1rem;
}

.dots span {
  width: 10px;
  height: 10px;
  background-color: #ccc;
  border-radius: 50%;
  margin: 0 5px;
  transition: background-color 0.3s;
}

.dots span.active {
  background-color: #000;
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

.carousel-button {
  transform: translateY(-50%);
  background: none;
  color: #3a3a3a;
  border: none;
  border-radius: 50%;
  font-weight: 900;
  font-size: 3rem;
  text-align: center;
  width: 40px;
  height: 40px;
  cursor: pointer;
  z-index: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  font-family: 'Arial Rounded MT Bold', sans-serif;
  transition: color 0.3s, transform 0.3s;
}

.carousel-button.prev {
  left: 40%;
}

.carousel-button.next {
  right: 40%;
}

.carousel-button:hover {
  color: hsl(0, 0%, 47%);
}

.vertical-separator {
  border: none;
  border-left: 3px solid #e3e3e3;
  margin: 3rem 0;
  border-radius: 5px;
}

.horizontal-separator {
  border: none;
  border-top: 3px solid #e3e3e3;
  width: 70%;
  border-radius: 5px;
}
</style>