import {Employee} from "@/helper/entity";
import Axios from "axios";

export class EmpHelper {

    /**
     * 获取员工id , 从 sessionStorage 中拿
     */
    static get empId(): string {
        return "1";
        //return sessionStorage.getItem("empId");
    }

    /**
     * 设置员工id , 设置在 sessionStorage 中
     * @param empId
     */
    static set empId(empId: string) {
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

}