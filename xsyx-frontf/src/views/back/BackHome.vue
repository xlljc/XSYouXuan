<template>
    <div id="app" class="homeWrap">
        <el-container style="height:100%" direction="vertical">

            <el-container>
                <el-aside width="" style="background: #DDCDCD">
                    <!-- 菜单组件中使用路由配置方式
                    在el-main中通过router-view展示子组件
                    -->
                    <back-menu></back-menu>

                </el-aside>
                <el-main >
                    <el-header height="" style="padding: 0px">
                        <back-header style="margin-top: -20px"></back-header>
                    </el-header>
                    <!--子级路由-->
                    <router-view></router-view>

                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Menu from "@/components/back/home/Menu.vue";
    import Header from "@/components/back/home/Header.vue";
    import {MenuHelper} from "@/helper/back/MenuHelper";

    @Component({
        components: {
            backMenu:Menu,
            backHeader:Header,
        }
    })
    export default class BackHome extends Vue {


        created() {
            //加载菜单
            MenuHelper.getMenuData();
        }

        mounted() {

        }
    }
</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #F3F3F3;
        color: #333;

    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;

    }

    .el-main {
        background-color: white;
        color: #333;

    }

    .homeWrap {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
    }
</style>