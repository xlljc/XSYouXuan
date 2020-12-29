<!--商户统计-->
<template>
    <div>
        <el-row :gutter="15">
            <el-col :span="6">
                <el-card shadow="hover" style="height: 100px">
                    <!-- 待收商品 -->
                    <xl-panel style="height: 40px">
                        <div slot="title">待收商品</div>
                        <div slot="body">
                            <div style="line-height: 40px;font-size: 23px;font-weight: bold;">
                                <div style="float: left;margin-left: 20px;margin-right: 10px">
                                    <svg class="icon" aria-hidden="true" width="40" height="40">
                                        <use xlink:href="#icon-gouwu"></use>
                                    </svg>
                                </div>
                                <div style="float: left;">个数: {{ data.shouHuoCount }}</div>
                            </div>
                        </div>
                    </xl-panel>
                </el-card>
            </el-col>
            <el-col :span="6">
                <el-card shadow="hover" style="height: 100px">
                    <!-- 待提商品 -->
                    <xl-panel style="height: 40px">
                        <div slot="title">待提商品</div>
                        <div slot="body">
                            <div style="line-height: 40px;font-size: 23px;font-weight: bold;">
                                <div style="float: left;margin-left: 20px;margin-right: 10px">
                                    <svg class="icon" aria-hidden="true" width="40" height="40">
                                        <use xlink:href="#icon-ziyuan"></use>
                                    </svg>
                                </div>
                                <div style="float: left;">个数: {{ data.tiHuoCount }}</div>
                            </div>
                        </div>
                    </xl-panel>
                </el-card>
            </el-col>
            <el-col :span="6">
                <el-card shadow="hover" style="height: 100px">
                    <!-- 昨日收入 -->
                    <xl-panel style="height: 40px">
                        <div slot="title">昨日收入</div>
                        <div slot="body">
                            <div style="line-height: 40px;font-size: 23px;font-weight: bold;">
                                <div style="float: left;margin-left: 20px;margin-right: 10px">
                                    <svg class="icon" aria-hidden="true" width="40" height="40">
                                        <use xlink:href="#icon-shouru1"></use>
                                    </svg>
                                </div>
                                <div style="float: left;">￥ {{ data.yesterdayIncome }}</div>
                            </div>
                        </div>
                    </xl-panel>
                </el-card>
            </el-col>
            <el-col :span="6">
                <el-card shadow="hover" style="height: 100px;text-align: center">
                    <!-- 总收入 -->
                    <xl-panel style="height: 40px">
                        <div slot="title">总收入</div>
                        <div slot="body">
                            <div style="line-height: 40px;font-size: 23px;font-weight: bold;">
                                <div style="float: left;margin-left: 20px;margin-right: 10px">
                                    <svg class="icon" aria-hidden="true" width="40" height="40">
                                        <use xlink:href="#icon-07"></use>
                                    </svg>
                                </div>
                                <div style="float: left;">￥ {{ data.sum }}</div>
                            </div>
                        </div>
                    </xl-panel>
                </el-card>
            </el-col>
        </el-row>
        <el-row :gutter="15">
            <el-col :span="24">
                <el-card shadow="hover">
                    <div style="float: left">营收统计 : </div>
                    <el-radio-group v-model="scopeDay" style="margin-left: 30px">
                        <el-radio :label="365">一年内</el-radio>
                        <el-radio :label="30">一个月内</el-radio>
                        <el-radio :label="7">一周内</el-radio>
                    </el-radio-group>

                    <el-divider></el-divider>
                    <!-- 统计图 -->
                    <div ref="biao1" style="width: 60%;height: 400px;float: left"></div>

                    <div ref="biao2" style="width: 40%;height: 400px;float: right"></div>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script lang="ts">
    import {Vue, Component, Watch} from "vue-property-decorator";
    import {init} from 'echarts';
    import XlPanel from "@/components/shop/XlPanel.vue";
    import {ShopHelper} from "@/helper/shop/ShopHelper";
    import {ShopStatisticalType} from "@/helper/entity";
    import col from "element-ui/packages/col/src/col";



    @Component({
        components: {XlPanel}
    })
    export default class ShopStatistics extends Vue {
        //日期范围
        scopeDay: number = 30;

        data: ShopStatisticalType = {};

        @Watch("scopeDay")
        wScopeDay() {
            this.update();
        }

        created() {

        }

        mounted() {
            this.update();
        }

        async update() {
            let data = await ShopHelper.statistical(this.scopeDay);
            console.log(data);
            this.data = data;

            let cols: string[] = [];
            let vals: number[] = [];

            data.timeIncome.forEach(value => {
                cols.push(value.date);
                vals.push(value.value);
            })

            let chart = init(this.$refs["biao1"] as any);
            // 指定图表的配置项和数据

            // 使用刚指定的配置项和数据显示图表。
            chart.setOption({
                title: {
                    text: '近12月收入情况'
                },
                tooltip: {},
                legend: {
                    data:['收入']
                },
                xAxis: {
                    name: "日期",
                    data: cols
                },
                yAxis: {
                    name: "单位: 元"
                },
                series: [{
                    name: '收入',
                    type: 'bar',
                    data: vals
                }]
            });

            let chart2 = init(this.$refs["biao2"] as any);
            chart2.setOption({
                title: {
                    text: '商品销售情况',
                    subtext: "单位: 元",
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                },
                legend: {
                    type: 'scroll',
                    orient: 'vertical',
                    right: 10,
                    top: 20,
                },
                series: [
                    {
                        name: '商品',
                        type: 'pie',
                        radius: '55%',
                        center: ['40%', '50%'],
                        data: data.comIncome,
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            });
        }
    }
</script>

<style scoped>
    .el-row {
        margin-bottom: 15px;
    }
    .el-row:last-child {
        margin-bottom: 0;
    }
</style>