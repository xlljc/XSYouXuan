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
    }
}