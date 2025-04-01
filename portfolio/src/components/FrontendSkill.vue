<script setup>

</script>
<template>
  <div class="container scroll-animation">
    <h1>Frontend Development & Asset Creation</h1>
    <div class="skills-section scroll-animation">
      <div class="skill-block card-hand">
        <img src="@/assets/icons/js.png" alt="icon missing" class="skill-icon card" />
        <img src="@/assets/icons/ts.png" alt="icon missing" class="skill-icon card" />
        <img src="@/assets/icons/html.svg" alt="icon missing" class="skill-icon card" />
        <img src="@/assets/icons/css.svg" alt="icon missing" class="skill-icon card" />
        <p>HTML, CSS, JavaScript, Typescript</p>
      </div>
      <div class="skill-block card-hand">
        <img src="@/assets/icons/vue.svg" alt="icon missing" class="skill-icon card" />
        <img src="@/assets/icons/react.png" alt="icon missing" class="skill-icon card" />
        <img src="@/assets/icons/unity.png" alt="icon missing" class="skill-icon card" />
        <img src="@/assets/icons/flutter.png" alt="icon missing" class="skill-icon card" />
        <p>Vue.js, React, Unity UI, Flutter</p>
      </div>
      <div class="skill-block card-hand">
        <img src="@/assets/icons/ps.png" alt="icon missing" class="skill-icon card" />
        <img src="@/assets/icons/affinity.png" alt="icon missing" class="skill-icon card" />
        <img src="@/assets/icons/figma.png" alt="icon missing" class="skill-icon card" />
        <p>Adobe Photoshop, Affinity Designer and Figma</p>
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
  margin: 5rem auto 0 auto;
}

.skill-block {
  border: #e3e3e3 solid 1px;
  width: 25%;
  height: 60%;
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
  border-radius: 0.5rem;
  margin-bottom: 0.5rem;
}

.skill-block p {
  font-size: 1rem;
  line-height: 1.5rem;
  margin: 2rem 0 0 0;
}

.link {
  align-self: flex-end;
  color: white;
  padding: 0.7rem 1.2rem;
  margin: 0 auto;
  border: none;
  border-radius: 1.5rem;
  background-color: #608AFF;
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

.card-hand {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
}

.card {
  position: absolute;
  bottom: 7rem;
  transition: transform 0.3s;
}

.card:nth-child(1) {
  transform: rotate(0deg) translateX(0);
}

.card:nth-child(2) {
  transform: rotate(0deg) translateX(0);
}

.card:nth-child(3) {
  transform: rotate(0deg) translateX(0);
}

.card:nth-child(4) {
  transform: rotate(0deg) translateX(0);
}

.card-hand:hover .card:nth-child(1) {
  transform: rotate(-15deg) translateX(-60px);
}

.card-hand:hover .card:nth-child(2) {
  transform: rotate(-5deg) translateX(-20px);
}

.card-hand:hover .card:nth-child(3) {
  transform: rotate(5deg) translateX(20px);
}

.card-hand:hover .card:nth-child(4) {
  transform: rotate(15deg) translateX(60px);
}
</style>