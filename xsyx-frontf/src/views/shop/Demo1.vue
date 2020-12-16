<template>
    <div style="width: 500px;height: 500px;">
        <router-link tag="button" to="/shop/y1">页面1</router-link>
        <router-link tag="button" to="/shop/y1">页面2</router-link>
        <div style="width: 500px;height: 300px;">
            <router-view></router-view>
        </div>
        <div v-html="html"></div>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Demo1 extends Vue {
        html = "<a href='#'>链接</a>";
        created() {
            
        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>