<template>
    <div>
        <el-container>
            <!--菜单头部-->
            <el-header class="menu-head">
                <el-avatar class="menu-icon"
                          :src="require('@/assets/mcimg/logos.png')"
                          fit="cover"></el-avatar>
                <div class="menu-title">商户平台</div>
                <div class="menu-item" style="width: 80px">首页</div>

                <!--头像-->
                <div class="menu-item" style="float: right">
                    <el-popover placement="bottom" width="50" trigger="click">
                        <div>
                            <div style="font-weight: bold;text-align: center;height: 35px;line-height: 35px">Hi ! </div>
                            <div class="head-btn">
                                <i class="el-icon-switch-button"></i>登出
                            </div>
                        </div>
                        <el-button style="height: 60px;background-color: #ffffff00;border: 0" slot="reference">
                            <el-avatar size="large" :src="require('@/assets/bc.jpg')"></el-avatar>
                        </el-button>
                    </el-popover>
                </div>
                <!--通知-->
                <div class="menu-item" style="float:right;padding-left: 25px;padding-right: 25px">
                    <i class="el-icon-message-solid">
                        <el-badge :value="1" class="item" :max="100" style="margin-top: -20px"></el-badge>
                    </i>
                </div>

            </el-header>
            <el-container>

                <!--菜单-->
                <el-aside width="200px">

                    <el-menu router>
                        <el-menu-item index="/shop/shouhuo">
                            <i class="el-icon-suitcase"></i>
                            <span slot="title">收货</span>
                        </el-menu-item>
                        <el-menu-item index="/shop/tihuo">
                            <i class="el-icon-shopping-bag-2"></i>
                            <span slot="title">提货</span>
                        </el-menu-item>
                        <el-menu-item index="/shop/search">
                            <i class="el-icon-search"></i>
                            <span slot="title">订单查询</span>
                        </el-menu-item>
                        <el-menu-item index="/shop/statistics">
                            <i class="el-icon-s-data"></i>
                            <span slot="title">营收统计</span>
                        </el-menu-item>
                    </el-menu>

                </el-aside>

                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Demo1 extends Vue {

        created() {
            
        }

        mounted() {

        }
    }
</script>

<style scoped>
    .menu-head {
        width: calc(100% + 18px);
        margin-left: -9px;
        height: 60px;
        background-color: #8BD25A;
        margin-top: -9px;
    }
    .menu-icon {
        background-color: #f3f3f3;
        margin-top: 3px;
        width: 54px;
        height: 54px;
        float: left;
    }
    .menu-title {
        font-size: 18px;
        font-weight: bold;
        text-align: center;
        height: 60px;
        line-height: 60px;
        user-select: none;
        color: white;
        float: left;
        padding-right: 15px;
        padding-left: 15px;
    }
    .menu-item {
        transition: all linear 0.2s;
        text-align: center;
        height: 60px;
        color: white;
        background-color: #8BD25A;
        padding-right: 5px;
        padding-left: 5px;
        line-height: 60px;
        user-select: none;
        cursor: pointer;
        font-size: 16px;
        float: left;
    }
    .menu-item:hover {
        background-color: #90e056;
    }
    .head-btn {
        text-align: center;
        font-weight: bold;
        font-size: 16px;
        cursor: pointer;
        line-height: 35px;
        height: 35px;
    }
    .head-btn:hover {
        background-color: #e5e5e5;
    }
</style>