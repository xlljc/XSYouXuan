import Axios from "axios";
import {Message, PageInfo, Role} from "@/helper/entity";
import Utils from "@/helper/Utils";
import {EmpHelper} from "@/helper/back/EmpHelper";


export class RoleHelper {

    /**
     * 查询角色, 带分页
     * @param str 查询条件
     * @param page 页数
     * @param row 每页条数
     */
    static async query(str: string,page: number,row: number) {
        let params = new URLSearchParams();
        params.append("name",str);
        params.append("remark",str);
        params.append("page",page.toString());
        params.append("row",row.toString());
        return (await Axios.post<PageInfo<Role>>("/role/query",params)).data;
    }

    /**
     * 添加一个角色
     * @param role 角色属性
     */
    static async insert(role: Role) {
        let params = Utils.format(new URLSearchParams(),role,"name","remark");
        params.append("empId",EmpHelper.empId);
        return (await Axios.post<Message>("/role/insert",params)).data;
    }

    /**
     * 修改一个角色
     * @param role 角色属性
     */
    static async update(role: Role) {
        let params = Utils.format(new URLSearchParams(),role,"id","name","remark");
        params.append("empId",EmpHelper.empId);
        return (await Axios.post<Message>("/role/update",params)).data;
    }
}