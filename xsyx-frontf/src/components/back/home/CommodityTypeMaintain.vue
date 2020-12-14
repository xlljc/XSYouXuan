<!--商品类型维护页面-->
<template>
<div>2222</div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class CommodityTypeMaintain extends Vue {

        created() {
            this.$store.commit('back/url', window.location.href);
        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>