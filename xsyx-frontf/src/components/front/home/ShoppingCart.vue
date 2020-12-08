<template>
    <div class="bse-scroll-y" style="max-height: 500px" v-loading="!carData">
        <div v-if="!!carData">
            <el-container v-for="(item,i) in carData" :key="i" class="item">
                <el-col :span="4">
                    <el-row>
                        <el-image style="width: 50px; height: 50px" :src="item.image"></el-image>
                    </el-row>
                </el-col>
                <el-col :span="20">
                    <el-row style="margin-bottom: 5px">
                        <span class="show-shopping">{{ item.name }}</span>
                        <!-- 鼠标放上去提示移除该商品 -->
                        <el-tooltip content="移除该商品" placement="top">
                            <el-icon class="el-icon-close remove"></el-icon>
                        </el-tooltip>
                    </el-row>
                    <el-row style="font-size: 13px;color: #6c6c6c">
                        <span>￥{{ item.price }} × {{ item.count }}</span>
                    </el-row>
                </el-col>
            </el-container>
        </div>
        <el-container class="item" style="height: 50px">
            <span style="font-size: 18px;">总计 : ￥{{ sumPrice }}</span>
        </el-container>
        <el-container class="item" style="height: 70px;text-align: center;">
            <el-col :span="12">
                <el-button type="primary" round plain style="width: 140px">查看</el-button>
            </el-col>
            <el-col :span="12">
                <el-button type="success" round plain style="width: 140px">下单</el-button>
            </el-col>
        </el-container>
    </div>
</template>

<script lang="ts">
    import {Vue, Component, Prop, Watch} from "vue-property-decorator";
    import {ShoppingData} from "@/helper/front/ShoppingCartHelper";

    @Component
    export default class ShoppingCart extends Vue {

        @Prop()
        carData!: ShoppingData[];

        get sumPrice(): number {
            let sum = 0;
            if (this.carData)
            for (let i = 0;i < this.carData.length;i++) {
                let temp = this.carData[i];
                sum += temp.count * temp.price;
            }
            return sum;
        }
    }
</script>

<style scoped>
    .item {
        margin-right: 0;
        color: #5D5D5D;
        height: 80px;
        width: 400px;
        padding: 15px;
    }
    .show-shopping {
        cursor: pointer;
        transition: color 0.2s linear;
    }
    .show-shopping:hover {
        color: #67C23A;
    }
    .remove {
        transition: color 0.2s linear;
        float: right;
        font-weight: bold;
        cursor: pointer;
    }
    .remove:hover {
        color: firebrick;
    }
</style>