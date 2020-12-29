<template>
    <div class="xl-panel">
        <slot class="xl-panel-title" name="title"></slot>
        <slot name="body"></slot>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class XlPanel extends Vue {

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>
    .xl-panel {
        width: auto;
        height: auto;
        padding: 10px;
        border: 1px solid #a8a8a8;
        border-radius: 4px;
    }
    .xl-panel > *:first-child {
        width:fit-content;
        width:-moz-fit-content;
        padding-right: 10px;
        padding-left: 10px;
        color: #4F4F4F;
        background-color: white;
        transform: translate(0px,-12px);
        margin: -6px auto;
    }
</style>