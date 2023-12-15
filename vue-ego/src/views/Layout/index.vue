<template>
  <div class="layout">
      <!-- 左侧导航区域 -->
      <MyMenu class="menu" :isCollapse='isCollapse'/>
      <!-- 右侧内容区域 -->
      <Content class="contents" :class="{isActive:isCollapse}" @changeCollapse='changeCollapse' :isCollapse='isCollapse'/>
  </div>
</template>

<script>
import MyMenu from './Mymenu.vue'
import Content from './Content.vue'
export default {
    components:{
        MyMenu,
        Content
    },
    data(){
        return {
            isCollapse:false,
        }
    },
    methods:{
        changeCollapse(){
            this.isCollapse = !this.isCollapse;
        }
    }
}
</script>

<style lang='less' scoped>
.layout{
    .menu{
        // width: 200px;
        // min-height: 500px;
        background: #112f50;
        position: fixed;
        top:0;
        bottom:0;
    }
    .contents{
        margin-left: 200px;
        transition: all 0.3s;
        background-image: url(../../assets/img/user-back1.jpg);
        background-size: 50% auto;
        background-repeat: repeat-x;
    }
    .isActive{
        margin-left: 64px;
    }
}

</style>