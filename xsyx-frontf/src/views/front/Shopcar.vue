<template>
    <div>
        <el-container>
            <el-header style="position: fixed;width: 100%;z-index: 10;margin-top: -9px;">
                <el-menu :default-active="'1'"
                         mode="horizontal">

                    <el-menu-item><i class="el-icon-house" style="margin-left:90px;"/>首页</el-menu-item>
                    <el-menu-item class="right">
                        <el-image style="width: 55px; height: 50px;" :src="require('@/assets/mcimg/hua.png')"></el-image>
                    </el-menu-item>
                    <el-menu-item class="right" index="8" >关于我们</el-menu-item>
                    <el-menu-item class="right" index="7" >联系客服</el-menu-item>
                    <el-menu-item class="right" index="6">注册</el-menu-item>
                    <el-menu-item class="right" index="5">登录</el-menu-item>
                    <el-menu-item index="3"><i class="el-icon-scissors"></i>每日特价</el-menu-item>
                </el-menu>
            </el-header>
<!--            <el-main style="margin-top: 30px;">-->
<!--                <el-menu :default-active="'1'"-->
<!--                         mode="horizontal">-->
<!--                <el-menu-item>-->
<!--                    <el-image style="width: 100px; height: 100px" :src="require('@/mcimg/logos.png')"></el-image>-->
<!--                </el-menu-item>-->
<!--                </el-menu>-->
<!--            </el-main>-->
            <el-container>

                <el-row height="" style="margin-top: 50px;">
                    <el-menu :default-active="'1'"  style="margin-top: 30px"
                                 mode="horizontal" >

                        <el-menu-item>
                            <el-image style="width: 100px;margin-left: 100px ;margin-top: -30px" :src="require('@/assets/mcimg/logos.png')"></el-image>
                        </el-menu-item>
                        <el-menu-item>
                            <el-menu-item style="font-size: 30px;margin-left: -50px">购物车</el-menu-item>
                        </el-menu-item>
                        <el-menu-item style="margin-left: 200px;margin-top: -50px">
                        <el-input placeholder="请输入内容" v-model="input4" class="fount">
                            <i slot="prefix" class="el-input__icon el-icon-search"></i>
                            <el-button slot="append">搜索</el-button>
                        </el-input>
                        </el-menu-item>
                        </el-menu>

                </el-row>
            </el-container>
            <el-menu
                    :default-active="activeIndex2"
                    class="el-menu-demo"
                    mode="horizontal"
                    @select="handleSelect"
                    style="margin-left: 110px"

                    active-text-color="#ffd04b">
                <el-menu-item index="1" style="font-size: 20px">全部商品</el-menu-item>
                <el-menu-item index="2" style="font-size: 20px">库存紧张</el-menu-item>

                <div class="zj">
                    已选择商品 总价：
                </div>
                <div style="color: #EA6650;font-size: 20px;margin-left: 1470px;margin-top: -27px">
                    100元
                    <el-button type="danger" size="small" style="margin-left: 10px">结算</el-button>
                </div>

            </el-menu>
            <el-row>
                <el-checkbox v-model="checkAll" style="margin-left: 320px;margin-top: 40px">全选</el-checkbox>
                <div style="font-size: 20px;margin-left: 570px;margin-top: -20px">商品信息</div>
                <div style="font-size: 20px;margin-left: 1110px;margin-top: -20px">数量</div>
                <div style="font-size: 20px;margin-left: 1360px;margin-top: -20px">总金额</div>
                <div style="font-size: 20px;margin-left: 1555px;margin-top: -20px">操作</div>
            </el-row>
            <el-main>
                <el-col :span="24">
                    <div class="sp">
                        <el-checkbox style="margin-left: 20px;"></el-checkbox>
                            <el-image style="width: 150px;height: 150px; margin-left: 20px;margin-top: 20px" :src="require('@/assets/mcimg/shop-3-540x540.jpg') "></el-image>
                            <div style="font-size: 18px;margin-left: 250px;margin-top: -140px;width: 300px;height: 100px;">
                                好吃的苹果 苹果很好吃

                            </div>
                            <div class="guige">
                                商品规格
                            </div>
                            <div class="danjia">
                            单价
                             </div>
                            <div class="numbers">
                                <el-input-number v-model="num" @change="handleChange" :min="1" :max="10"></el-input-number>
                            </div>
                        <div class="allmoney">
                            总金额
                        </div>
                        <div class="cz">
                            操作
                        </div>

                    </div>
                </el-col>
            </el-main>

        </el-container>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Shopcar extends Vue {
        num=1;
        handleChange(value: number) {
            console.log(value);
        }

    }
</script>

<style scoped>
    .right {
        float: right !important;
    }
    .fount{
        margin-left: 1300px;
        width: 300px;
    }
    .zj{
        margin-left: 1300px;
        font-size: 20px;
        margin-top: 40px;
        width:200px;
    }
    .sp{
        width: 1400px;
        border-radius: 4px;
        border: 1px solid #CCCCCC;
        height: 200px;
        /*box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);*/
        margin-left: 300px;
        background-color: #FCFCFC;

    }
    .guige{
        font-size: 18px;
        margin-left: 490px;
        border: 1px solid #CCCCCC;
        width: 250px;
        height: 100px;
        margin-top: -100px;

    }
    .danjia{
        font-size: 18px;
        margin-left: 790px;
        width: 150px;
        height: 50px;
        margin-top: -100px;
    }
    .numbers{
        width: 150px;
        height: 50px;
        margin-top: -10px;
        margin-left: 790px;
    }
    .allmoney{
        font-size: 18px;
        margin-top: -90px;
        margin-left: 1040px;
        width: 150px;
        height: 50px;
    }
    .cz{
        font-size: 18px;
        margin-top: -50px;
        margin-left: 1240px;
        width: 150px;
        height: 50px;
    }
</style>