<!--仓库信息维护页面-->
<template>
<div>3333</div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Warehousemaintain extends Vue {

        created() {
            this.$store.commit('back/url', window.location.href);
        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>