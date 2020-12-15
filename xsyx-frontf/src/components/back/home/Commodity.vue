<!--商品资料维护页面-->
<template>
<div>1111</div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Commodity extends Vue {

        created() {
            //this.$store.commit("back/url",window.location.href);
            //console.log(this.$store.getters['back/url'],window.location.href)
            this.$store.commit('back/url', window.location.href);
            //console.log(this.$store.getters['back/url'])
        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>