<script setup>
    import { computed } from 'vue';
    import githubIcon from '/src/assets/icons/github.png';
    import linkedinIcon from '/src/assets/icons/linkedin.png';
    import youtubeIcon from '/src/assets/icons/youtube.png';
    import storeIcon from '/src/assets/images/game/shelstad-color.svg';

    const platforms = [
      { name: 'GitHub', url: 'https://github.com/mattkje', icon: githubIcon },
      { name: 'LinkedIn', url: 'https://www.linkedin.com/in/mattkje', icon: linkedinIcon },
      { name: 'YouTube', url: 'https://www.youtube.com/@shelstad', icon: youtubeIcon },
      { name: 'Shelstad Store', url: 'https://shelstad.store', icon: storeIcon }
    ];

    const props = defineProps({
      isMobile: {
        type: Boolean,
        default: false
      }
    });

    const containerClass = computed(() => (props.isMobile ? 'contact-section-mobile' : 'contact-section'));
    const platformClass = computed(() => (props.isMobile ? 'platform-mobile' : 'platform'));
    const iconClass = computed(() => (props.isMobile ? 'platform-icon-mobile' : 'platform-icon'));
    </script>

    <template>
      <div :class="containerClass">
        <h2>Contact & Platforms</h2>
        <div class="platforms">
          <a v-for="platform in platforms" :key="platform.name" :href="platform.url" target="_blank" rel="noopener noreferrer" :class="platformClass">
            <img :src="platform.icon" alt="?" :class="iconClass" />
            <p>{{ platform.name }}</p>
          </a>
        </div>
      </div>
    </template>

    <style scoped>
    .contact-section {
      margin-bottom: 5rem;
      text-align: center;
    }

    .contact-section-mobile {
      margin-bottom: 2rem;
      text-align: center;
    }

    .platforms {
      border-bottom: #e3e3e3 solid 1px;
      border-top: #e3e3e3 solid 1px;
      width: 50%;
      padding-top: 2rem;
      margin: auto;
      display: flex;
      justify-content: space-around;
      flex-wrap: wrap;
    }

    .platform {
      display: flex;
      flex-direction: column;
      align-items: center;
      text-align: center;
      margin: 1rem;
    }

    .platform-mobile {
      width: min-content;
      margin: 0.5rem 0;
    }

    .platform-icon {
      width: 50px;
      height: 50px;
      object-fit: contain;
      margin-bottom: 0.5rem;
      filter: grayscale(100%);
      transition: transform 0.3s ease, filter 0.3s ease;
    }

    .platform-icon-mobile {
      width: 30px;
      height: 30px;
      object-fit: contain;
      margin-bottom: 0.5rem;
      filter: grayscale(100%);
      transition: transform 0.3s ease, filter 0.3s ease;
    }

    .platform-icon:hover {
      transform: scale(1.2);
      filter: grayscale(0%);
    }

    .platform-icon-mobile:hover {
      transform: scale(1.2);
      filter: grayscale(0%);
    }

    .platform p {
      font-size: 1rem;
      margin: 0;
    }

    a {
      text-decoration: none;
    }

    a p {
      margin-top: 0;
      color: #a9a9a9;
      transition: color 0.3s;
    }

    a:hover p {
      color: black;
    }
    </style>