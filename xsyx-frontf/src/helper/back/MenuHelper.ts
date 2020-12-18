import Axios from "axios";
import {Menu} from "@/helper/entity";

export class MenuHelper {

    getMenuData(): Promise<Menu[]> {
        return new Promise<Menu[]>(resolve => {
            //let data = new URLSearchParams();
            //data.append("name","111");
            //后台异步获取菜单
            Axios.get("menu/queryAll").then(value => {
                resolve(value.data);
            })
        });
    }

}