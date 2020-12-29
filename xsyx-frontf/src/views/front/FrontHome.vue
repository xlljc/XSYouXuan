<template>
  <div>
    <el-container>

      <el-header style="position: fixed;width: 100%;z-index: 10;margin-top: -9px;">
        <el-menu :default-active="'1'"
                 mode="horizontal">
          <el-menu-item>
            <el-image style="width: 60px; height: 60px" :src="logoImg"></el-image>
          </el-menu-item>
          <el-menu-item index="1"><i class="el-icon-house"/>首页</el-menu-item>

          <el-menu-item class="right">
            <el-button round type="success" plain>现在下单</el-button>
          </el-menu-item>
          <el-menu-item class="right" index="7">联系客服</el-menu-item>
          <el-menu-item class="right" index="6">注册</el-menu-item>
          <el-menu-item class="right" index="5">登录</el-menu-item>
          <!--购物车-->
          <el-submenu class="right" index="4" >
            <template slot="title">
              <i class="el-icon-shopping-cart-2">
                <el-badge :value="carData ? carData.length : 0" :max="99" type="success" style="margin-top: -30px;margin-left: -8px"/>
              </i>
            </template>
            <!--购物车模板-->
            <shopping-cart :car-data="carData"></shopping-cart>
          </el-submenu>
          <el-menu-item class="right" index="3"><i class="el-icon-scissors"></i>每日特价</el-menu-item>
          <el-submenu class="right" index="2">
            <template slot="title"><i class="el-icon-notebook-2"></i>商品分类</template>
          </el-submenu>
          <el-menu-item class="right">
            <!--搜索-->
            <home-query></home-query>
          </el-menu-item>

        </el-menu>
      </el-header>


      <el-main style="margin-top: 50px">

        <!--巨幕-->
        <hugescreen></hugescreen>
        <!-- 热门分类, 显示最近搜索量较大的分类(需要查询7天内的数据) , 显示大概 10 条 , 后面接更多分类 -->
        <hot-types></hot-types>
        <!-- 新品上市, 推荐 5 * 2 条最近上架的商品 (不是按上架时间来排序 , 根据最新上架的30条随机选10条 , 6时刷新) , 后面接更多新品 -->
        <new-commodity :data="homeData.newReleases"></new-commodity>
        <!-- 推荐最近评价最多且评分最高的商品 5 * 2 条 (不是按评分来排序 , 根据最评价和评分最好的30条随机选10条 , 24小时一刷新) , 后面接更多精品 -->
        <!--<praise-commodity></praise-commodity>-->
        <!-- 广告区 : 3 * 1 条广告 -->

        <!-- 热销商品 : 推荐最近销量最高的商品 5 * 2 条 (不是销量来排序 , 根据最销量最好的30条随机选10条 , 6小时一刷新) , 后面接更多热销商品 -->
        <hot-sale :data="homeData.hotSale"></hot-sale>
        <!-- 特价区 : 推荐特价商品 5 * 2 条 (随机抽取 , 3小时刷新一次) -->
        <!--<special-offer></special-offer>-->
        <!-- 广告区 : 3 * 1 条广告 -->

        <!-- 猜你喜欢 : 根据用户最近浏览推送出相关商品 (显示20条记录 , 最少2个分类) , 推送大概 5 * 2 条 ,后面接更多推荐 -->
        <guess-likes :data="homeData.guessLikes"></guess-likes>

      </el-main>


      <el-footer style="margin: 100px -10px -10px -10px;padding: 0;">
        <!-- 页尾 -->
        <home-footer></home-footer>
      </el-footer>

    </el-container>
  </div>
</template>

<script lang="ts">
  import {Vue, Component} from "vue-property-decorator";
  import HomeQuery from "@/components/front/home/HomeQuery.vue";
  import ShoppingCart from "@/components/front/home/ShoppingCart.vue";
  import Hugescreen from "@/components/front/home/Hugescreen.vue";
  import {ShoppingCartHelper, ShoppingData} from "@/helper/front/ShoppingCartHelper";
  import HotTypes from "@/components/front/home/HotTypes.vue";
  import HomeFooter from "@/views/front/Footer.vue";
  import NewCommodity from "@/components/front/home/NewCommodity.vue";
  import PraiseCommodity from "@/components/front/home/PraiseCommodity.vue";
  import HotSale from "@/components/front/home/HotSale.vue";
  import SpecialOffer from "@/components/front/home/SpecialOffer.vue";
  import GuessLikes from "@/components/front/home/GuessLikes.vue";
  import {HomeDataType} from "@/helper/entity";
  import {HomeHelper} from "@/helper/front/HomeHelper";

  let shoppingCartHelper = new ShoppingCartHelper();

  @Component({
    components: {
      GuessLikes,
      SpecialOffer,
      HotSale,
      PraiseCommodity,
      NewCommodity,
      HomeFooter,
      HotTypes,
      HomeQuery,
      ShoppingCart,
      Hugescreen
    }
  })
  export default class FrontHome extends Vue {
    logoImg = require('@/assets/logo.png');
    carData: ShoppingData[] = null;

    homeData: HomeDataType = {
      newReleases: [],
      hotSale: [],
      guessLikes: []
    };

    async created() {
      shoppingCartHelper.getShoppingData().then(value => {
        this.carData = value;
      })

      //查询首页信息
      this.homeData = await HomeHelper.getHomeDate();
    }
  }
</script>

<style scoped>
  .el-menu--horizontal > .el-menu-item.is-active {
    border-bottom: 2px solid #67C23A;
  }

  .right {
    float: right !important;
  }
</style>