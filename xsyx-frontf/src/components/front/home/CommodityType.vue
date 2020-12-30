<template>
    <div class="xsyx-type-item">

        <div class="xsyx-type-content" @click="searchType(data.name)">
            <svg :class="['zdy-icon','index' + index]" style="width: 50px;height: 50px" aria-hidden="true">
                <use :xlink:href="index | icon"></use>
            </svg>
            <div class="type-name">{{ data.name }}</div>
        </div>
    </div>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import {ComType} from "@/helper/entity";

    @Component({
        filters: {
            icon: (index: number) => {
                switch (index) {
                    case 0: return '#icon-guanjun';
                    case 1: return '#icon-yajun';
                    case 2: return '#icon-jijun';
                    default: return '#icon-' + (index + 1);
                }
            }
        }
    })
    export default class CommodityType extends Vue {
        @Prop()
        index: number;
        @Prop()
        data: ComType;

        searchType(str: string) {
            this.$store.commit("front/homeSearch",str);
            this.$router.push({path: "/search"});

        }
    }
</script>

<style scoped>
    .type-name {
        padding-left: 5px;
        padding-right: 5px;
        margin-top: 12px;
        color: #5e5e5e;
        font-size: 14px;
        transition: color linear 0.2s;
    }
    .type-name:hover {
        color: #212121;
    }
    .index3 {
        color: #ff6868;
    }
    .index4 {
        color: #ffcd68;
    }
    .index5 {
        color: #c5ff68;
    }
    .index6 {
        color: #77ff68;
    }
    .index7 {
        color: #68ffb1;
    }
    .index8 {
        color: #68b9ff;
    }
    .index9 {
        color: #7268ff;
    }
</style>