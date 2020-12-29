import {RouteConfig} from "vue-router";
import Demo01 from "@/views/front/Demo01.vue";
import Login from "@/views/front/Login.vue";
import Registered from "@/views/front/Registered.vue";
import UserHome from "@/views/front/UserHome.vue";
import Shopcar from "@/views/front/Shopcar.vue";
import Shopes from "@/views/front/Shopes.vue";
import Information from "@/views/front/Information.vue";
import FrontHome from "@/views/front/FrontHome.vue";
import Dingdan from "@/views/front/Dingdan.vue";
import Shopcars from "@/views/front/Shopcars.vue";
import UpdateUser from "@/views/front/UpdateUser.vue";
import Mylove from "@/views/front/Mylove.vue";
import HomeSearch from "@/components/front/home/HomeSearch.vue";

/**
 * 前台路由
 */
const FontRouter: Array<RouteConfig> = [
    {
        path:'/zc',
        component:Registered
    },{
        path:'/homepage',
        component:UserHome,
        children: [{
            path: "/information",
            component:Information
        },{
            path:'/dd',
            component:Dingdan
        },{
            path:'/updateuser',
            component:UpdateUser
        },{
            path:'/sc',
            component:Mylove
        }
        ],

    },{
        path:'/gwc',
        component:Shopcars
    },{
        path:'/spxq',
        component:Shopes
    },{
        path:'/login',
        component:Login
    },


    {
        path: "/search",
        component: HomeSearch
    }
]


export default FontRouter;