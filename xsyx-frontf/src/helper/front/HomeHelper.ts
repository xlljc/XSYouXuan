import {ComType} from "@/helper/entity";
import Axios from "axios";


export class HomeHelper {

    static async getHotTypes(row: number): Promise<ComType> {
        let params = new URLSearchParams();
        params.append("row",row.toString());
        return (await Axios.post("/home/getHotTypes",params)).data;
    }


}