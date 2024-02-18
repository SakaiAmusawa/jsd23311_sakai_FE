import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
    {
        path: '/',
        name: 'home',
        component: HomeView,
        children: [
            {
                path: '/reg',
                component: () => import('../views/home/RegView.vue')
            },
            {
                path: 'login',
                component: () => import('../views/home/LoginView.vue')
            },
            {
                path: 'index',
                component: () => import('../views/home/IndexView.vue')
            },
            {
                path: 'detail',
                component: () => import('../views/home/DetailView.vue')
            }
        ]
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
