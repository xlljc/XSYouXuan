import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import FrontHome from '../views/front/FrontHome.vue'
import BackHome from '../views/back/BackHome.vue'
import FontRouter from "@/router/front/frontRouter";
import BackRouter from "@/router/back/backRouter";
import ShopRouter from "@/router/shop/shopRouter";
import TestYzm from "@/components/shop/TestYzm.vue";
import Demo1 from "@/views/shop/Demo1.vue";

Vue.use(VueRouter)

/**
 * 这里的嵌套路由不需要加上父级路由地址,后面的处理器会自动加上
 */
const routes: Array<RouteConfig> = [
  /**
   * 首页路由
   */
  {
    path: '/',
    component: FrontHome
  },
  /**
   * 后台路由,访问地址 /back/.....
   */
  {
    path: '/back',
    component: BackHome,
    children: BackRouter
  },
  {
    path: '/shop',
    component: Demo1,
    children: ShopRouter
  },
  /**
   * 前台路由, 访问地址 /.....
   */
  ...FontRouter,
];


//后台路由处理器
//给每一个路由前加上父级的路由名称
function addParentUrl(parentUrl: string,routers: Array<RouteConfig>) {
  for (let i of routers) {
    let temp = i.path;
    i.path = parentUrl + i.path;
    if (i.children) addParentUrl(parentUrl + temp,i.children);
  }
}
addParentUrl('',routes);

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
