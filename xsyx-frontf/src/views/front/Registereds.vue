<template>
    <div>
        <el-container>
            <router-view>
            <div id="yhxx">
            <el-main>
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
                            <div class="login-center-img"><el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/dh.png')"></el-image></div>
                            <div class="login-center-input">
                                <input type="phone" placeholder="请输入您的电话号码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的手机号码'"/>
                                <div class="login-center-input-text">电话号码</div>
                            </div>
                        </div>
                        <div class="login-center clearfix">
                            <div class="login-center-img"><el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/dh.png')"></el-image></div>
                            <div class="login-center-input">
                                <input type="username" placeholder="请输入账号" onfocus="this.placeholder=''" onblur="this.placeholder='请输入账号'"/>
                                <div class="login-center-input-text">账号</div>
                            </div>
                        </div>
                        <div class="login-center clearfix">
                            <div class="login-center-img"><el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/dh.png')"></el-image></div>
                            <div class="login-center-input">
                                <input type="password" placeholder="请输入密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入密码'"/>
                                <div class="login-center-input-text">密码</div>
                            </div>
                        </div>
                        <div class="login-center clearfix">
                            <div class="login-center-img"><el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/dh.png')"></el-image></div>
                            <div class="login-center-input">
                                <input type="uname" placeholder="请输入你的姓名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入你的姓名'"/>
                                <div class="login-center-input-text">姓名</div>
                            </div>
                        </div>
                        <div class="login-center clearfix">
                            <div class="login-center-img"><el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/dh.png')"></el-image></div>
                            <div class="login-center-input">
                                <input type="sex" placeholder="请输入你的性别" onfocus="this.placeholder=''" onblur="this.placeholder='请输入你的性别'"/>
                                <div class="login-center-input-text">性别</div>
                            </div>
                        </div>
                        <br>
                        <div class="login-button"  @click="next">
                            确认注册
                        </div>
                    </div>
                </el-steps>
            </el-main>
            </div>
            </router-view>
        </el-container>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Registered2 extends Vue {

    }
</script>

<style scoped>

</style>