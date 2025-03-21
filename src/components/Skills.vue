<script setup>
  import javaIcon from '@/assets/icons/java.svg';
  import vueIcon from '@/assets/icons/vue.svg';
  import tsIcon from '@/assets/icons/ts.png';
  import jsIcon from '@/assets/icons/js.png';
  import unityIcon from '@/assets/icons/unity.png';
  import gitIcon from '@/assets/icons/git.png';
  // Add more icons as needed

  const skills = [
    { name: 'Java', icon: javaIcon },
    { name: 'Vue.js', icon: vueIcon },
    { name: 'TypeScript', icon: tsIcon },
    { name: 'JavaScript', icon: jsIcon },
    { name: 'Unity', icon: unityIcon },
    { name: 'Git', icon: gitIcon },
    // Add more skills as needed
  ];
  </script>

  <template>
    <div class="skills-container">
      <div class="skills-slider">
        <div class="skills-slide" v-for="(skill, index) in skills" :key="index">
          <img :src="skill.icon" :alt="skill.name" class="skill-icon" />
        </div>
      </div>
    </div>
  </template>

  <style scoped>
  .skills-container {
    overflow: hidden;
    width: 100vw;
    position: relative;
  }

  .skills-slider {
    display: flex;
    animation: slide 20s linear infinite;
  }

  .skills-slide {
    display: inline-block;
    padding: 0 1rem;
  }

  .skill-icon {
    width: 50px;
    height: 50px;
  }

  @keyframes slide {
    0% {
      transform: translateX(100%);
    }
    100% {
      transform: translateX(-100%);
    }
  }
  </style>