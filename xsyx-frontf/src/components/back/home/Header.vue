<template>
<div>
    <!--<h1 style="color: pink;">兴盛优选</h1>
    <div id="yonhu">
        <a href="#" id="mz">xxx, 欢迎您 </a>
        <label></label>
        <a href="#" id="esc"> 退出</a>
    </div>
    <label id="timer" style="color: orange;">11</label>-->
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">


        <el-menu-item>伸缩侧栏按钮</el-menu-item>
        <el-menu-item>首页</el-menu-item>

        <el-menu-item style="float:right">
            <el-submenu>
            <template slot="title"><i class="el-icon-user-solid"></i></template>
            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>
            <el-menu-item index="2-3">选项3</el-menu-item>
            </el-submenu>
        </el-menu-item>

        <el-menu-item style="float:right"><i class="el-icon-s-comment"></i></el-menu-item>
        <el-menu-item style="float:right"><i class="el-icon-message-solid"></i></el-menu-item>

       <!-- <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>-->
    </el-menu>
</div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Header extends Vue {

        created() {
            setInterval(()=>{
                this.time()
            }, 1000);
        }

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


    }
</script>

<style scoped>
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
        margin-top: 80px;
        margin-left: 200px;
    }
</style>