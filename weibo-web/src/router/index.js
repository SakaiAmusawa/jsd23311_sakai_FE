import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
    {
        path: '/',
        name: 'home',
        component: HomeView
    },
    {path: '/reg', component: () => import('../views/RegView')},
    {path: '/login', component: () => import('../views/LoginView')},
    {path: '/detail', component: () => import('../views/DetailView')},
    {path: '/post', component: () => import('../views/PostView.vue')},
    {path: '/personal', component: () => import('../views/Personal.vue')}
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
