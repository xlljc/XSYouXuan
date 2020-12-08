import {RouteConfig} from "vue-router";
import BackHome from "@/views/back/BackHome.vue";

/**
 * 后台路由
 */
const BackRouter: Array<RouteConfig> = [
    {
        path: '/',
        name: 'Back',
        component: BackHome,
    },
    {
        path: '/aaa',
        name: 'aaa',
        component: BackHome,
        children: [
            {
                path: '/aaa',
                name: 'aaa',
                component: BackHome,
            }
        ]
    }
]

export default BackRouter;