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
                    @keydown.enter="console.log('选择了')">
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
    import {Vue, Component} from "vue-property-decorator";
    import {HomeQueryHelper, HotQueryData} from "@/helper/front/HomeQueryHelper";

    let homeQueryHelper = new HomeQueryHelper();

    @Component
    export default class HomeQuery extends Vue {
        state = '';
        hotSearchIndex = 0;
        hotQueryList: HotQueryData[] = [];
        hotSearch = '白菜';

        querySearch(queryString: string, cb: (results: {}[]) => void) {
            homeQueryHelper.queryPrompt(queryString).then(value => {
                cb(value);
            })
        }

        query() {
            if (!this.state) {
                this.state = this.hotSearch;
            }
            console.log("选择了 : " + this.state);
        }
        handleSelect(item: {value:string; address: string}) {
            console.log(item.value);
        }

        created() {

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