<script setup>
const skills = [
  { name: 'HTML, CSS, JavaScript', icon: '@/assets/icons/js.png' },
  { name: 'Vue.js, React', icon: '@/assets/icons/vue.svg' },
  { name: 'Asset creation with Photoshop, Affinity Designer', icon: '@/assets/icons/unity.png' }
];
</script>
<template>
  <div class="container scroll-animation">
    <h1>Frontend Development & Asset Creation</h1>
    <div class="skills-section scroll-animation">
      <div class="skill-block">
        <img src="@/assets/icons/js.png" alt="icon missing" class="skill-icon" />
        <p>HTML, CSS, JavaScript</p>
      </div>
      <div class="skill-block">
        <img src="@/assets/icons/vue.svg" alt="icon missing" class="skill-icon" />
        <p>Vue.js, React</p>
      </div>
      <div class="skill-block">
        <img src="@/assets/icons/affinity.png" alt="icon missing" class="skill-icon" />
        <p>Asset creation with Adobe Photoshop, Affinity Designer and Figma</p>
        <button class="link">Check Out My Icon library</button>
      </div>
    </div>
    <button class="more-link link">View all my skills</button>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.skills-section {
  width: 70%;
  height: 10rem;
  display: flex;
  justify-content: space-around;
  margin: auto;
}

.skill-block {
  border: #e3e3e3 solid 1px;
  width: 25%;
  height: 100%;
  border-radius: 2rem;
  padding: 1.5rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  box-shadow: 0 0 40px rgba(0, 0, 0, 0.1);
  transition: transform 0.7s ease-in-out, box-shadow 0.3s ease-in-out;
}

.skill-block:hover {
  transform: scale(1.05);
  box-shadow: 0 0 50px rgba(0, 0, 0, 0.15);
}

.skill-icon {
  width: 50px;
  height: 50px;
  margin-bottom: 0.5rem;
}

.skill-block p {
  font-size: 1rem;
  line-height: 1.5rem;
  margin: 0;
}

.link {
  align-self: flex-end;
  color: white;
  padding: 0.7rem 1.2rem;
  margin: 0 auto;
  border-radius: 1.5rem;
  background-color: hsla(210, 100%, 50%, 1); /* Blue color */
  text-decoration: none;
  font-weight: bold;
  transition: color 0.3s, transform 0.3s;
}
.link:hover {
  color: hsl(210, 100%, 92%); /* Lighter blue on hover */
  transform: scale(1.1); /* Slightly enlarge on hover */
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

.more-link {
  margin-top: 5rem;
}

</style>