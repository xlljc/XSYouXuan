import {RouteConfig} from "vue-router";
import BackHome from "@/views/back/BackHome.vue";
import Commodity from "@/components/back/home/Commodity/Commodity.vue";
import CommodityTypeMaintain from "@/components/back/home/CommodityTypeMaintain.vue";
import Warehousemaintain from "@/components/back/home/Warehousemaintain.vue";
import EmpManagement from "@/components/back/home/system/emp/EmpManagement.vue";

/**
 * 后台路由
 */
const BackRouter: Array<RouteConfig> = [
    {path: '/', component: BackHome,},
     //商品资料维护
    {path:"/commodity",component:Commodity},
    //商品类型维护
    {path:"/typemaintain",component:CommodityTypeMaintain},
    //仓库信息维护
    {path:"/warehousemaintain",component:Warehousemaintain},
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
    //员工管理
    {path:"/empManagement",component:EmpManagement},
]

export default BackRouter;