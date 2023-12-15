<template>
  <div>
    <el-menu
      :default-active="$route.path"
      class="el-menu-vertical-demo"
      background-color="#112f50"
      text-color="#fff"
      active-text-color="#409EFF"
      router
      :collapse="isCollapse"
    >
      <el-menu-item>
        <span slot="title">网上书城</span>
      </el-menu-item>
      <el-menu-item index="/">
        <i class="el-icon-menu"></i>
        <span slot="title">首页</span>
      </el-menu-item>
      <!-- <el-menu-item index="/goods">
        <i class="el-icon-document"></i>
        <span slot="title">商品管理</span>
      </el-menu-item> -->
      <el-menu-item index="/user">
        <i class="el-icon-setting"></i>
        <span slot="title">用户中心</span>
      </el-menu-item>
      <!-- <el-menu-item index="/advert">
        <i class="el-icon-setting"></i>
        <span slot="title">广告分类</span>
      </el-menu-item> -->
      <el-submenu index="/order">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>订单管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/order/order-list">
            <i class="el-icon-setting"></i>
            <span slot="title">订单列表</span>
          </el-menu-item>
          <el-menu-item index="/order/order-back">
            <i class="el-icon-setting"></i>
            <span slot="title">退货管理</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
export default {
  props: ["isCollapse"],
  data() {
    return {
      // isCollapse:false
    };
  },
};
</script>

<style lang='less' scoped>
.el-menu {
  border-right: 0;
  .is-active {
    background: #1e78bf !important;
    color: #fff !important;
  }
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>