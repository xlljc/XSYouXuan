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

}