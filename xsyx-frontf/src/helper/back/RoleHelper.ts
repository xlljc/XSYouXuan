import Axios from "axios";
import {Employee, Menu, Message, PageInfo, Role} from "@/helper/entity";
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
     * 查询拥有的角色, 带分页
     * @param str 查询条件
     * @param page 页数
     * @param row 每页条数
     */
    static async queryHave(str: string,page: number,row: number) {
        let params = new URLSearchParams();
        params.append("name",str);
        params.append("empId",EmpHelper.empId);
        params.append("remark",str);
        params.append("page",page.toString());
        params.append("row",row.toString());
        return (await Axios.post<PageInfo<Role>>("/role/queryHaveRole",params)).data;
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

    /**
     * 删除一个角色
     * @param id 角色id
     */
    static async delete(id: number) {
        let params = new URLSearchParams();
        params.append("id",id.toString());
        params.append("empId",EmpHelper.empId);
        return (await Axios.post<Message>("/role/delete",params)).data;
    }

    /**
     * 根据角色id获取拥有该角色的所有员工
     * @param id
     */
    static async getEmpsByRoleId(id: number) {
        let params = new URLSearchParams();
        params.append("id",id.toString());
        return (await Axios.post<Employee[]>("/emp/queryByRoleId",params)).data;
    }

    /**
     * 根据角色id获取该角色的所有菜单
     * @param roleId
     */
    static async getMenus(roleId: number) {
        let params = new URLSearchParams();
        params.append("id",roleId.toString());
        return (await Axios.post<Menu[]>("/role/queryMenus",params)).data;
    }

    /**
     * 授权操作
     * @param addIds 新增的的权限
     * @param removeIds 移除的权限
     * @param roleId 角色id
     */
    static async authorization(addIds: number[],removeIds: number[],roleId: number) {
        let params = new URLSearchParams();
        params.append("empId", EmpHelper.empId);
        params.append("addIds", addIds.toString());
        params.append("removeIds", removeIds.toString());
        params.append("roleId", roleId.toString());
        return (await Axios.post<Message>("/role/authorization", params)).data;
    }

}