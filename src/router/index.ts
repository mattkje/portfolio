// src/router/index.ts
import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import GameHome from '../views/GameHome.vue';


const routes = [
    { path: '/', component: Home },
    { path: '/shelstad', component: GameHome },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;