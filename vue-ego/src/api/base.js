/**
 * 接口路径配置：
 * 一般文件目录：base.js  index.js 
 * 但是公司不一定
 *      config
 *          login  index.js config.js 
 *       index.js 
 *       xxxx.js 
 */

const base ={
    host:'http://localhost:8081',//基础域名
    goodsList:'/api/api/projectList', //商品列表
    search:'/api/api/search',//商品搜索
    selectCategory:'/api/api/backend/itemCategory/selectItemCategoryByParentId',//类目选择
    uploadUrl:'/api/api/upload',//图片上传 post请求
    addGoods:'/api/api/backend/item/insertTbItem',//添加商品
    deleteGoods:'/api/api/backend/item/deleteItemById',//删除商品
    updateGoods:'/api/api/backend/item/updateTbItem',//编辑商品
    // lookGood:'/api/api/backend/item/updateTbItem',

    userCenter:'http://localhost:8080/demo1/userCenter',
    login:'api/login',
}

// const base ={
//     host:'http://localhost:8080/demo1',//基础域名
//     userCenter:'api/userCenter', //商品列表
    
// }

export default base;
