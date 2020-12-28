import {Message, OrderDetails, ShopStatisticalType} from "@/helper/entity";
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

        params.append("merId", UserHelper.merId);
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
        params.append("merId",UserHelper.merId);
        params.append("ids",ids.toString());
        return (await Axios.post("/orderDetails/shouHuo",params)).data;
    }

    static async tiHuo(ids: number[]): Promise<Message> {
        let params = new URLSearchParams();
        params.append("merId",UserHelper.merId);
        params.append("ids",ids.toString());
        return (await Axios.post("/orderDetails/tiHuo",params)).data;
    }

    static async statistical(day: number): Promise<ShopStatisticalType> {
        let params = new URLSearchParams();
        params.append("merId", UserHelper.merId);
        params.append("day", day.toString());
        let data: ShopStatisticalType = (await Axios.post("/orderDetails/statistical", params)).data;

        let now = Date.now();

        if (day <= 30) {
            let dayTime = 1000 * 60 * 60 * 24;
            goto:for (let i = 0; i < day; i++) {
                let temp = new Date(now);
                now -= dayTime;
                let thisDate = `${temp.getMonth() + 1}-${temp.getDate()}`;
                for (let i = 0; i < data.timeIncome.length; i++) {
                    let item = data.timeIncome[i];
                    if (item.date === thisDate){
                        data.timeIncome.splice(i,1);
                        data.timeIncome.push(item);
                        continue goto;
                    }
                }
                data.timeIncome.push({date: thisDate, value: 0});
            }
        } else {
            let months = this.getMonth();
            console.log("months: ", months);
            goto:for (let thisDate of months) {
                for (let i = 0; i < data.timeIncome.length; i++) {
                    let item = data.timeIncome[i];
                    if (item.date === thisDate){
                        data.timeIncome.splice(i,1);
                        data.timeIncome.push(item);
                        continue goto;
                    }
                }
                data.timeIncome.push({date: thisDate, value: 0});
            }
        }
        return data;
    }

    private static getMonth(): string[] {
        let list: string[] = [];
        let date = new Date();
        let y = date.getFullYear();
        let m = date.getMonth() + 1;
        for (let i = 0; i < 12; i++) {
            if (m === 0) {
                m = 12;
                y--;
            }
            list.push(y + "-" + m--);
        }
        return list.reverse();
    }

}