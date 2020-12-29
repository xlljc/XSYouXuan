<template>
    <div>
        <el-container>

            <!--<el-header style="position: fixed;width: 100%;z-index: 10;margin-top: -9px;">
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
            </el-header>-->
            <front-header></front-header>
            <div style="width: 1900px; height: 800px">
                <el-main>
                    <el-col :span="24">
                        <el-image style="width: 1855px; height: 800px;margin-left:12px" :src="require('@/assets/mcimg/loginsss.png')"></el-image>
                    </el-col>
                    <el-col :span="4">
                        <div class="login">
                            <div class="login-top">
                                用户登录
                            </div>
                            <div style="margin-top: -20px">
                                <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm">
                                    <div class="login-center clearfix">
                                        <div class="login-center-img">
                                            <el-image style="width:30px; height: 27px" :src="require('@/assets/mcimg/name.png')"></el-image>
                                        </div>
                                        <el-form-item class="login-center-input" prop="username">
                                            <el-input type="type" placeholder="请输入您的用户名" v-model="ruleForm.username" onfocus="this.placeholder=''"
                                                      autocomplete="off" onblur="this.placeholder='请输入您的用户名'"/>
                                        </el-form-item>
                                    </div>
                                    <div class="login-center clearfix">
                                        <div class="login-center-img">
                                            <el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/password.png')"></el-image>
                                        </div>
                                        <el-form-item class="login-center-input" prop="password">
                                            <el-input type="password" placeholder="请输入您的密码" onfocus="this.placeholder=''"
                                                      v-model="ruleForm.password" autocomplete="off" onblur="this.placeholder='请输入您的密码'"/>
                                            <div class="login-center-input-text">密码</div>
                                        </el-form-item>
                                    </div>

                                    <div class="login-center clearfix">
                                        <div class="login-center-img">
                                            <el-image style="width: 27px; height: 27px" :src="require('@/assets/mcimg/yzm1.png')"></el-image></div>
                                        <div class="login-center-input">
                                            <input type="text" placeholder="请输入验证码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入验证码'"/>
                                            <div class="login-center-input-text">验证码</div>
                                            <br>
                                            <br>
                                            <canvas id="canvas" @click="showNum"></canvas>
                                        </div>

                                    </div>
                                    <br>
                                    <el-button style="margin-left: 140px ;margin-top: 20px" type="primary" @click="denglu">提交</el-button>
                                </el-form>
                            </div>
                        </div>
                        <div class="sk-rotating-plane"></div>
                    </el-col>
                </el-main>

                <el-footer>

                    <h2>合作商</h2>


                </el-footer>
            </div>
        </el-container>
    </div>
</template>

<script lang="ts">
    import {Vue, Component, Watch} from "vue-property-decorator";
    import Axios from "axios";
    import {Message, User} from "@/helper/entity";
    import FrontHeader from "@/components/front/home/FrontHeader.vue";
    import {UserHelper} from "@/helper/front/UserHelper";


    @Component({
        components: {
            FrontHeader
        }
    })
    export default class Login extends Vue {
        /*num: [];
        number: "";*/

        validateusername:any = (rule:any, value:any, callback:any) => {
            if (value === '') {
                callback(new Error('请输入您的账号'));
            }
            let $ref = this.$refs["ruleForm"];
        };

        validatePass:any = (rule:any, value:any, callback:any) => {
            if (value === '') {
                callback(new Error('请输入您的密码'));
            }
            let $ref = this.$refs["ruleForm"];
        };
        ruleForm = {
            username:'',
            password: '',
        }
        rules= {
            password: [
                { validator: this.validatePass, trigger: 'blur' }
            ],
            username:[
                { validator: this.validateusername, trigger: 'blur' }
            ]
        }



        num:string[] = [];
        number = "";

        denglu(){

            let data = new URLSearchParams();

            data.append("name",this.ruleForm.username);
            data.append("password",this.ruleForm.password)
            Axios({
                method:"post",
                url:"/user/login",
                data:data
            }).then((result) => {

                //sessionStorage.setItem("id",result.data.msg.id)、
                let message: Message = result.data;
                if (message.flag) {
                    UserHelper.userId = message.msg.id;
                    this.$router.replace("/");
                } else {
                    this.$message.error(message.msg)
                }


            })
        }


        showNum() {

            this.draw(this.num);
            this.number = this.num.join().replace(/,/g, "");
        }

        draw(num: string[]) {
            let canvasWidth=140;
            let canvasHeight=36;
            let canvas = document.getElementById("canvas") as HTMLCanvasElement;
            let context= canvas.getContext("2d") as CanvasRenderingContext2D;

            canvas.width=canvasWidth;
            canvas.height=canvasHeight;
            context.fillStyle="#ccccc";
            context.fillRect(0, 0, 300, 200);
            let sCode =
                "A,B,C,D,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,U,V,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
            let aCode = sCode.split(",");
            let aLength = aCode.length; //获取到数组的长度

            for (let i = 0; i <= 3; i++) {
                let j = Math.floor(Math.random() * aLength); //获取到随机的索引值
                let deg = (Math.random() * 15 * Math.PI) / 180; //产生0~30之间的随机弧度
                let txt = aCode[j]; //得到随机的一个内容
                num[i] = txt;

                let x = 20 + i * 30; //文字在canvas上的x坐标
                let y = 20 + Math.random() * 8; //文字在canvas上的y坐标
                context.font = "bold 23px 微软雅黑";
                context.translate(x, y);
                context.rotate(deg);
                context.fillStyle = this.randomColor();
                context.fillText(txt, 0, 0);
                context.rotate(-deg);
                context.translate(-x, -y);
            }
            for (let i = 0; i <= 5; i++) {
                //验证码上显示线条
                context.strokeStyle = this.randomColor();
                context.beginPath();
                context.moveTo(
                    Math.random() * canvasWidth,
                    Math.random() * canvasHeight
                );
                context.lineTo(
                    Math.random() * canvasWidth,
                    Math.random() * canvasHeight
                );
                context.stroke();
            }
            for (let i = 0; i <= 30; i++) {
                //验证码上显示小点
                context.strokeStyle = this.randomColor();
                context.beginPath();
                let x = Math.random() * canvasWidth;
                let y = Math.random() * canvasHeight;
                context.moveTo(x, y);
                context.lineTo(x + 1, y + 1);
                context.stroke();
            }
            this.number = this.num.join().replace(/,/g, "");
        }
        /**
         * @description:得到随机颜色
         */
        randomColor() {
            let r = Math.floor(Math.random() * 256);
            let g = Math.floor(Math.random() * 256);
            let b = Math.floor(Math.random() * 256);
            return "rgb(" + r + "," + g + "," + b + ")";
        }
        mounted() {
            this.draw(this.num);
        }

    }
</script>

<style scoped>

    .right {
        float: right !important;
    }

    .login {
        position: absolute;
        top: 400px;
        left: 74%;
        opacity: 0.8;
    }

</style>
