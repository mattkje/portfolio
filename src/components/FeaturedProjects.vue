<script setup>

import pathsImage from "@/assets/images/projects/paths.png";
import learniverseConnectImage from "@/assets/images/projects/learniverse-connect.svg";
import partyPoopersImage from "@/assets/images/projects/party-poopers.svg";
import warehouseSimulatorImage from "@/assets/images/projects/wws.svg";
import Project from "@/components/Project.vue";

document.addEventListener('DOMContentLoaded', () => {
  const elements = document.querySelectorAll('.scroll-animation, .project-grid-item-animation');

  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.classList.add('visible');
      } else {
        entry.target.classList.remove('visible');
      }
    });
  });

  elements.forEach(element => {
    observer.observe(element);
  });
});
</script>

<template>
  <div class="container">
  <div class="scroll-animation">
    <h1>Featured Projects</h1>
  </div>
  <div class="scroll-animation">
    <p>Some of my most recent major projects</p>
  </div>
  </div>
  <div class="project-grid">
    <Project class="project-grid-item-animation"
        date="Spring 2023"
        :icon="pathsImage"
        name="Paths"
        description="Final Project for Programming 2 Course"
        link="https://mattkje.github.io/"
    />
    <Project class="project-grid-item-animation"
        date="Spring 2024"
        :icon="learniverseConnectImage"
        name="Learniverse Connect"
        description="Final Project for Web Development Course"
        link="https://mattkje.github.io/"
    />
    <Project class="project-grid-item-animation"
        date="Fall 2024"
        :icon="partyPoopersImage"
        name="Party Poopers"
        description="Final Project for Game Development Course"
        link="https://shelstad.itch.io/party-poopers"
    />
    <Project class="project-grid-item-animation"
        date="Spring 2025"
        :icon="warehouseSimulatorImage"
        name="Warehouse Simulator (WWS)"
        description="Bachelor's Thesis Project"
        link="https://github.com/mattkje/group01-bachelor-2025"
    />
  </div>
</template>

<style scoped>
.container {
  margin-top: 5rem;
}

.scroll-animation {
  opacity: 0;
  transform: translateY(20px);
  transition: opacity 0.6s ease-out, transform 0.6s ease-out;
}

.scroll-animation.visible {
  opacity: 1;
  transform: translateY(0);
}

.project-grid-item-animation {
  opacity: 0;
  transform: translateY(20px);
  transition: opacity 0.6s ease-out, transform 0.6s ease-out;
}

.project-grid-item-animation.visible {
  opacity: 1;
  transform: translateY(0);
}

.project-grid {
  margin: 0 5rem 5rem 5rem;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1rem;
}

</style>