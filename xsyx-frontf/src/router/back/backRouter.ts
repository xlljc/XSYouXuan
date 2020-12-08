import {RouteConfig} from "vue-router";
import BackHome from "@/views/back/BackHome.vue";

/**
 * 后台路由
 */
const BackRouter: Array<RouteConfig> = [
    {
        path: '/',
        component: BackHome,
    },
    {
        path: '/aaa',
        component: BackHome,
        children: [
            {
                path: '/aaa',
                component: BackHome,
            }
        ]
    }
]

export default BackRouter;