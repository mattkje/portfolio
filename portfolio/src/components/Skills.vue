<script setup>
    import { onMounted, onUnmounted } from 'vue';
    import javaIcon from '@/assets/icons/java.svg';
    import vueIcon from '@/assets/icons/vue.svg';
    import tsIcon from '@/assets/icons/ts.png';
    import jsIcon from '@/assets/icons/js.png';
    import unityIcon from '@/assets/icons/unity.png';
    import gitIcon from '@/assets/icons/git.png';

    const skills = [
      { name: 'Java', icon: javaIcon },
      { name: 'Vue.js', icon: vueIcon },
      { name: 'TypeScript', icon: tsIcon },
      { name: 'JavaScript', icon: jsIcon },
      { name: 'Unity', icon: unityIcon },
      { name: 'Git', icon: gitIcon },
    ];

    let animationFrameId;

    const startAnimation = () => {
      const slider = document.querySelector('.skills-slider');
      let start = null;
      const speed = 0.5; // Adjust speed as needed

      const step = (timestamp) => {
        if (!start) start = timestamp;
        const progress = timestamp - start;
        slider.scrollLeft += speed;
        if (slider.scrollLeft >= slider.scrollWidth / 2) {
          slider.scrollLeft = 0;
        }
        animationFrameId = requestAnimationFrame(step);
      };

      animationFrameId = requestAnimationFrame(step);
    };

    onMounted(() => {
      startAnimation();
    });

    onUnmounted(() => {
      cancelAnimationFrame(animationFrameId);
    });
    </script>

    <template>
      <div class="skills-container">
        <div class="skills-slider">
          <div class="skills-slide" v-for="(skill, index) in skills" :key="index">
            <img :src="skill.icon" :alt="skill.name" class="skill-icon" />
          </div>
          <div class="skills-slide" v-for="(skill, index) in skills" :key="'duplicate-' + index">
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
      width: max-content;
    }

    .skills-slide {
      display: inline-block;
      padding: 0 1rem;
    }

    .skill-icon {
      width: 50px;
      height: 50px;
    }
    </style>