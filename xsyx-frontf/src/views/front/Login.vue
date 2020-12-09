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
                    <el-image style="width: 1855px; height: 800px" :src="require('@/mcimg/loginsss.png')"></el-image>
                </el-col>
                <el-col :span="4">
                    <div class="login">
                        <div class="login-top">
                            用户登录
                        </div>
                        <div class="login-center clearfix">
                            <div class="login-center-img"><el-image style="width: 27px; height: 27px" :src="require('@/mcimg/name.png')"></el-image></div>
                            <div class="login-center-input">
                                <input type="text" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
                                <div class="login-center-input-text">用户名</div>
                            </div>
                        </div>
                        <div class="login-center clearfix">
                            <div class="login-center-img"><el-image style="width: 27px; height: 27px" :src="require('@/mcimg/password.png')"></el-image></div>
                            <div class="login-center-input">
                                <input type="password" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
                                <div class="login-center-input-text">密码</div>
                            </div>
                        </div>
                        <div class="login-center clearfix">
                            <div class="login-center-img"><el-image style="width: 27px; height: 27px" :src="require('@/mcimg/yzm1.png')"></el-image></div>

                            <div class="login-center-input">
                                <input type="password" placeholder="请输入验证码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入验证码'"/>
                                <div class="login-center-input-text">验证码</div>
                                <br>
                                <br>
                                <canvas id="canvas" @click="showNum"></canvas>


                            </div>

                        </div>
                        <br>
                        <div class="login-button">
                            登陆
                        </div>
                    </div>
                    <div class="sk-rotating-plane"></div>
                </el-col>
            </el-main>

            <el-footer>

                <h2>合作商</h2>


            </el-footer>

        </el-container>
    </div>
</template>

<script lang="ts">
    import {Vue, Component, Watch} from "vue-property-decorator";


    @Component({
        components: {
        }
    })
    export default class Login extends Vue {
        /*num: [];
        number: "";*/
        num:string[] = [];
        number = "";
        /*data() :{}{
            return {
                num: [],
                number: ""
            };
        }*/
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

<!--                <el-col :span="24">-->
<!--                    <el-image style="width: 200px; height: 200px" :src="require('@/mcimg/logos.png')"></el-image>-->
<!--                </el-col>-->

<!--                <el-col :span="24">-->
<!--                    <el-image style="width: 1800px; height: 800px" :src="require('@/mcimg/logins.png')"></el-image>-->
<!--                </el-col>-->