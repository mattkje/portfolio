// src/router/index.ts
import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import GamePage from "@/views/GamePage.vue";
import IconPage from "@/views/IconPage.vue";


const routes = [
    { path: '/', component: Home },
    {
        path: '/game/:title',
        name: 'GamePage',
        component: GamePage,
        props: true
    },
    { path: '/icons', component: IconPage }

];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;