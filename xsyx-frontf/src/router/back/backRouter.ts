import {RouteConfig} from "vue-router";
import BackHome from "@/views/back/BackHome.vue";
import Commodity from "@/components/back/home/Commodity.vue";
import CommodityTypeMaintain from "@/components/back/home/CommodityTypeMaintain.vue";

/**
 * 后台路由
 */
const BackRouter: Array<RouteConfig> = [
    {path: '/', component: BackHome,},
    {path:"/commodity",component:Commodity},
    {path:"/typemaintain",component:CommodityTypeMaintain},
    /*{
        path: '/aaa',
        component: BackHome,
        children: [
            {
                path: '/aaa',
                component: BackHome,
            }
        ]
    }*/
]

export default BackRouter;