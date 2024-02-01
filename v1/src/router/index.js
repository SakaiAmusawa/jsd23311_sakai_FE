import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }, {
    path: '/bind',
    name: 'bind',
    component: () => import('../views/Bind.vue')
  }, {
    path: '/TW-bind',
    name: 'TW-bind',
    component: () => import('../views/TwoWaysBind.vue')
  }
  , {
    path: '/Event-bind',
    name: 'Event-bind',
    component: () => import('../views/EventBand.vue')
  }, {
    path: '/For-cmd', name: 'For-cmd', component: () => import('../views/ForCmd.vue')
  }, {
    path: '/hidden-display', name: 'hidden-display', component: () => import('../views/HiddenOrDisplay.vue')
  }, {
    path: '/calculator', name: 'calculator', component: () => import('../views/CalculatorExec.vue')
  }
  , {
    path: '/guess', name: 'guess', component: () => import('../views/GuessExec.vue')
  }, {
    path: '/empList', name: 'empList', component: () => import('../views/EmpListExec.vue')
  }
  , {
    path: '/resume', name: 'resume', component: () => import('../views/ResumeExec.vue')
  }, {
    path: '/elButton', name: 'elButton', component: () => import('../views/ElementButton.vue')
  }
  , {
    path: '/elicon', name: 'elicon', component: () => import('../views/ElIcon.vue')
  }, {
    path: '/elMessage', name: 'elMessage', component: () => import('../views/Message.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
