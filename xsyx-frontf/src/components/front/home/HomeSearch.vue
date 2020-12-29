<template>
    <el-container>

        <front-header ref="head"></front-header>


        <el-main style="margin-top: 50px;min-height: 400px">
            <div class="xsyx-block">
                <el-row>
                    <div class="xsyx-flag" style="background-color: #8558D6"></div>
                    <label style="font-size: 20px;color: #8558D6;display: inline">搜索结果</label>
                    <div class="xsyx-line"></div><br>
                </el-row>

                <el-row>
                    <div class="xsys-commodity-box">
                        <commodity v-for="(item,index) in tableData.list" :key="index" :data="item"></commodity>
                    </div>
                </el-row>

            </div>

            <el-pagination
                    @size-change="rowChange"
                    @current-change="pageChange"
                    background
                    :page-sizes="[20, 30, 50, 100]"
                    :page-size="20"
                    layout="total, sizes, prev, pager, next"
                    :total="tableData.total">
            </el-pagination>

        </el-main>


        <el-footer style="margin: 100px -10px -10px -10px;padding: 0;">
            <!-- 页尾 -->
            <home-footer></home-footer>
        </el-footer>

    </el-container>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import FrontHeader from "@/components/front/home/FrontHeader.vue";
    import HomeFooter from "@/views/front/Footer.vue";
    import {HomeQueryHelper} from "@/helper/front/HomeQueryHelper";
    import {Commodity as Com, PageInfo} from "@/helper/entity";
    import Commodity from "@/components/front/home/Commodity.vue";

    let homeQueryHelper = new HomeQueryHelper();

    @Component({
        components: {Commodity, FrontHeader,HomeFooter}
    })
    export default class HomeSearch extends Vue {

        $refs: {
            head: any;
        }

        //当前页数
        page: number = 1;
        //每页条数
        row: number = 10;

        tableData: PageInfo<Com> = {
            list: []
        };

        created() {
            this.search();
            this.$store.commit("front/search",this.search);
        }

        mounted() {

        }

        async search() {
            let str = this.$store.getters["front/homeSearch"];
            if (str === undefined) {
                this.$store.commit("front/homeSearch",str = '');
            }
            //console.log("被调搜索...",str);
            let data = await homeQueryHelper.searchCom(str,this.page,this.row);
            console.log(data);
            this.tableData = data;
        }

        //页面大小改变
        rowChange(val: number) {
            this.row = val;
            this.search();
        }
        //页数改变
        pageChange(val: number) {
            this.page = val;
            this.search();
        }
    }
</script>

<style scoped>

</style>