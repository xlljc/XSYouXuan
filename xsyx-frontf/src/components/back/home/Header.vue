<template>
<div>
    <h1 style="color: pink;">兴盛优选</h1>
    <div id="yonhu">
        <a href="#" id="mz">xxx, 欢迎您 </a>
        <label></label>
        <a href="#" id="esc"> 退出</a>
    </div>
    <label id="timer" style="color: orange;"></label>
</div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Header extends Vue {

        time() {
            let date = new Date();

            let year = date.getFullYear();
            //月份加1  0-11月
            let month = date.getMonth() + 1;
            //日
            let day = date.getDate();
            // 小时
            let hour = date.getHours();
            //分钟
            let minute = date.getMinutes();
            //秒
            let second = date.getSeconds();
            let str = year + "年" + month + "月" + day + "日" + hour + "时" + minute
                + "分" + second + "秒";
            document.getElementById("timer").innerHTML = str;

        }
        /*setInterval("time()", 1000);*/

    }
</script>

<style scoped>
    body{
        margin: 0;
    }
    h1 {
        text-align: center;
        position: absolute;
        margin: 10px 0px 0px 600px;
        font-size: 50px;
    }

    #mz , #esc{
        /* 去除下划线 */
        text-decoration:none;
    }
    #yonhu{
        position: absolute;
        margin-top: 80px;
    }
    #timer {
        position: absolute;
        margin-left: 1310px;
        margin-top: 80px;

    }
</style>