<template>
    <div class="xsyx-block">
        <el-row>
            <div class="xsyx-flag" style="background-color: #FCAE03"></div>
            <label style="font-size: 20px;color: #FCAE03;display: inline">特价商品</label>
            <el-link style="float: right">更多特价 >></el-link>
            <div class="xsyx-line"></div><br>
        </el-row>

        <el-row>
            <div class="xsys-commodity-box">
                <commodity v-for="item in 10" :key="item"></commodity>
            </div>
        </el-row>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Commodity from "@/components/front/home/Commodity.vue";
    @Component({
        components: {
            Commodity
        }
    })
    export default class SpecialOffer extends Vue {

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>