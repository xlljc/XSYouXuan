import {RouteConfig} from "vue-router";
import ShopShouhuo from "@/components/shop/Shouhuo/ShopShouhuo.vue";
import ShopTihuo from "@/components/shop/Tihuo/ShopTihuo.vue";
import ShopSearch from "@/components/shop/Search/ShopSearch.vue";
import ShopStatistics from "@/components/shop/Statistics/ShopStatistics.vue";


/**
 * 商户路由
 */
const ShopRouter: Array<RouteConfig> = [
    {
        path: '/shouhuo',
        component: ShopShouhuo
    },
    {
        path: '/tihuo',
        component: ShopTihuo
    },
    {
        path: '/search',
        component: ShopSearch
    },
    {
        path: '/statistics',
        component: ShopStatistics
    }
]

export default ShopRouter;