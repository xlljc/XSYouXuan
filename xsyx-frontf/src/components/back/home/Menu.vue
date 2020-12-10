<template>
<div>

    <el-menu default-active="1-4-0" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
             :collapse="isCollapse" background-color="#DDCDCD" text-color="#89768F" active-text-color="#39313B">


        <el-menu-item-group style="text-align: center">
            <i style="font-size: 45px;color: #8A8D94" @click="kaiguan" :class="isCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold'"></i>
        </el-menu-item-group>
        <el-submenu index="1">

            <template slot="title">
                <i class="el-icon-location"></i>
                <span slot="title">后台管理</span>
            </template>

            <el-menu-item-group>
               <!-- <span slot="title">分组一</span>-->
                <el-menu-item index="1-1" style="background:#CFB8B8;">
                    <router-link to="/back/commodity" style="color:#39313B">商品资料管理</router-link>
                </el-menu-item>
            </el-menu-item-group>
            <el-menu-item index="1-4-1">选项1</el-menu-item>
           <!-- <el-menu-item-group title="分组2">
                <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>-->
           <!-- <el-submenu index="1-4">
                <span slot="title">选项4</span>
                <el-menu-item index="1-4-1">选项1</el-menu-item>
            </el-submenu>-->
        </el-submenu>
        <!--<el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
        </el-menu-item>
        <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
        </el-menu-item>
        <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
        </el-menu-item>-->
    </el-menu>

</div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Menu extends Vue {
        //判断开关的变量
        isCollapse = false;
        //左侧栏打开关闭的方法
        handleOpen(key:any, keyPath: any) {
            console.log(key, keyPath);
        }
        handleClose(key: any, keyPath: any) {
            console.log(key, keyPath);
        }
        //点击按钮打开关闭方法
        kaiguan(){
            if (this.isCollapse===true){
                //alert('开')
                this.isCollapse=false;
            }else {
                //alert('关')
                this.isCollapse=true;
            }
        }

    }
</script>

<style scoped>
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 200px;
        min-height: 400px;
    }
    body{
        background:#DDCDCD;
    }
</style>