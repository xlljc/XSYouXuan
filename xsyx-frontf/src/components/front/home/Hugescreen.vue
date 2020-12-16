<template>
    <div class="block">
        <el-carousel trigger="click" height="400px" autoplay :interval="4000">
            <el-carousel-item v-for="(item,index) in data" :key="index">

                <el-container style="height: 100%">
                    <el-col :span="12" style="text-align: center;padding-top: 80px">
                        <p style="font-size: 35px;font-weight: bolder;margin: 20px 0">{{item.title}}</p>
                        <p style="font-size: 17px;margin: 20px 0">{{item.label}}</p>
                        <div style="margin-top: 15px">
                            <el-button round type="primary" plain>查看详情</el-button>
                            <el-button round type="success" plain>加入购物车</el-button>
                        </div>

                    </el-col>
                    <el-col :span="12">
                        <el-image fit="cover" style="height: 100%" :src="item.image"></el-image>
                    </el-col>
                </el-container>

            </el-carousel-item>
        </el-carousel>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    type hugescreenData = {
        image: unknown;
        title: string;
        label: string;
    }
    @Component
    export default class Hugescreen extends Vue {
        data: hugescreenData[] = [
            {
                image: require('@/assets/home-1.jpg'),
                title: '年终究极大特惠',
                label: '秒杀天天有，今天更刺激。'
            },{
                image: require('@/assets/slide3.jpg'),
                title: '巨幕标题巨幕标题巨幕标题巨幕',
                label: '爆价出击，让你躲无可躲。'
            },{
                image: require('@/assets/slide-2.jpg'),
                title: '巨幕标题巨幕标题巨幕标题巨幕',
                label: '一路惠，一路降，一路有你，就不怕。'
            }
        ];
        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>