<script setup lang="ts">
import {getCurrentInstance, onMounted, ref} from 'vue';
import { useRouter } from 'vue-router';
import ToolCard from "@/components/ToolCard.vue";
import { Tool } from "@/assets/types";

const tools = ref<Tool[] | null>(null);

const fetchTools = async () => {
  try {
    const { appContext } = getCurrentInstance()!;
    const apiAddress = appContext.config.globalProperties.$apiAddress;
    const response = await fetch(`${apiAddress}/tools`);
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data: Tool[] = await response.json();
    tools.value = data;
  } catch (error) {
    console.error('Failed to fetch games:', error);
  }
};

const router = useRouter();

const navigateToToolView = (tool: Tool) => {
  router.push({ name: 'ToolPage', params: { id: tool.id } });
};

onMounted(fetchTools);
</script>

<template>
  <div class="game-store">
    <h1>Apps</h1>
    <div class="game-grid">
      <ToolCard
          v-for="tool in tools || []"
          :key="tool.id"
          :id="tool.id"
          :title="tool.name"
          :description="tool.description"
          :version="tool.version"
          :icon-id="tool.iconId"
          :link="tool.link"
          :price="tool.price"
          :created-at="tool.createdAt"
          @game-clicked="navigateToToolView"
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