import {Message, OrderDetails} from "@/helper/entity";
import Axios from "axios";
import {UserHelper} from "@/helper/front/UserHelper";


export class ShopHelper {

    /**
     * 查询订单信息
     * @param str 条件
     * @param state 订单状态
     * @param page 当前页数
     * @param row 每页条数
     */
    static async queryOrderDetails(str: string, state: number, page: number, row: number): Promise<OrderDetails> {
        let params = new URLSearchParams();
        params.append("merId", UserHelper.userId);
        params.append("str", str);
        params.append("page", page.toString());
        params.append("row", row.toString());
        if (state !== null) params.append("state", state.toString());
        return (await Axios.post("/orderDetails/queryForMer", params)).data;
    }

    /**
     * 收货
     * @param ids
     */
    static async shouHuo(ids: number[]): Promise<Message> {
        let params = new URLSearchParams();
        params.append("merId",UserHelper.userId);
        params.append("ids",ids.toString());
        return (await Axios.post("/orderDetails/shouHuo",params)).data;
    }

    static async tiHuo(ids: number[]): Promise<Message> {
        let params = new URLSearchParams();
        params.append("merId",UserHelper.userId);
        params.append("ids",ids.toString());
        return (await Axios.post("/orderDetails/tiHuo",params)).data;
    }

}