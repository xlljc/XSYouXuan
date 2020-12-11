<template>
    <div>

        <el-menu style="background: #F3F3F3" mode="horizontal">
            <el-menu-item>
                <el-avatar :src="logo"></el-avatar>
            </el-menu-item>
            <el-menu-item>首页</el-menu-item>

            <!--<el-menu-item style="float:right">
                <el-submenu>
                <template slot="title"><i class="el-icon-user-solid"></i></template>
                <el-menu-item index="2-1">选项1</el-menu-item>
                <el-menu-item index="2-2">选项2</el-menu-item>
                <el-menu-item index="2-3">选项3</el-menu-item>
                </el-submenu>
            </el-menu-item>-->
            <!--头像-->
            <el-menu-item style="float:right;background: #F3F3F3">
                <el-popover
                        placement="bottom"
                        width="150"
                        trigger="click">
                    <div style="margin-left: 10px">
                        <p style="text-align: center;font-weight: bold">Hi,xxx</p>

                        <el-menu-item><i style="font-size: 15px" class="el-icon-user">个人资料</i></el-menu-item>
                        <el-menu-item><i style="font-size: 15px" class="el-icon-lock">锁屏</i></el-menu-item>
                        <el-menu-item><i style="font-size: 15px" class="el-icon-delete">退出</i></el-menu-item>

                    </div>
                    <el-button style="border: 0px;margin-top: -15px;background: #F3F3F3" slot="reference">
                        <el-avatar :src="url"></el-avatar>
                    </el-button>
                </el-popover>
            </el-menu-item>
            <!--聊天框-->
            <el-menu-item style="float:right">
                <i class="el-icon-s-comment">
                    <el-badge :value="5" class="item" :max="100" style="margin-top: -20px"></el-badge>
                </i>
            </el-menu-item>
            <!--通知-->
            <el-menu-item style="float:right">
                <i class="el-icon-message-solid">
                    <el-badge :value="1" class="item" :max="100" style="margin-top: -20px"></el-badge>
                </i>
            </el-menu-item>

        </el-menu>
        <div>
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
                <el-breadcrumb-item>活动列表</el-breadcrumb-item>
                <el-breadcrumb-item>活动详情</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
    </div>

</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Header extends Vue {
        //logo
        logo = require('@/mcimg/logos.png');
        //头像
        url = require('@/assets/touxiang.jpg');

        /*created() {
            setInterval(() => {
                this.time()
            }, 1000);
        }*/


    }
</script>

<style scoped>
    h1 {
        text-align: center;
        position: absolute;
        margin: 10px 0px 0px 600px;
        font-size: 50px;
    }

    #mz, #esc {
        /* 去除下划线 */
        text-decoration: none;
    }

    #yonhu {
        position: absolute;
        margin-top: 80px;
    }

    #timer {
        position: absolute;
        margin-top: 80px;
        margin-left: 200px;
    }
</style>