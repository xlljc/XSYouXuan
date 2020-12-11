import {RouteConfig} from "vue-router";
import TestYzm from "@/components/shop/TestYzm.vue";

/**
 * 后台路由
 */
const ShopRouter: Array<RouteConfig> = [
    {
        path: '/y1',
        component: TestYzm
    }
]

export default ShopRouter;