<script setup>
import { onMounted, onUnmounted } from 'vue';
import Brands from "@/components/Brands.vue";
import Project from "@/components/Project.vue";
import Hero from "@/components/Hero.vue";
import Menubar from "@/components/Menubar.vue";
import partyPoopersImage from '@/assets/images/projects/party-poopers.svg';
import warehouseSimulatorImage from '@/assets/images/projects/wws.svg';
import learniverseConnectImage from '@/assets/images/projects/learniverse-connect.svg';
import pathsImage from '@/assets/images/projects/paths.png';
import FrontendSkill from "@/components/FrontendSkill.vue";
import Contact from "@/components/Contact.vue";



</script>

<template>
  <div class="container">
    <Hero />
    <Contact/>
    <FrontendSkill/>

    <h1>Featured Projects</h1>
    <div class="project-grid">
      <Project
          date="Spring 2023"
          :icon="pathsImage"
          name="Paths"
          description="Final Project for Programming 2 Course"
          link="https://mattkje.github.io/"
      />
      <Project
          date="Spring 2024"
          :icon="learniverseConnectImage"
          name="Learniverse Connect"
          description="Final Project for Web Development Course"
          link="https://mattkje.github.io/"
      />
      <Project
          date="Fall 2024"
          :icon="partyPoopersImage"
          name="Party Poopers"
          description="Final Project for Game Development Course"
          link="https://shelstad.itch.io/party-poopers"
      />
      <Project
          date="Spring 2025"
          :icon="warehouseSimulatorImage"
          name="Warehouse Simulator (WWS)"
          description="Bachelor's Thesis Project"
          link="https://github.com/mattkje/group01-bachelor-2025"
      />
    </div>
  </div>
</template>

<style scoped>
.container {
  margin: 0;
}

.menubar.scrolled {
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

.brands {
  display: flex;
  flex-direction: row;
}

.project-grid {
  margin: 5rem;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1rem;
}


.skills-section {
  margin: 5rem;
  text-align: left;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
