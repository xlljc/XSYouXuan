<template>
    <div>
        <el-menu unique-opened class="el-menu-vertical-demo" router
                 :collapse="isCollapse" background-color="#DDCDCD" text-color="#89768F" active-text-color="#39313B">
            <!--伸缩框-->
            <el-menu-item-group style="text-align: center">
                <i style="font-size: 45px;color: #8A8D94" @click="kaiguan"
                   :class="isCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold'"></i>
            </el-menu-item-group>

                <!--判断该变量是否包含子级 生成下拉符号-->            <!--控制台报index错误是因为这个index BUG 还没解决-->
            <el-submenu v-for="menu in $store.getters['back/menus']" :key="menu.id" :index="menu.id.toString()"><!--不给index会将页面全部撑开-->
                <template slot="title">
                    <i :class="menu.icon"></i>
                    <span slot="title">{{menu.name}}</span>
                </template>

                <el-menu-item-group v-if="getChild(menu.menus)">
                    <el-menu-item style="background:#CFB8B8;" v-for="(item,index) in getChild(menu.menus)" :key="index" :index="'/back'+item.url">
                        {{ item.name }}
                    </el-menu-item>

                </el-menu-item-group>
            </el-submenu>
        </el-menu>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import {Menu as MenuInfo} from "@/helper/entity";


    @Component
    export default class Menu extends Vue {


        created() {

        }

        //判断开关的变量
        isCollapse = false;

        //点击按钮打开关闭方法
        kaiguan() {
            if (this.isCollapse === true) {
                this.isCollapse = false;
            } else {
                this.isCollapse = true;
            }
        }

        getChild(menus: MenuInfo[]) {
            if (menus === null) return [];
            return menus;
        }

    }
</script>

<style scoped>
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 200px;
        min-height: 400px;
    }

    body {
        background: #ddcdcd;
    }
</style>