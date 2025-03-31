<script setup lang="ts">
import {computed, onMounted, ref} from 'vue';
import {useRoute} from 'vue-router';
import {marked} from 'marked';
import {Game} from "@/assets/types";

const route = useRoute();
const game = ref<Game | null>(null);
const gameLinks = ref<{ [key: string]: string | null }>({});
const activeIndex = ref(0);

const fetchGame = async (id: number) => {
  const response = await fetch(`http://localhost:8080/api/games/${id}`);
  game.value = await response.json();
  await fetchGameLinks();
};

const fetchGameLinks = async () => {
  if (!game.value) return;

  const platforms = ['win', 'mac', 'lin'];
  for (const platform of platforms) {
    const link = `http://localhost:8080/api/files/${game.value.name.trim().replace(/ /g, '')}-${platform}.zip`;
    try {
      const response = await fetch(link, {method: 'HEAD'});
      if (response.status === 404) {
        gameLinks.value[platform] = null;
      } else {
        gameLinks.value[platform] = link;
      }
    } catch (error) {
      console.error('Error checking link:', error);
      gameLinks.value[platform] = '';
    }
  }
};

const nextSlide = () => {
  if (!game.value) return;

  const maxIndex = Number(game.value.screenshot);
  if (game.value.link) {
    activeIndex.value = (activeIndex.value + 1) % (maxIndex + 1);
  } else {
    activeIndex.value = (activeIndex.value + 1) % (maxIndex);
  }

  setTimeout(() => {
    const gallery = document.querySelector('.screenshot-gallery');
    if (gallery) {
      const childWidth = gallery.firstElementChild?.clientWidth || 0;
      const gap = parseInt(getComputedStyle(gallery).gap) || 0;
      if (game.value?.link) {
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
  if (!game.value) return;

  const maxIndex = Number(game.value.screenshot);
  if (game.value.link) {
    activeIndex.value = (activeIndex.value - 1 + (maxIndex + 1)) % (maxIndex + 1);
  } else {
    activeIndex.value = (activeIndex.value - 1 + (maxIndex)) % (maxIndex);
  }

  setTimeout(() => {
    const gallery = document.querySelector('.screenshot-gallery');
    if (gallery) {
      const childWidth = gallery.firstElementChild?.clientWidth || 0;
      const gap = parseInt(getComputedStyle(gallery).gap) || 0;
      if (game.value?.link) {
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
  fetchGame(gameId).then(() => {

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
  <div v-if="game" class="game-page">
    <div class="screenshots">
      <div class="screenshot-gallery" v-if="game.link">
        <iframe
            v-if="game.link"
            :src="game.link"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
            class="youtube-miniplayer"
            :class="{ active: activeIndex === 0 }"
        ></iframe>
        <img  v-for="index in parseInt(game.screenshot)" :key="index"
             :src="`http://localhost:8080/api/files/game${game.id}-${index}.png`" :alt="`Screenshot ${index + 1}`"
             :class="{ active: index === activeIndex}"/>
      </div>
      <div class="screenshot-gallery" v-else>
        <img  v-for="index in parseInt(game.screenshot)" :key="index"
              :src="`http://localhost:8080/api/files/game${game.id}-${index}.png`" :alt="`Screenshot ${index + 1}`"
              :class="{ active: index === activeIndex + 1}"/>
      </div>
      <button @click="prevSlide" class="carousel-button prev">‹</button>
      <button @click="nextSlide" class="carousel-button next">›</button>
      <div class="dots" v-if="game.link">
        <span v-for="index in parseInt(game.screenshot) + 1" :key="index"
              :class="{ active: index === activeIndex + 1 }"></span>
      </div>
      <div class="dots" v-else>
        <span v-for="index in parseInt(game.screenshot) " :key="index"
              :class="{ active: index === activeIndex +1 }"></span>
      </div>
    </div>
    <div class="game-info">
      <div class="left-part">
        <img :src="`http://localhost:8080/api/files/game${game.iconId}.png`" alt="Game Icon"/>
        <div class="game-details">
          <h1>{{ game.name }}</h1>
          <p><strong>Release Date:</strong> {{ new Date(game.createdAt).toLocaleDateString() }}</p>
          <p><strong>Current Version:</strong> {{ game.version }}</p>
        </div>
      </div>
      <div class="download-box">
        <div class="download-buttons">
          <p v-if="game.price === 0">Download for Free</p>
          <p v-else-if="game.price === -1">This game is unavailable</p>
          <p v-else-if="game.price === -2">Coming Soon</p>
          <p v-else>{{ game.price }}</p>
          <a v-if="gameLinks.win" class="download-button" :href="gameLinks.win" download>Download Windows</a>
          <a v-if="gameLinks.mac" class="download-button" :href="gameLinks.mac" download>Download Mac</a>
          <a v-if="gameLinks.lin" class="download-button" :href="gameLinks.lin" download>Download Linux</a>
          <p v-if="!gameLinks.win && !gameLinks.mac && !gameLinks.lin">No downloads</p>
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
  width: 200px;
  height: auto;
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