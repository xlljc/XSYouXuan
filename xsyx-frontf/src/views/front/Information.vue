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
                <!--                <img v-if="imageUrl" :src="'http://localhost:8080/' + imageUrl" class="avatar">-->
                <el-image style="width:200px;height: 200px" v-if="user.headPortrait" :src="$host + user.headPortrait"></el-image>
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <div style="font-size: 15px;margin-left: 240px;margin-top: -60px">
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

            <div style="margin-left: 390px;margin-top: -40px" v-show="isnSmrz">
                <el-button type="info" plain @click="dialogVisible = true">实名认证</el-button>
            </div>

            <div style="margin-left: 390px;margin-top: -40px" v-show="isSmrz">
                <el-button type="warning" plain @click="$router.replace('/zcsh')">申请成为商户</el-button>
            </div>

            <div style="margin-left: 390px;margin-top: -40px" v-show="sh">
                <el-button type="warning" plain>商户中心</el-button>
            </div>

            <file-load-demo></file-load-demo>
        </div>
        <el-divider></el-divider>
        <div style="font-size: 15px">
            <label>姓名：</label>
            <el-input type="text" :disabled="true" style="width: 200px;margin-left: 40px" v-model="user.uname">
            </el-input>
        </div>
        <br>
        <br>
        <div style="font-size: 15px" v-show="isSmrz">
            <label>生日：</label>
            <el-input type="text"  suffix-icon="el-icon-date" :disabled="true" style="width: 200px;margin-left: 40px" v-model="birthday"></el-input>
        </div>
        <br>
        <br>
        <div style="font-size: 15px">
            <label>电话：</label>
            <el-input type="text" style="width: 200px;margin-left: 40px" v-model="user.phone" :disabled="true">123</el-input>
        </div>
        <br>
        <br>
        <div style="font-size: 15px">
            <label>个性签名：</label>
            <el-input type="text" style="width: 200px ;margin-left: 10px" v-model="user.signature" :disabled="true"></el-input>
        </div>
        <br>
        <br>
        <div style="font-size: 15px" v-show="sqsh">
            <label>身份证：</label>
            <el-input type="text" style="width: 200px;margin-left: 24px" v-model="user.idCard" :disabled="true"></el-input>
        </div>

        <br>
        <br>
        <div style="font-size: 15px">
            <label>性别：</label>
            <el-radio v-model="user.sex" :disabled="true" label="男" style=";margin-left: 40px">男</el-radio>
            <el-radio v-model="user.sex" :disabled="true" label="女" >女</el-radio>
        </div>
        <!--        添加身份证-->
        <el-dialog
                title="实名认证"
                :visible.sync="dialogVisible"
                width="30%"
                :before-close="handleClose">
            <span style="font-size: 25px;margin-left: 5px" >{{user.uname}}</span>
            <br>
            <br>

            <el-input  suffix-icon="el-icon-postcard" v-model="user.idCard" placeholder="请输入您的身份证"></el-input>
            <span slot="footer" class="dialog-footer">

            <el-button @click="dialogVisible = false">取 消
            </el-button>
            <el-button type="primary" @click="smrzff">确 定</el-button>
          </span>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";
    import {Message, User} from "@/helper/entity";
    import FileLoadDemo from "@/views/front/demo/FileLoadDemo.vue";
    import {UserHelper} from "@/helper/front/UserHelper";
    @Component
    export default class Information extends Vue {
        userHelper = UserHelper;

        dialogVisible:boolean=false
        birthday="";
        //气泡框

        //拿到session
        user: User = {};
        //实名认证
        isnSmrz=false;
        isSmrz= false;
        sqsh=false;
        sh=false;

        //实名认证按钮显示  加上商户入口注册按钮
        open() {
            // let params = new URLSearchParams();
            // params.append("idCard",this.user.idCard)

            // let user = this.user as User;
            if (this.user.idCard === null) {
                this.isnSmrz = true

            } else {
                this.isSmrz = true
                this.sqsh=true
            }
            let id = this.user.idCard;
            id=id.substr(0,id.length-4)+"****";
            this.user.idCard=id;
        }

        shrk(){
            if (this.user.merid===null){
                this.sh=false
            }else {
                this.sh=true
                this.isSmrz=false
            }
        }


        handleClose(done:any) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => {});
        }

        smrzff(){
            let params = new URLSearchParams();
            params.append("idCard",this.user.idCard)

            Axios({
                method:'post',
                url:"/user/up/"+UserHelper.userId,
                params:params
            }).then((result) => {
                this.dialogVisible=false
                if (result.data.flag === false) alert(result.data.msg);
            })
        }

        //生日
        birthdays(){

            let idcard=this.user.idCard;

            if (idcard !== null && idcard !== ""){
                if (idcard.length===18){
                    this.birthday = idcard.substr(6,8);
                }
                this.birthday = this.birthday.replace(/(.{4})(.{2})/,"$1-$2-");
            }
            return this.birthday;
        }

        created() {

            Axios({
                method: 'get',
                url: "/user/get/" + UserHelper.userId
            }).then(value => {
                this.user = value.data;
                this.open();
                this.birthdays()
                this.shrk();

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
        margin-left: 240px;
        background-color: #FCFCFC;
        font-family: 楷体;
        font-size: 15px;

    }
</style>