## 后台管理系统
  某个个后台管理系统，包含商品管理 用户管理 订单等等信息。 

前端开发内容：
    PC端(比如:京东)  移动端(手机预览的网页)  小程序  后台管理界面  

后台开发：
    服务器： 后台语言 java、 php、 python 、大数据、人工智能 

架构师： --- 技术总监 

前后端分离：
    用户 --- >前端-视图-数据---->后台-提供接口 ---> 数据库  

## 技术点
    Vue + Vue-router  + Vuex + Element-ui + Axios  + Echarts + 其他三方库



## 项目搭建
1. vue create vue-ego 
2. vue-router vuex 
3. axios 
4. vue add element --(按需)


## 项目初始化
1. 删除无用的组件 home.vue about.vue hello... 
2. css初始化  
3. incofont 图标导入


## 后台服务
1. node.js服务  
2. express 
3. jwt（生成token）
4. mysql


## 路由大配置
1. 页码布局配置 同级登录界面


## 商品管理界面 


### 类目选择


### 上传图片
1. upload 图片上传
2. 后台配置
   1. 后台安装 multer 模块   同时引入fs模块
   2. router.js入口文件导入模块
       const fs=require('fs')
        const multer=require('multer')
   3. 上传图片 配置upload

### 富文本编辑
1. 百度编译器
2. wangEditor 

wangEditor使用步骤：
1. 官网网址：https://www.wangeditor.com/doc/ 
2. 基本使用
    1. 安装：npm i wangeditor --save 
    2. 引入模块：
       import E from "wangeditor"
    3. 使用wangeditor
        const editor = new E("#div1")
        editor.create()

3. 常用配置
    1. 清空内容
         editor.txt.clear() 清空编辑器内容。

    2. 设置内容
         editor.txt.html('') 获取 html 

    3. 配置菜单
       1. 配置菜单使用 editor.config.menus 定义显示哪些菜单和菜单的顺序
     
    4. 配置 onchange 回调函数 
       配置 onchange 函数之后，用户操作（鼠标点击、键盘打字等）导致的内容变化之后，会自动触发 onchange 函数执行



