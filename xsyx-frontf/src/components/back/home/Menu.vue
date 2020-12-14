<template>
    <div>
        <!--<el-menu  default-active="1-4-0" class="el-menu-vertical-demo"
                  :collapse="isCollapse" background-color="#DDCDCD" text-color="#89768F" active-text-color="#39313B">
            &lt;!&ndash;外层菜单  包含伸缩框 ↑&ndash;&gt;
            &lt;!&ndash;伸缩框&ndash;&gt;
            <el-menu-item-group style="text-align: center">
                <i style="font-size: 45px;color: #8A8D94" @click="kaiguan"
                   :class="isCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold'"></i>
            </el-menu-item-group>
            &lt;!&ndash;里层菜单 生成侧边栏菜单数据&ndash;&gt;
            <el-submenu>
                <template slot="title">
                    <i class="el-icon-location"></i>
                    <span slot="title" style="font-size: 20px">后台管理系统</span>
                </template>
                <el-menu-item-group v-for="menu in menus" :key="menu.index">
                    &lt;!&ndash;判断该变量是否包含子级 生成下拉符号&ndash;&gt;
                    <el-submenu :index="menu.index" v-if="menu.children">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span slot="title">{{menu.name}}</span>
                        </template>

                        <el-menu-item-group>
                            <el-menu-item style="background:#CFB8B8;">
                                &lt;!&ndash;/////子级的值无法获取  BUG/////&ndash;&gt;   &lt;!&ndash;router 属性&ndash;&gt;
                                <router-link to="/back/commodity" style="color:#89768F">111</router-link>
                            </el-menu-item>
                        </el-menu-item-group>

                    </el-submenu>
                    &lt;!&ndash; 否则生成不含下拉符号的菜单&ndash;&gt;
                    <el-menu-item v-else :index="menu.index">
                        <i class="el-icon-location"></i>
                        <span slot="title">{{menu.name}}</span>
                    </el-menu-item>
                </el-menu-item-group>
            </el-submenu>
        </el-menu>-->

        <el-menu default-active="1-4-0" class="el-menu-vertical-demo"
                 :collapse="isCollapse" background-color="#DDCDCD" text-color="#89768F" active-text-color="#39313B">
            <!--伸缩框-->
            <el-menu-item-group style="text-align: center">
                <i style="font-size: 45px;color: #8A8D94" @click="kaiguan"
                   :class="isCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold'"></i>
            </el-menu-item-group>

            <!--判断该变量是否包含子级 生成下拉符号-->
            <el-submenu v-for="menu in menus" :key="menu.index" :index="menu.index"><!--v-if="menu.children"-->
                <template slot="title">
                    <i class="el-icon-location"></i>
                    <span slot="title">{{menu.name}}</span>
                </template>

                <el-menu-item-group v-if="getChild(menu.children)">
                    <el-menu-item style="background:#CFB8B8;" v-for="(item,index) in getChild(menu.children)"
                                  :key="index">
                        <!--/////子级的值无法获取  BUG/////-->   <!--router 属性-->
                        <router-link to="/back/commodity" style="color:#89768F">{{ item.name }}</router-link>
                    </el-menu-item>
                </el-menu-item-group>
            </el-submenu>

        </el-menu>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import {menu, MenuHelper} from "@/helper/back/MenuHelper";
    import da from "element-ui/src/locale/lang/da";

    let menuHelper = new MenuHelper();

    @Component
    export default class Menu extends Vue {

        menus: menu[] = []

        created() {
            menuHelper.getMenuData().then(data => {
                this.menus = data;
            })
        }

        //判断开关的变量
        isCollapse = false;

        //左侧栏打开关闭的方法
        handleOpen(key: any, keyPath: any) {
            console.log(key, keyPath);
        }

        handleClose(key: any, keyPath: any) {
            console.log(key, keyPath);
        }

        //点击按钮打开关闭方法
        kaiguan() {
            if (this.isCollapse === true) {

                //alert('开')
                this.isCollapse = false;
            } else {
                //alert('关')
                this.isCollapse = true;
            }
        }

        getChild(menus: menu[]) {
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
        background: #DDCDCD;
    }
</style>