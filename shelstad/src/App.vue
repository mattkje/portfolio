<script setup>
  import Menubar from "@/components/Menubar.vue";
  import { useRoute } from "vue-router";

  const route = useRoute();

  </script>
  <template>
    <div id="app">
      <Menubar class="menubar"/>
      <router-view :key="route.fullPath"></router-view>
    </div>
  </template>

  <style scoped>
  .menubar {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    z-index: 1000;
    transition: box-shadow 0.3s ease;
  }
  </style>