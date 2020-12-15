<template>
    <div>

        <el-menu style="background: #F3F3F3" mode="horizontal">
            <el-menu-item>
                <el-avatar :src="logo"></el-avatar>
            </el-menu-item>
            <el-menu-item>首页</el-menu-item>
            <!--头像-->
            <el-menu-item style="float:right;background: #F3F3F3">
                <el-popover placement="bottom" width="150" trigger="click">
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

       <!-- 生成面包屑-->
        <div>
            <el-breadcrumb separator-class="el-icon-arrow-right" >
                <el-breadcrumb-item v-for="(item,index) in urls" :key="index">
                    <a href="/back">{{ item }}</a>
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
    </div>

</template>

<script lang="ts">
    import {Vue, Component, Watch} from "vue-property-decorator";
    import {menu,MenuHelper} from "@/helper/back/MenuHelper";


    let menuHelper = new MenuHelper();

    @Component
    export default class Header extends Vue {
        //logo
        logo = require('@/mcimg/logos.png');
        //头像
        url = require('@/assets/touxiang.jpg');

        menus:menu[] = []

        created() {
            menuHelper.getMenuData().then(data => {
                this.menus = data;
            })

        }

        get urls(): string[] {
            //截取地址的映射
            let url = this.$store.getters['back/url'];
            //获取截取的地址映射
            let arr=url.substr(url.indexOf("back")).split("/");

            //定义 接收中文面包屑的数组
            let zhonarr:string[]=[];

            //循环父级菜单
            for (let i = 0; i < this.menus.length; i++) {
                let zi=this.menus[i].menus
                //循环子级菜单   子菜单没有parent  给子菜单的parent赋值
                for(let j = 0; j <zi.length ; j++){
                    zi[j].parent=this.menus[i].id;
                }
            }
            for (let i = 0; i < this.menus.length; i++) {
                let zi=this.menus[i].menus
                //循环子级菜单   子菜单没有parent  给子菜单的parent赋值
                for(let j = 0; j <zi.length ; j++){
                    //判断 面包屑的url 是否与子菜单的url匹配 返回中文
                    if (zi[j].url === arr[1]){
                        zhonarr[0]="首页"
                        zhonarr[1]=this.menus[i].name
                        zhonarr[2]=zi[j].name
                       /* console.log(this.menus[i].name)
                        console.log(zi[j].name)*/
                    }
                }
            }

            return zhonarr
        }


        getChild(menus: menu[]) {
            if (menus === null) return [];
            return menus;
        }



    }
</script>

<style scoped>


</style>