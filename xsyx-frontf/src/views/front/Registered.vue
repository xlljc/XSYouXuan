<template>
    <div>
        <el-container>
            <el-header style="position: fixed;width: 100%;z-index: 10;margin-top: -9px;">
                <el-menu :default-active="'1'"
                     mode="horizontal">
                <el-menu-item>
                    <el-image style="width: 60px; height: 60px" :src="require('@/mcimg/logos.png')"></el-image>
                </el-menu-item>
                <el-menu-item><i class="el-icon-house"/>首页</el-menu-item>
                <el-menu-item class="right">
                    <el-image style="width: 55px; height: 50px" :src="require('@/mcimg/hua.png')"></el-image>
                </el-menu-item>
                <el-menu-item class="right" index="8">关于我们</el-menu-item>
                <el-menu-item class="right" index="7">联系客服</el-menu-item>
                <el-menu-item class="right" index="6">注册</el-menu-item>
                <el-menu-item class="right" index="5">登录</el-menu-item>



                <el-menu-item index="3"><i class="el-icon-scissors"></i>每日特价</el-menu-item>
            </el-menu>
            </el-header>


            <el-main>

                <el-col :span="24">
                    <el-image style="width: 1855px; height: 800px" :src="require('@/mcimg/zc.png')"></el-image>
                </el-col>



                <el-steps :active="active" finish-status="success" >
                    <div class="login">



                        <div style="margin-top: 70px; margin-left: 80px">
                            <el-step title="验证"></el-step>
                            <el-step title="用户信息"></el-step>
                            <el-step title="注册成功"></el-step>
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class="login-center clearfix">
                            <div class="login-center-img"><el-image style="width: 27px; height: 27px" :src="require('@/mcimg/dh.png')"></el-image></div>
                            <div class="login-center-input">
                                <input type="phone" placeholder="请输入您的电话号码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的手机号码'"/>
                                <div class="login-center-input-text">电话号码</div>
                            </div>
                        </div>
                        <div class="login-center clearfix">
                            <div class="login-center-img"><el-image style="width: 27px; height: 27px" :src="require('@/mcimg/yzm2.png')"></el-image></div>
                            <div class="login-center-input">
                                <input type="yzm" placeholder="请输入验证码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入验证码'" style="width: 140px"/>
                                <el-button type="primary" size="small" plain class="fs">点击发送</el-button>
                                <div class="login-center-input-text">验证码</div>
                            </div>
                        </div>


                        <br>
                        <div class="login-button"  @click="next">
                            确认注册
                        </div>


                    </div>

                </el-steps>

            </el-main>

        </el-container>


    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Registered extends Vue {
        active= 0

        next() {
            if (this.active++ > 2) this.active = 0;
        }
    }
</script>

<style scoped>
    .right {
        float: right !important;

    }

    .fs{
        position: absolute;
        left: 64%;
    }

    .login {
        position: absolute;
        top: 400px;
        left: 74%;
        opacity: 0.8;
    }
</style>