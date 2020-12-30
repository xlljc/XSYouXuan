import {Merchants, MerchantsApply, Message, PageInfo} from "@/helper/entity";
import Axios from "axios";
import Utils from "@/helper/Utils";
import {EmpHelper} from "@/helper/back/EmpHelper";

export class MerchantsHelper {


    static async query(str: string, page: number, row: number): Promise<PageInfo<Merchants>> {
        let params = new URLSearchParams();
        params.append("str", str);
        params.append("page", page.toString());
        params.append("row", row.toString());
        return (await Axios.post("/merchants/query", params)).data;
    }


    static async update(mer: Merchants): Promise<Message> {
        let params = Utils.format(new URLSearchParams(), mer, "id", "name", "remark", "address", "phone")
        params.append("empId", EmpHelper.empId);
        return (await Axios.post("/merchants/update", params)).data;
    }


    static async delete(merId: number): Promise<Message> {
        let params = new URLSearchParams();
        params.append("empId", EmpHelper.empId);
        params.append("merId", merId.toString());
        return (await Axios.post("/merchants/delete", params)).data;
    }


    static async queryApply(str: string, page: number, row: number): Promise<PageInfo<MerchantsApply>> {
        console.log(str,page,row);
        let params = new URLSearchParams();
        params.append("str", str);
        params.append("page", page.toString());
        params.append("row", row.toString());
        return (await Axios.post("/merchants/queryApply",params)).data;
    }

    static async approval(id: number, flag: boolean, message: string): Promise<Message> {
        let params = new URLSearchParams();
        params.append("id", id.toString());
        params.append("flag", flag.toString());
        params.append("message", message);
        params.append("empId", EmpHelper.empId);
        return (await Axios.post("/merchants/approval",params)).data;
    }

}