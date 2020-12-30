<template>
    <div>
        <el-page-header content="个人首页"></el-page-header>
        <div style="margin-top: 70px">
            <!--            <el-avatar :size="110" :src="require('@/assets/mcimg/16.png')"></el-avatar>-->
            <el-upload
                    class="avatar-uploader"
                    :action="'http://localhost:8080/userFileUpload?dir=frontImage&uId=' + userHelper.userId"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload"
                    name="file">
                <img v-if="imageUrl" :src="'http://localhost:8080/' + imageUrl" class="avatar">

                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <div style="font-size: 15px;margin-left: 180px;margin-top: -60px">
                昵称：{{ user.username }}<br><br>
            </div>
            <div  class="smrz" v-show="isSmrz">
                <i class="el-icon-check"></i>
                已实名认证
            </div>
            <div  class="smrz" v-show="isnSmrz">
                <i class="el-icon-close"></i>
                未实名认证
            </div>


            <file-load-demo></file-load-demo>
        </div>
        <el-divider></el-divider>
        <div style="font-size: 15px">
            <label>姓名：</label>
            <el-input type="text" style="width: 200px" v-model="user.uname">

            </el-input>
        </div>
        <br>
        <br>
        <div style="font-size: 15px">
            <label>电话：</label>
            <el-input type="text" style="width: 200px" v-model="user.phone">123</el-input>
        </div>
        <br>
        <br>
        <div style="font-size: 15px">

            <label>个性签名：</label>
            <el-input type="text" style="width: 200px" v-model="user.signature"></el-input>
        </div>


        <br>
        <br>
        <div style="font-size: 15px">
            <label>性别：</label>
            <el-radio v-model="user.sex" label="男">男</el-radio>
            <el-radio v-model="user.sex" label="女" >女</el-radio>
        </div>
        <br>
        <el-button type="primary" @click="xg()">确认修改</el-button>
    </div>

</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";
    import {Message, User} from "@/helper/entity";
    import FileLoadDemo from "@/views/front/demo/FileLoadDemo.vue";
    import {UserHelper} from "@/helper/front/UserHelper";
    @Component
    export default class UpdateUser extends Vue {
        userHelper = UserHelper;
        //拿到session
        user: User = {};

        //实名认证
        isnSmrz=false;

        isSmrz= false;
        open(){
            let user = this.user as User;
            if (user.idCard===null) {
                this.isnSmrz=true
            }else {
                this.isSmrz=true
            }
        }
        created() {

            Axios({
                method: 'get',
                url: "/user/get/" + UserHelper.userId
            }).then(value => {
                this.user = value.data;

            })
        }
        //文件上传与下载
        imageUrl: string = null;

        /**
         * 成功上传的回调函数
         */
        handleAvatarSuccess(data: Message) {

            if (data.flag) {
                this.imageUrl = data.msg;
                this.$message.success(data.msg);
            } else {
                this.$message.error(data.msg);
            }

        }
        xg(){
            let params = new URLSearchParams();
            params.append("uname",this.user.uname)
            params.append("phone",this.user.phone)
            params.append("signature",this.user.signature)
            params.append("sex",this.user.sex)
            params.append("headPortrait",this.imageUrl)
            Axios({
                method:'post',
                url:"/user/up/"+UserHelper.userId,
                params:params
            }).then((result) => {
                if (result.data.flag === false) alert(result.data.msg);
                alert("修改成功  ^^")
            })
        }
        beforeAvatarUpload(file: any) {
            //const isJPG = file.type === 'image';
            const isLt2M = file.size / 1024 / 1024 < 2;

            /*if (!isJPG) {
                this.$message.error('上传头像图片只能是 JPG 格式!');
            }*/
            if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!');
            }
            return isLt2M;
        }
    }
</script>

<style scoped>
    .smrz{
        width: 105px;
        border-radius: 4px;
        border: 1px solid #CCCCCC;
        height: 20px;
        /*box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);*/
        margin-left: 180px;
        background-color: #FCFCFC;
        font-family: 楷体;
        font-size: 15px;

    }
</style>