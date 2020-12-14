<template>
    <div class="xsyx-commodity-item">
        <div class="xsyx-commodity-content">
            <el-image :src="image" fit="cover" style="height: 180px"></el-image>

        </div>
    </div>

</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Commodity extends Vue {

        image = require('@/assets/xhs.jpg');

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>