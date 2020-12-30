import {User} from "@/helper/entity";
import Axios from "axios";

export class UserHelper {

    /**
     * 获取用户id
     */
    public static get userId(): string | null {
        console.log("获取UID = " + sessionStorage.getItem("uid"));

        return sessionStorage.getItem("uid");

    }

    /**
     * 设置用户id
     * @param uid
     */
    public static set userId(uid: string) {
        console.log("设置UID = " + uid);
        sessionStorage.setItem("uid",uid);


    }

    /**
     * 获取商户id
     */
    public static get merId(): string {
        return sessionStorage.getItem("merId");
    }

    public static set merId(val: string) {
        sessionStorage.setItem("merId",val);
    }

    public static async getUser(id?: number): Promise<User> {
        return (await Axios.get("/user/get/" + (id ?? UserHelper.userId))).data;
    }
}