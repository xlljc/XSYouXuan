<template>
    <div>
        <div style="display: block">
            <el-autocomplete
                    class="home-query-input"
                    popper-class="my-autocomplete"
                    v-model="state"
                    :fetch-suggestions="querySearch"
                    :placeholder="'大家都在搜 : ' + hotSearch"
                    clearable
                    @select="handleSelect"
                    ><!--@keydown.enter=""-->
                <template slot-scope="{ item }">
                    <div class="name">{{ item.value }}</div>
                </template>
                <template slot="append">
                    <el-button icon="el-icon-search" type="success" @click="query"></el-button>
                </template>

            </el-autocomplete>
        </div>

    </div>
</template>

<script lang="ts">
    import {Vue, Component, Watch} from "vue-property-decorator";
    import {HomeQueryHelper, HotQueryData, QueryData} from "@/helper/front/HomeQueryHelper";

    let homeQueryHelper = new HomeQueryHelper();

    @Component
    export default class HomeQuery extends Vue {
        state = this.$store.getters["front/homeSearch"] ?? '';
        hotSearchIndex = 0;
        hotQueryList: HotQueryData[] = [];
        hotSearch = '白菜';

        @Watch("state")
        wState(value: string) {
            this.$store.commit("front/homeSearch",value);
        }

        async querySearch(queryString: string, cb: (results: QueryData[]) => void) {
            cb(await homeQueryHelper.queryPrompt(queryString));
        }

        query() {
            if (!this.$store.getters["front/homeSearch"]) {
                this.$store.commit("front/homeSearch",this.state = this.hotSearch);
            }
            //跳页面
            if (this.$router.currentRoute.path !== '/search') {
                this.$router.push({path: "/search"});
            } else {
                //查询
                let search = this.$store.getters["front/search"];
                if (search) search();
            }
        }
        handleSelect(item: {value:string; address: string}) {
            console.log(item.value);
        }

        mounted() {
            homeQueryHelper.getHotQuery().then(value => {
                this.hotQueryList = value;
                setInterval(() => {
                    this.hotSearch = this.hotQueryList[this.hotSearchIndex++].value;
                    if (this.hotSearchIndex >= this.hotQueryList.length) this.hotSearchIndex = 0;
                },5000);
            })
        }
    }
</script>

<style scoped>

</style>