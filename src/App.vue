<script setup>
import Menubar from "@/components/Menubar.vue";
import { computed, onMounted, onUnmounted } from "vue";
import GameMenubar from "@/components/Game/GameMenubar.vue";
import { useRoute } from "vue-router";

const route = useRoute();
const isGameView = computed(() => route.path.startsWith('/shelstad'));

onMounted(() => {
  const menubar = document.querySelector('.menubar');
  const handleScroll = () => {
    if (window.scrollY > 0) {
      menubar.classList.add('scrolled');
    } else {
      menubar.classList.remove('scrolled');
    }
  };
  window.addEventListener('scroll', handleScroll);
  onUnmounted(() => {
    window.removeEventListener('scroll', handleScroll);
  });
});
</script>
<template>
  <div id="app">
    <div class="mbc">
      <GameMenubar v-if="isGameView" class="menubar"/>
      <Menubar v-else class="menubar"/>
    </div>
    <router-view></router-view>
  </div>
</template>



<style scoped>
.mbc {
  margin-bottom: 5px;
}

.menubar {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
  transition: box-shadow 0.3s ease;
}

.menubar.scrolled {
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

html, body {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
</style>