/**
 * 请求的方法
 */

import axios from 'axios'
import base from './base'
const api ={
    // userCenter(params){
    //     return axios.get(base.userCenter, {
    //         params
    //     })
    // },
    // login(params){
    //     return axios.get(base.login, {
    //         params
    //     })
    // },
    /**
     * 商品列表
     */
    getGoodsList(params){//{page:xx}
        return axios.get(base.goodsList,{
            params
        })
    },
    /**
     * 搜索商品数据
     * search
     */
    getSearch(params){//{search:xx}
        return axios.get(base.search,{params})
    },
    /**
     * 获取类目选择
     * {id：cid}
     */
     getSelectCategory(params){
         return axios.get(base.selectCategory,{params})
     },
     /**
      * 添加商品
      * 参数： title cid  category sellPoint price num desc paramsInfo image
      */
      addGoods(params){//={}
          return axios.get(base.addGoods,{
              params
          })
      },
      /**
       * 删除商品 id
       */
       deleteGoods(params){
           return axios.get(base.deleteGoods,{params})
       },
       /**
        * 编辑商品id
        */
        updateGoods(params){
            return axios.get(base.updateGoods,{params})
        }
}

export default api

