import {RouteConfig} from "vue-router";
import Demo01 from "@/views/front/Demo01.vue";
import Login from "@/views/front/Login.vue";
import Registered from "@/views/front/Registered.vue";


/**
 * 前台路由
 */
const FontRouter: Array<RouteConfig> = [
    {
        path: '/test01',
        component: Login
    },{
    path:'/test02',
        component:Registered
    }


]


export default FontRouter;