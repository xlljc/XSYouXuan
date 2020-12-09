<template>
    <div>
        <canvas id="canvas" @click="activated" style="width: 100px;height: 50px;background-color: #d4d4d4">

        </canvas>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class TestYzm extends Vue {

        private num!: string[];
        private number!: string;

        draw(num: string[]) {
            let canvasWidth = 138;
            let canvasHeight = 36;
            let canvas = document.getElementById("canvas") as HTMLCanvasElement; //获取到canvas的对象，演员
            let context = canvas.getContext("2d"); //获取到canvas画图的环境，演员表演的舞台

            canvas.width = canvasWidth;
            canvas.height = canvasHeight;
            context.fillStyle = "#cccccc";
            context.fillRect(0, 0, 300, 200);
            let sCode =
                "A,B,C,D,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,U,V,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
            let aCode = sCode.split(",");
            let aLength = aCode.length;
            for (let i = 0; i <= 5; i++) {

            }
            //获取到数组的长度
            for (let i = 0; i <= 5; i++) {
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

        activated() {
            this.draw(this.num);
        }

    }
</script>

<style scoped>

</style>