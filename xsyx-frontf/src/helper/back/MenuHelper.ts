import Axios from "axios";
import {Menu} from "@/helper/entity";
import {EmpHelper} from "@/helper/back/EmpHelper";

export class MenuHelper {

    getMenuData(): Promise<Menu[]> {
        return new Promise<Menu[]>(resolve => {
            //let data = new URLSearchParams();
            //data.append("name","111");
            //后台异步获取菜单
            let params = new URLSearchParams();
            params.set("id",EmpHelper.empId);
            Axios.post("/emp/queryMenus",params).then(value => {
                resolve(value.data);
            })
        });
    }

}