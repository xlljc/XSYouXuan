import {RouteConfig} from "vue-router";
import Demo01 from "@/views/front/Demo01.vue";
import Login from "@/views/front/Login.vue";
import Registered from "@/views/front/Registered.vue";
import UserHome from "@/views/front/UserHome.vue";
import Shopcar from "@/views/front/Shopcar.vue";
import Shopes from "@/views/front/Shopes.vue";


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
    },{
        path:'/zc',
        component:UserHome
    },{
    path:'/gwc',
        component:Shopcar
    },{
    path:'/spxq',
        component:Shopes
    }

]


export default FontRouter;