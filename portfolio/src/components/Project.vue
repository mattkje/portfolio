<script setup>
import {defineProps} from 'vue';

const props = defineProps({
  project: {
    type: Object,
    required: true,
  },
});
</script>

<template>
  <div class="container">
    <div class="vertical-timeline">
      <hr class="timeline-line"/>
      <div class="timeline-circle"></div>
      <hr class="timeline-line"/>
      <div v-if="project.date" class="timeline-date">{{ project.date }}</div>
      <div v-else class="timeline-date">Not Released</div>
    </div>
    <div class="project-box">
      <div class="left-part">
        <div class="image-stack">
          <div class="background-square"></div>
          <img :src="project.icon" alt="Project Icon" class="project-icon"/>
          <div :class="['notch', project.context.toLowerCase()]">{{ project.context }}
          </div>
        </div>
      </div>
      <div class="right-part">
        <div class="project-details">
          <h2 class="project-name">{{ project.title }}</h2>
          <p class="project-date">{{ project.year }}</p>
          <p class="project-description">{{ project.description }}</p>
        </div>
        <div class="buttons">
          <a class="link" v-if="project.link" :href="project.link"> GitHub Page </a>
          <a class="unavailable-link" v-else> Closed Source </a>

          <a class="link shelstad" :href="project.shelstadLink">
            <img src="@/assets/images/game/shelstad-light.svg" alt="Shelstad Icon"
                 style="width: 15px; height: 15px; margin-right: 0.5rem;"/>
            <p>Shelstad page</p>
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  margin: 0;
  height: 100%;
  width: 50%;
}

.vertical-timeline {
  position: relative;
  width: 50px;
  height: calc(240px + 4rem); /* Adjust height to accommodate the timeline */
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0;
  transition: opacity 0.6s ease-out, transform 0.6s ease-out;
}

.vertical-timeline.visible {
  animation: slideInBottom 0.6s forwards;
}

@keyframes slideInBottom {
  from {
    opacity: 0;
    transform: translateY(20%);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.timeline-date {
  position: absolute;
  top: 48%; /* Center the date vertically */
  left: -200%;
  font-size: 0.875rem;
  color: black;
}

.timeline-line {
  border: none;
  border-left: 8px dotted #e7e7e7;
  min-height: calc((240px + 5rem) / 2 - 14px); /* Adjust height to accommodate the timeline */
  width: 100%;
  margin: 0;
}

.timeline-circle {
  min-width: 20px;
  min-height: 20px;
  background-color: #608AFF;
  border-radius: 50%;
  margin: 0 3rem 0 0;
}

.project-box {
  height: 150px;
  width: 120%;
  border: 1px solid #e3e3e3;
  border-radius: 3rem;
  justify-content: space-between;
  display: flex;
  flex-direction: row;
  padding: 1rem 3rem 1rem 1rem;
  margin: 4rem 0;
  opacity: 0;
  transform: translateX(100%);
  transition: opacity 0.6s ease-out, transform 0.6s ease-out;
}

.project-box.visible {
  animation: slideInRight 0.6s forwards;
}

@keyframes slideInRight {
  from {
    opacity: 0;
    transform: translateX(20%);
  }
  to {
    opacity: 1;
    transform: translateX(0);
  }
}

.left-part {
  display: flex;
  flex-direction: row;
  gap: 1rem;
}

.image-stack {
  aspect-ratio: 1 / 1;
  height: 100%;
  position: relative;
  display: inline-block;
}

.background-square {
  position: absolute;
  top: 0;
  left: 0;
  aspect-ratio: 1 / 1;
  height: 100%;
  background-color: #f5f5f5;
  border-radius: 2rem;
  z-index: 0;
}

.project-icon {
  position: relative;
  z-index: 1;
  height: 100%;
  aspect-ratio: 1 / 1;
  object-fit: contain;
  border-radius: 2rem;
}

.notch {
  position: absolute;
  bottom: -10px;
  right: -20px;
  width: 80px;
  height: 40px;
  border-radius: 1rem;
  z-index: 2;
  color: white;
  font-weight: 900;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
}

.school {
  background-color: #ff9ac6;
}

.solo {
  background-color: #65b1e1;
}

.group {
  background-color: #86e3a2;
}

.project-name {
  font-size: 1.2rem;
  margin-bottom: 0.5rem;
}

.project-date {
  font-size: 0.875rem;
  color: var(--color-text);
  margin-bottom: 1rem;
}

.project-description {
  font-size: 0.6rem;
  margin-bottom: 1rem;
}

.right-part {
  display: flex;
  min-width: 80%;
  margin-left: 1.5rem;
  justify-content: space-between;
  align-items: center;
}

.project-details {
  text-align: left;
  width: 80%;
}

.buttons {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.5rem;
}

.link {
  color: white;
  width: 6rem;
  padding: 0.5rem 1rem;
  border-radius: 1.5rem;
  background-color: #608AFF;
  text-decoration: none;
  font-weight: bold;
  font-size: 0.7rem;
  transition: color 0.3s, transform 0.3s;
  white-space: nowrap;
}

.link:hover {
  color: hsl(210, 100%, 92%);
  transform: scale(1.1);
}

.link p {
  margin: 0;
  padding: 0;
  font-size: 0.7rem;
}

.shelstad {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
}

.unavailable-link {
  color: white;
  width: 6rem;
  padding: 0.5rem 1rem;
  border-radius: 1.5rem;
  background-color: hsl(0, 0%, 53%);
  text-decoration: none;
  font-weight: bold;
  font-size: 0.7rem;
  transition: color 0.3s, transform 0.3s;
  white-space: nowrap;
}
</style>