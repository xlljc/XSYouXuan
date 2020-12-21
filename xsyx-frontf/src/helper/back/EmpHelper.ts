import {Employee, Message, PageInfo} from "@/helper/entity";
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
            let params = Utils.format(new URLSearchParams(),employee,"password","name");
            Axios.post("/emp/login",params).then(value => {
                resolve(value.data);
            })
        });
    }

    /**
     * 根据条件查询员工
     */
    static query(str: string,sex: string,state: number, page: number, row: number): Promise<PageInfo<Employee>> {
        return new Promise<PageInfo<Employee>>(resolve => {
            let param = new URLSearchParams();
            param.set("name",str);
            if (sex !== null) param.set("sex",sex);
            if (state !== null) param.set("state",state.toString());
            param.set("page",page.toString());
            param.set("row",row.toString());
            Axios.post("/emp/query",param).then(value => {
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
            console.log(empInfo,EmpHelper.empId);
            let params = Utils.format(new URLSearchParams(),empInfo,"name","image","sex","phone","icCard","email","address","remark");
            params.set("empId",EmpHelper.empId);
            Axios.post("/emp/insert",params).then(value => {
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
            console.log(empInfo,EmpHelper.empId);
            let params = Utils.format(new URLSearchParams(),empInfo,"id","name","image","sex","phone","icCard","email","address","remark");
            params.set("empId",EmpHelper.empId);
            Axios.post("/emp/update",params).then(value => {
                resolve(value.data);
            })
        })
    }

}