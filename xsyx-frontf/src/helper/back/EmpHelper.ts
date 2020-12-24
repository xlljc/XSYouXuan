import {Employee, Message, PageInfo, Role} from "@/helper/entity";
import Axios from "axios";
import {RootRouter} from "@/router";
import Utils from "@/helper/Utils";


export class EmpHelper {

    /**
     * 获取员工id , 从 sessionStorage 中拿
     */
    static get empId(): string {
        let empId = sessionStorage.getItem("empId");
        if (empId === null) RootRouter.router.replace("/backLogin");
        return empId;
    }

    /**
     * 设置员工id , 设置在 sessionStorage 中
     * @param empId
     */
    static set empId(empId: string) {
        if (empId === null || empId === undefined) throw new Error("不能将员工id设置为空!");
        sessionStorage.setItem("empId", empId);
    }

    /**
     * 获取当前员工信息
     */
    static getEmp(): Promise<Employee> {
        return new Promise<Employee>(resolve => {
            Axios({
                method: "post",
                url: "/emp/get/" + EmpHelper.empId
            }).then(value => {
                resolve(value.data);
            });
        });
    }

    /**
     * 员工登录
     * @param employee 员工对象 , 包含姓名和密码
     */
    static login(employee: Employee): Promise<Message> {
        return new Promise<Message>(resolve => {
            let params = Utils.format(new URLSearchParams(), employee, "password", "name");
            Axios.post("/emp/login", params).then(value => {
                resolve(value.data);
            })
        });
    }

    /**
     * 退出登录
     */
    static loginOut() {
        sessionStorage.setItem("empId",null);
        RootRouter.router.replace("/backLogin");
    }

    /**
     * 根据条件查询员工
     */
    static query(str: string, sex: string, state: string, page: number, row: number): Promise<PageInfo<Employee>> {
        return new Promise<PageInfo<Employee>>(resolve => {
            let param = new URLSearchParams();
            param.append("name", str);
            if (sex !== null) param.append("sex", sex);
            if (state !== null) param.append("state", state);
            param.append("page", page.toString());
            param.append("row", row.toString());
            param.append("empId", EmpHelper.empId);
            Axios.post("/emp/query", param).then(value => {
                resolve(value.data);
            });
        });
    }

    /**
     * 添加员工
     * @param empInfo 员工信息
     */
    static addEmp(empInfo: Employee): Promise<Message> {
        return new Promise<Message>(resolve => {
            let params = Utils.format(new URLSearchParams(), empInfo, "name", "image", "sex", "phone", "icCard", "email", "address", "remark");
            params.append("empId", EmpHelper.empId);
            Axios.post("/emp/insert", params).then(value => {
                resolve(value.data);
            })
        })
    }

    /**
     * 修改员工
     * @param empInfo 员工信息
     */
    static updateEmp(empInfo: Employee): Promise<Message> {
        return new Promise<Message>(resolve => {
            let params = Utils.format(new URLSearchParams(), empInfo, "id", "name", "image", "sex", "phone", "icCard", "email", "address", "remark");
            params.set("empId", EmpHelper.empId);
            Axios.post("/emp/update", params).then(value => {
                resolve(value.data);
            })
        })
    }

    /**
     * 冻结员工员工
     * @param empId 被冻结员工id
     */
    static freezeEmp(empId: number): Promise<Message> {
        return new Promise<Message>(resolve => {
            let params = new URLSearchParams();
            params.append("id", empId.toString());
            params.append("empId", EmpHelper.empId);
            Axios.post("/emp/freeze", params).then(value => {
                resolve(value.data);
            })
        })
    }

    /**
     * 激活被冻结的员工
     */
    static unFreezeEmp(empId: number): Promise<Message> {
        return new Promise<Message>(resolve => {
            let params = new URLSearchParams();
            params.append("empId", EmpHelper.empId);
            params.append("id", empId.toString());
            Axios.post("/emp/unFreeze", params).then(value => {
                resolve(value.data);
            })
        })
    }

    /**
     * 验证密码
     * @param password 密码
     */
    static validation(password: string): Promise<Message> {
        return new Promise<Message>(resolve => {
            let params = new URLSearchParams();
            params.append("password", password);
            params.append("empId", EmpHelper.empId);
            Axios.post("/emp/validation", params).then(value => {
                resolve(value.data);
            })
        })
    }

    /**
     * 删除员工
     * @param id
     */
    static deleteEmp(id: number): Promise<Message> {
        return new Promise<Message>(resolve => {
            let params = new URLSearchParams();
            params.append("empId", EmpHelper.empId);
            params.append("id", id.toString());
            Axios.post("/emp/delete", params).then(value => {
                resolve(value.data);
            })
        });
    }

    /**
     * 根据员工id获取该员工所有角色
     * @param id
     */
    static async getRolesByEmpId(id: number) {
        let params = new URLSearchParams();
        params.append("id", id.toString());
        return (await Axios.post<Role[]>("/emp/queryRoles", params)).data;
    }

    /**
     * 修改角色
     * @param id 员工id
     * @param ids 角色id
     */
    static async updateRoles(id: number, ids: number[]) {
        let params = new URLSearchParams();
        params.append("id", id.toString());
        params.append("ids", ids.toString());
        params.append("empId", EmpHelper.empId);
        return (await Axios.post<Message>("/emp/updateRoles", params)).data;
    }

}