import Axios from "axios";
import {Message, PageInfo, User} from "@/helper/entity";
import Utils from "@/helper/Utils";
import {EmpHelper} from "@/helper/back/EmpHelper";

export class CustomerHelper {

    /**
     * 根据条件查询客户
     * @param str 客户信息
     * @param sex 性别
     * @param isRealName 是否实名认证
     * @param page 当前页数
     * @param row 总页数
     */
    static async search(str: string,sex: string, isRealName: number, page: number, row: number) {
        let params = new URLSearchParams();
        params.append("str", str);
        if (sex !== null) params.append("sex", sex);
        if (isRealName !== null) params.append("isRealName", isRealName.toString());
        params.append("page", page.toString());
        params.append("row", row.toString());
        return (await Axios.post<PageInfo<User>>("/user/query", params)).data;
    }

    /**
     * 修改员工
     * @param user
     */
    static async update(user: User) {
        let params = Utils.format(new URLSearchParams(),user,"id","username","uname","headPortrait","phone","signature","sex","idCard");
        params.append("empId",EmpHelper.empId);
        return (await Axios.post<Message>("/user/update", params)).data;
    }

    /**
     * 删除员工
     * @param userId
     */
    static async delete(userId: number) {
        let params = new URLSearchParams();
        params.append("userId",userId.toString());
        params.append("empId",EmpHelper.empId);
        return (await Axios.post<Message>("/user/delete", params)).data;
    }

}