import {ComType, HomeDataType} from "@/helper/entity";
import Axios from "axios";


export class HomeHelper {

    /**
     * 获取热门分类
     */
    static async getHotTypes(): Promise<ComType[]> {
        return (await Axios.get("/comType/queryHot")).data;
    }

    /**
     * 获取首页数据
     */
    static async getHomeDate(): Promise<HomeDataType> {
        return (await Axios.get("/commodity/queryHome")).data;
    }


}