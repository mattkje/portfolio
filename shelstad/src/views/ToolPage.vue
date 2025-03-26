<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';

// Import or define the Tool type
interface Tool {
  id: number;
  name: string;
  description: string;
  price: number;
  screenshot: string;
  iconId: number;
}

const route = useRoute();
const tool = ref<Tool | null>(null);
const toolLinks = ref<{ [key: string]: string | null }>({});

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

onMounted(() => {
  const toolId = Number(route.params.id);
  fetchTool(toolId);
});
</script>

<template>
  <div v-if="tool" class="tool-page">
    <h1>{{ tool.name }}</h1>
    <div class="screenshots">
      <div class="screenshot-gallery">
        <img v-for="index in parseInt(tool.screenshot)" :key="index" :src="`http://localhost:8080/api/files/tool${tool.id}-${index}.png`" :alt="`Screenshot ${index + 1}`" />
      </div>
    </div>
    <p>{{ tool.description }}</p>
    <p v-if="tool.price === 0">Free</p>
    <p v-else>\${{ tool.price }}</p>
    <div class="download-box">
      <img :src="`http://localhost:8080/api/files/tool${tool.iconId}.png`" alt="Tool Icon" />
      <div class="download-buttons">
        <a v-if="toolLinks.win" class="download-button" :href="toolLinks.win" download>Download for Windows</a>
        <a v-if="toolLinks.mac" class="download-button" :href="toolLinks.mac" download>Download for Mac</a>
        <a v-if="toolLinks.lin" class="download-button" :href="toolLinks.lin" download>Download for Linux</a>
      </div>
    </div>
  </div>
  <div v-else>
    <p>Loading...</p>
  </div>
</template>

<style scoped>
.tool-page {
  text-align: center;
  margin-top: 100px;
  padding: 2rem;
}

.tool-page img {
  width: 200px;
  height: auto;
  border-radius: 3rem;
}

.download-buttons {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  justify-content: center;
  margin-top: 2rem;
}

.download-button {
  align-self: flex-end;
  text-align: center;
  color: white;
  padding: 0.7rem 3rem;
  border-radius: 1.5rem;
  background-color: hsla(210, 100%, 50%, 1); /* Blue color */
  text-decoration: none;
  font-weight: bold;
  font-size: 1rem;
  margin: 0 auto;
  transition: transform 0.3s, color 0.3s;
}

.download-button:hover {
  transform: scale(1.1);
}

.screenshot-gallery {
  display: flex;
  gap: 1rem;
  overflow-x: auto;
  justify-content: center;
}

.screenshot-gallery img {
  width: 700px;
  height: auto;
  border-radius: 1rem;
}

.download-box {
  display: flex;
  border: #e3e3e3 solid 1px;
  width: 600px;
  margin: auto;
  padding: 1rem;
  border-radius: 4rem;
  gap: 2rem;
  justify-content: space-between;
  align-items: center;
}
</style>