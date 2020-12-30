<template>
    <div class="xsyx-block">
        <el-row>
            <div class="xsyx-flag" style="background-color: #FF7034"></div>
            <label style="font-size: 20px;color: #FF7034;display: inline">热销商品</label>
            <el-link style="float: right">更多热销 >></el-link>
            <div class="xsyx-line"></div><br>
        </el-row>

        <el-row>
            <div class="xsys-commodity-box">
                <commodity v-for="(item,index) in data" :key="index" :data="item"></commodity>
            </div>
        </el-row>

    </div>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import Commodity from "@/components/front/home/Commodity.vue";
    import {Commodity as Com} from "@/helper/entity";
    @Component({
        components: {Commodity}
    })
    export default class HotSale extends Vue {

        @Prop()
        data: Com[];

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>