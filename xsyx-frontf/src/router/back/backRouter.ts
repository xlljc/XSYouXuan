import {RouteConfig} from "vue-router";
import BackHome from "@/views/back/BackHome.vue";
import Commodity from "@/components/back/home/Commodity.vue";

/**
 * 后台路由
 */
const BackRouter: Array<RouteConfig> = [
    {path: '/', component: BackHome,},
    {path:"/commodity",component:Commodity},
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