<script setup lang="ts">
import { computed, onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import { marked } from 'marked';
import { Tool } from '@/assets/types';

const route = useRoute();
const tool = ref<Tool | null>(null);
const toolLinks = ref<{ [key: string]: string | null }>({});
const activeIndex = ref(0);

const fetchTool = async (id: number) => {
  const response = await fetch(`http://localhost:8080/api/tools/${id}`);
  tool.value = await response.json();
  await fetchToolLinks();
};

const fetchToolLinks = async () => {
  if (!tool.value) return;

  const platforms = ['win', 'mac', 'lin'];
  for (const platform of platforms) {
    const link = `http://localhost:8080/api/files/${tool.value.name.trim().replace(/ /g, '')}-${platform}.zip`;
    try {
      const response = await fetch(link, { method: 'HEAD' });
      if (response.status === 404) {
        toolLinks.value[platform] = null;
      } else {
        toolLinks.value[platform] = link;
      }
    } catch (error) {
      console.error('Error checking link:', error);
      toolLinks.value[platform] = '';
    }
  }
};

const nextSlide = () => {
  if (!tool.value) return;

  const maxIndex = Number(tool.value.screenshot);
  if (tool.value.link) {
    activeIndex.value = (activeIndex.value + 1) % (maxIndex + 1);
  } else {
    activeIndex.value = (activeIndex.value + 1) % (maxIndex);
  }

  setTimeout(() => {
    const gallery = document.querySelector('.screenshot-gallery');
    if (gallery) {
      const childWidth = gallery.firstElementChild?.clientWidth || 0;
      const gap = parseInt(getComputedStyle(gallery).gap) || 0;
      if (tool.value?.link) {
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
  if (tool.value.link) {
    activeIndex.value = (activeIndex.value - 1 + (maxIndex + 1)) % (maxIndex + 1);
  } else {
    activeIndex.value = (activeIndex.value - 1 + (maxIndex)) % (maxIndex);
  }

  setTimeout(() => {
    const gallery = document.querySelector('.screenshot-gallery');
    if (gallery) {
      const childWidth = gallery.firstElementChild?.clientWidth || 0;
      const gap = parseInt(getComputedStyle(gallery).gap) || 0;
      if (tool.value?.link) {
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

onMounted(() => {
  const gameId = Number(route.params.id);
  fetchTool(gameId).then(() => {

  });

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
      <div class="screenshot-gallery" v-if="tool.link">
        <iframe
            v-if="tool.link"
            :src="tool.link"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
            class="youtube-miniplayer"
            :class="{ active: activeIndex === 0 }"
        ></iframe>
        <img  v-for="index in parseInt(tool.screenshot)" :key="index"
              :src="`http://localhost:8080/api/files/tool${tool.id}-${index}.png`" :alt="`Screenshot ${index + 1}`"
              :class="{ active: index === activeIndex}"/>
      </div>
      <div class="screenshot-gallery" v-else>
        <img  v-for="index in parseInt(tool.screenshot)" :key="index"
              :src="`http://localhost:8080/api/files/tool${tool.id}-${index}.png`" :alt="`Screenshot ${index + 1}`"
              :class="{ active: index === activeIndex + 1}"/>
      </div>
      <button @click="prevSlide" class="carousel-button prev">‹</button>
      <button @click="nextSlide" class="carousel-button next">›</button>
      <div class="dots" v-if="tool.link">
        <span v-for="index in parseInt(tool.screenshot) + 1" :key="index"
              :class="{ active: index === activeIndex + 1 }"></span>
      </div>
      <div class="dots" v-else>
        <span v-for="index in parseInt(tool.screenshot) " :key="index"
              :class="{ active: index === activeIndex +1 }"></span>
      </div>
    </div>
    <div class="tool-info">
      <div class="left-part">
        <div class="image-stack">
          <div class="background-square"></div>
          <img class="game-icon" :src="`http://localhost:8080/api/files/tool${tool.id}.png`" alt="Tool Icon" />
        </div>
        <div class="tool-details">
          <h1>{{ tool.name }}</h1>
          <p><strong>Release Date:</strong> {{ new Date(tool.createdAt).toLocaleDateString() }}</p>
          <p><strong>Current Version:</strong> {{ tool.version }}</p>
        </div>
      </div>
      <div class="download-box">
        <div class="download-buttons">
          <p v-if="tool.price === 0">Download for Free</p>
          <p v-else-if="tool.price === -1">This game is unavailable</p>
          <p v-else-if="tool.price === -2">Coming Soon</p>
          <p v-else>{{ tool.price }}</p>
          <a v-if="toolLinks.win" class="download-button" :href="toolLinks.win" download>Download Windows</a>
          <a v-if="toolLinks.mac" class="download-button" :href="toolLinks.mac" download>Download Mac</a>
          <a v-if="toolLinks.lin" class="download-button" :href="toolLinks.lin" download>Download Linux</a>
          <p v-if="!toolLinks.win && !toolLinks.mac && !toolLinks.lin">No downloads</p>
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
  object-fit: cover;
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
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background-color: rgba(0, 0, 0, 0.5);
  color: white;
  border: none;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  cursor: pointer;
  z-index: 1;
}

.carousel-button.prev {
  left: 10px;
}

.carousel-button.next {
  right: 10px;
}

.carousel-button:hover {
  background-color: rgba(0, 0, 0, 0.7);
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