<template>
    <div class="xsyx-block">
        <el-row>
            <div class="xsyx-flag" style="background-color: #8558D6"></div>
            <label style="font-size: 20px;color: #8558D6;display: inline">新品上市</label>
            <el-link style="float: right">更多新品 >></el-link>
            <div class="xsyx-line"></div><br>
        </el-row>

        <el-row>
            <div class="xsys-commodity-box">
                <commodity v-for="item in data" :key="item" :data="item"></commodity>
            </div>
        </el-row>

    </div>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import Commodity from "@/components/front/home/Commodity.vue";
    import {Commodity as Com} from '@/helper/entity';

    @Component({
        components: {
            Commodity
        }
    })
    export default class NewCommodity extends Vue {

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