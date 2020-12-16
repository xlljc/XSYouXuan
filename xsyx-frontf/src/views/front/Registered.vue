<template>
    <div>
        <el-container>
            <el-header style="position: fixed;width: 100%;z-index: 10;margin-top: -9px;">
                <el-menu :default-active="'1'"
                     mode="horizontal">
                <el-menu-item>
                    <el-image style="width: 60px; height: 60px" :src="require('@/assets/mcimg/logos.png')"></el-image>
                </el-menu-item>
                <el-menu-item><i class="el-icon-house"/>首页</el-menu-item>
                <el-menu-item class="right">
                    <el-image style="width: 55px; height: 50px" :src="require('@/assets/mcimg/hua.png')"></el-image>
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
                    <el-image style="width: 1855px; height: 800px" :src="require('@/assets/mcimg/zc.png')"></el-image>
                </el-col>
                <el-steps :active="active" finish-status="success" >
                    <div class="login">
                        <div style="margin-top: 70px; margin-left: 50px">
                            <el-steps :active="active" finish-status="success">
                                <el-step  title="验证"></el-step>
                                <el-step  title="用户信息"></el-step>
                                <el-step title="注册成功"></el-step>
                            </el-steps>
                        </div>
                        <br>
                        <br>
                        <br>

                        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" >
                            <div class="login-center clearfix" v-show="index===0">
                                <div class="login-center-img">
                                    <el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/dh.png')"></el-image>
                                </div>
                                    <el-form-item class="login-center-input" prop="phone">
                                        <el-input type="text" placeholder="请输入您的电话号码" onfocus="this.placeholder=''"
                                                  autocomplete="off" v-model="ruleForm.phone" onblur="this.placeholder='请输入您的手机号码'"/>
                                    </el-form-item>
                            </div>

                            <div class="login-center clearfix" v-show="index===1">
                                <div class="login-center-img">
                                    <el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/dh.png')"></el-image>
                                </div>
                                <el-form-item class="login-center-input" prop="username">
                                    <el-input type="text" placeholder="请输入您的用户名" onfocus="this.placeholder=''"
                                              autocomplete="off" v-model="ruleForm.username" onblur="this.placeholder='请输入您的用户名'"/>
                                </el-form-item>
                            </div>
                            <div class="login-center clearfix" v-show="index===1">
                                <div class="login-center-img">
                                    <el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/dh.png')"></el-image>
                                </div>
                                <el-form-item class="login-center-input" prop="password">
                                    <el-input type="password" placeholder="请输入您的密码" onfocus="this.placeholder=''"
                                              autocomplete="off" v-model="ruleForm.password" onblur="this.placeholder='请输入您的密码'"/>
                                </el-form-item>

                            </div>

                            <div class="login-center clearfix" v-show="index===1">
                                <div class="login-center-img">
                                    <el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/dh.png')"></el-image>
                                </div>
                                <el-form-item class="login-center-input" prop="checkPass">
                                    <el-input type="password" placeholder="请确认您的密码" onfocus="this.placeholder=''"
                                              autocomplete="off" v-model="ruleForm.checkPass" onblur="this.placeholder='请输入您的密码'"/>
                                </el-form-item>
                            </div>

                            <div class="login-center clearfix" v-show="index===1">
                                <div class="login-center-img">
                                    <el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/dh.png')"></el-image>
                                </div>
                                <el-form-item class="login-center-input" prop="uname">
                                    <el-input type="text" placeholder="请输入您的姓名" onfocus="this.placeholder=''"
                                              autocomplete="off" v-model="ruleForm.uname" onblur="this.placeholder='请输入您的姓名号码'"/>
                                </el-form-item>
                            </div>
                            <div class="login-center clearfix" v-show="index===1">
                                <div class="login-center-img">
                                    <el-image style="width: 34px; height: 34px;margin-top: -5px" :src="require('@/assets/mcimg/sex.png')"></el-image>
                                </div>
                                <el-form-item prop="sex" v-show="index===1" style="margin-left: 45px" size="medium">
                                    <el-radio-group v-model="ruleForm.sex">
                                        <el-radio label="男"></el-radio>
                                        <el-radio label="女"></el-radio>
                                    </el-radio-group>
                                </el-form-item>
                            </div>

                        <div class="login-center clearfix" v-show="index===0">
                            <div class="login-center-img">
                                <el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/yzm2.png')"></el-image>
                            </div>
                            <div class="login-center-input">
                                <input type="text" placeholder="请输入验证码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入验证码'" style="width: 140px"/>
                                <el-button type="primary" size="small" plain class="fs">点击发送</el-button>
                                <div class="login-center-input-text">验证码</div>
                            </div>
                        </div>

                        <div v-show="index===2">
                            <el-image style="width:80px; height: 80px;margin-left: 130px" :src="require('@/assets/mcimg/accomplish.png')"></el-image>
                        </div>

                        <div class="login-button"  @click="next" >
                            确认注册
                        </div>
                        </el-form>
                    </div>
                </el-steps>
            </el-main>
        </el-container>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";

    @Component
    export default class Registered extends Vue {
        index=0;
        vanish=true;
        appear:boolean=false;
        accomplish=false;
        active= 0
        next() {
            this.index ++;
            if (this.active++ > 2) this.active = 0;
            this.vanish=false;
            this.appear=true;

            if (this.appear === true) this.appear=false
            this.accomplish=true;

            let data = new URLSearchParams();
            data.append("phone",this.ruleForm.phone);
            data.append("username",this.ruleForm.username);
            data.append("password",this.ruleForm.password);
            data.append("uname",this.ruleForm.uname);
            data.append("sex",this.ruleForm.sex);

            if (this.index===2){

                Axios({
                    method:"post",
                    url:'/user/register',
                    data: data
                }).then((result) => {
                    if (result.data.flag === false) alert(result.data.msg);
                })
            }

        }

        validatephone:any = (rule:any, value:any, callback:any) => {
            if (value === '') {
                callback(new Error('请输入您的手机号码'));
            }
            let $ref = this.$refs["ruleForm"];
        };
        validateuname:any = (rule:any, value:any, callback:any) => {
            if (value === '') {
                callback(new Error('请输入您的姓名'));
            }
            let $ref = this.$refs["ruleForm"];
        };
        validatesex:any = (rule:any, value:any, callback:any) => {
            if (value === '') {
                callback(new Error('请选择您的性别'));
            }
            let $ref = this.$refs["ruleForm"];
        };

        validateusername:any = (rule:any, value:any, callback:any) => {
            if (value === '') {
                callback(new Error('情输入您的用户名'));
            }
            let $ref = this.$refs["ruleForm"];
        };
        validatePass = (rule:any, value:any, callback:any) => {
            if (value === '') {
                callback(new Error('请输入密码'));
            } else {
                if (this.ruleForm.checkPass !== '') {
                    //@ts-ignore
                    this.$refs.ruleForm.validateField('checkPass');
                }
                callback();
            }
        };

        validatePass2 = (rule:any, value:any, callback:any) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.ruleForm.password) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
        ruleForm = {
            phone:'',
            uname:'',
            sex:'',
            username:'',
            password:'',
            checkPass:''
        }
        rules= {
            phone: [
                { validator: this.validatephone, trigger: 'blur' }
            ],
            uname: [
                { validator: this.validateuname, trigger: 'blur' }
            ],

            sex: [
                { validator: this.validatesex, trigger: 'change' }
            ],
            username: [
                { validator: this.validateusername, trigger: 'blur' }
            ]
            ,
            password: [
                { validator: this.validatePass , trigger: 'blur' }
            ],
            checkPass: [
                { validator: this.validatePass2, trigger: 'blur' }
            ]
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
        top: 330px;
        left: 74%;
        opacity: 0.8;
        height: 750px;
    }
</style>