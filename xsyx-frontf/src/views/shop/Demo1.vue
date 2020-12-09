<template>
    <div style="width: 500px;height: 500px;background-color: #6c6c6c">
        <router-link tag="button" to="/shop/y1">页面1</router-link>
        <router-link tag="button" to="/shop/y1">页面2</router-link>
        <div style="width: 500px;height: 300px;background-color: #8A8D94">
            <router-view></router-view>
        </div>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Demo1 extends Vue {

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>