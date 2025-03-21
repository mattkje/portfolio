// src/router/index.ts
import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import GameHome from '../views/GameHome.vue';
import GameView from "@/views/GameView.vue";


const routes = [
    { path: '/', component: Home },
    { path: '/shelstad', component: GameHome },
    {
        path: '/game/:title',
        name: 'GameView',
        component: GameView,
        props: true
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;