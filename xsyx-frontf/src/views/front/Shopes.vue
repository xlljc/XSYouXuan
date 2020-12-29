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
            <el-row>
                <el-col :span="16">

                    <div style="height: 400px;">
                        <el-image style="width:400px;height: 400px;margin-top: 150px;margin-left: 350px" v-if="sp.image" :src="$host + sp.image"></el-image>
                    </div>
                    <div class="spmz">
                        {{sp.name}}
                    </div>
                    <div class="pice">
                        ￥{{sp.price}}
                    </div>
                    <div class="xq">
                        {{sp.particulars}}
                    </div>
                    <div>
                        <el-input-number v-model="number" @change="handleChange" :min="1" :max="10" style="margin-left: 800px;margin-top: 25px"></el-input-number>
                    </div>
                    <div style="margin-left: 1050px;margin-top: -40px">
                        <el-button type="danger" round @click="addShopcar(sp.id,number)">点击购买</el-button>
                    </div>

                    <div class="pl">
                        品类：
                    </div>
                    <div class="pls">
                        水果
                    </div>
                    <!--            <el-main>-->
                    <!--                <el-menu :default-active="activeIndex2" style="margin-left: 400px;margin-top: 75px"-->
                    <!--                         text-color="#gray"-->
                    <!--                         active-text-color="#F58F8D"-->
                    <!--                         class="el-menu-demo" mode="horizontal">-->
                    <!--                    <el-menu-item index="1" style="font-size: 20px;width: 150px;">说    明</el-menu-item>-->
                    <!--                    <el-menu-item index="2" style="font-size: 20px;width: 150px;">附加信息</el-menu-item>-->
                    <!--                    <el-menu-item index="3" style="font-size: 20px;width: 150px;">用户评论</el-menu-item>-->
                    <!--                </el-menu>-->
                    <!--            </el-main>-->
                </el-col>
                <el-col :span="6">
                    <div style="margin-top: 120px;">
                        <div style="width: 250px;height: 60px;font-size: 20px;font-weight: bolder;
                    font-family: 楷体;">
                            搜索
                            <div style="background-color: #F56C6C;width: 20px;height: 5px;margin-top: 10px;margin-left: 5px"></div>
                            <el-input placeholder="请输入内容......" style="margin-top: 23px;">
                                <el-button slot="append" icon="el-icon-search"></el-button>
                            </el-input>
                            <br>
                        </div>
                        <div style="width: 250px;height: 60px;font-size: 20px;font-weight: bolder;margin-top: 100px;
                    font-family: 楷体;">
                            产品类别
                            <div style="background-color: #F56C6C;width: 20px;height: 5px;margin-top: 10px;margin-left: 5px"></div>

                            <el-dropdown split-button style="margin-top: 15px" @click="handleClick">
                                水果
                                <el-dropdown-menu slot="dropdown">
                                    <el-dropdown-item>肉类</el-dropdown-item>
                                    <el-dropdown-item>蔬菜</el-dropdown-item>
                                </el-dropdown-menu>
                            </el-dropdown>
                        </div>
                        <div>
                            <div style="width: 250px;height: 60px;font-size: 20px;font-weight: bolder;margin-top: 100px;
                    font-family: 楷体;">
                                最受欢迎的
                                <div style="background-color: #F56C6C;width: 20px;height: 5px;margin-top: 10px;margin-left: 5px"></div>
                                <div>
                                    <el-image :src="require('@/assets/mcimg/shop-3-540x540.jpg')" style="width: 50px;height: 50px;margin-top: 20px">
                                    </el-image>
                                    <div style="font-family: 等线;font-weight: initial;margin-left: 60px;margin-top: -55px;font-size: 17px;">青苹果
                                    </div>
                                    <div style="font-family: 等线;font-weight: initial;margin-left: 60px;margin-top: 10px;font-size: 17px;">
                                        ￥20
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </el-col>
            </el-row>
        </el-container>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";
    import {Commodity, Shopcar, User} from "@/helper/entity";

    import {UserHelper} from "@/helper/front/UserHelper";


    @Component
    export default class Shopes extends Vue {
        activeIndex: '1';
        activeIndex2: '1';
        number:number=1;
        id:number=0;
        shopcar:Shopcar={};


        sp : Commodity = {};
        handleChange(value: number) {
            console.log(value);
        }
        handleClick() {
            alert('button click');
        }

        querysp(){
            Axios({
                method:'get',
                url:'/commodity/queryComShpId?id=10',

            }).then(value => {
                this.sp = value.data;
                console.log(this.sp);
            })
        }
        addShopcar(){
            let data = new URLSearchParams();
            //data.append("id",this.cid);

            data.append("cid",this.sp.id.toString());
            data.append("number",this.number.toString());
            // let data = Utils.format(new URLSearchParams(),this.sp,"id","name")
            data.append("uid.id",UserHelper.userId)
            Axios({
                method:'POST',
                url:'/shopcar/add',
                data:data
            }).then((result) => {
                if (result.data.flag === false) alert(result.data.msg);

            })
        }
        //
        // upd(){
        //     let params = new URLSearchParams();
        //     console.log("this.id :",this.id)
        //     params.append("uid.id",this.id.toString())
        //     Axios({
        //         method:'post',
        //         url:"/shopcar/update/",
        //         params:params
        //     }).then((result) => {
        //         if (result.data.flag === false) {
        //             alert(result.data.msg + "id:" + result.data.msg.id);
        //         }
        //     })
        // }

        created(){
            this.querysp();
        }
    }
</script>

<style scoped>
    .right {
        float: right !important;
    }
    .spmz{
        width: 200px;
        font-size: 35px;
        margin-left: 795px;
        margin-top: -270px;
        font-weight: bolder;
        font-family: 仿宋;

    }
    .pice{
        width: 200px;
        font-size: 30px;
        margin-left: 800px;
        margin-top: 25px;
        font-weight: bolder;
        font-family: 新宋体;
    }
    .xq{
        width: 400px;
        font-size: 19px;
        margin-left: 800px;
        margin-top: 25px;
        font-weight: lighter;
        font-family: 楷体;
    }
    .pl{
        width: 200px;
        font-size: 22px;
        font-weight: bolder;
        font-family: 新宋体;
        margin-left: 800px;
        margin-top: 25px;
    }
    .pls{
        font-size: 18px;
        margin-left: 900px;
        margin-top: -22px;
        font-weight: lighter;
    }


</style>