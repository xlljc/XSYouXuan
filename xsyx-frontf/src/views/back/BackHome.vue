<template>
    <!--<div>
        后台首页
        <hello></hello>
        <commodity></commodity>
    </div>-->
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

                    <router-view></router-view>

                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Hello from "@/views/back/Hello.vue";
    import Commodity from "@/components/back/home/Commodity.vue";
    import Menu from "@/components/back/home/Menu.vue";
    import Header from "@/components/back/home/Header.vue";
    import CommodityTypeMaintain from "@/components/back/home/CommodityTypeMaintain.vue";
    import Warehousemaintain from "@/components/back/home/Warehousemaintain.vue";

    @Component({
        components: {
            backMenu:Menu,
            backHeader:Header,
            Commodity,
            CommodityTypeMaintain,
            Warehousemaintain,
        }
    })
    export default class BackHome extends Vue {


        created() {

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