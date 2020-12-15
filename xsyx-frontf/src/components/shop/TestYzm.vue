<template>
    <div>
        <el-upload
                class="upload-demo"
                action="http://localhost:8080/test/fileUpload/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :file-list="fileList"
                list-type="picture"

                name="img">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>

    </div>
</template>

<script lang="ts">
    import {Vue, Component, Watch} from "vue-property-decorator";

    @Component
    export default class TestYzm extends Vue {
        file: any = null;
        fileList = [{
            name: 'food.jpeg',
            url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }, {
            name: 'food2.jpeg',
            url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }]

        @Watch("file")
        wFile() {
            console.log("file",this.file)
        }

        handleRemove(file:unknown, fileList:unknown) {
            console.log(file, fileList);
        }
        handlePreview(file:unknown) {
            console.log(file);
        }

        created() {

        }

        mounted() {

        }

    }
</script>

<style scoped>

</style>