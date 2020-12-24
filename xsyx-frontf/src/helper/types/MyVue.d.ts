import {AxiosStatic} from "axios";

export module 'vue/types/vue' {
    interface Vue {
        /**
         * 远程访问地址
         */
        readonly $host: string;
        /**
         * 内置axios对象
         */
        readonly $axios: AxiosStatic;
        /**
         * 返回当前操作者是否有使用按钮的权限
         */
        readonly $btnPermissions: (butName: string) => boolean;
    }
}