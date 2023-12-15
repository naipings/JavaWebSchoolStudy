<template>
  <div class="goods">
    <!-- 1. 搜索区域 -->
    <div class="header">
      <!-- change	仅在输入框失去焦点或用户按下回车时触发 -->
      <el-input
        @change="searchInp"
        v-model="input"
        placeholder="请输入内容"
      ></el-input>
      <el-button class="Btn01" type="primary">查询</el-button>
      <el-button class="button04" type="success">
        <router-link to="/add-goods" style="color: #fff">页面添加</router-link>
      </el-button>
      <el-button class="button03" type="primary" @click="addGoods">弹框添加</el-button>
    </div>
    <!-- 2. 表格区域展示视图数据 -->
    <div class="wrapper">
      <el-table :data="books" border>
        <el-table-column type="selection" width="55" id="select" prop="select"></el-table-column>
        <el-table-column prop="id" label="书籍ID" width="100">
        </el-table-column>
        <el-table-column
          prop="name"
          label="书籍名称"
          width="220"
          show-overflow-tooltip
        >
        </el-table-column>
        <el-table-column prop="price" sortable label="书籍价格" width="120">
        </el-table-column>
        <el-table-column prop="author" sortable label="书籍作者" width="120">
        </el-table-column>
        <!-- <el-table-column prop="num" label="书籍销量" width="100">
        </el-table-column> -->
        <el-table-column prop="image" label="商品图片" show-overflow-tooltip>
          <div class="demo-image__preview">
            <el-image 
              style="width: 100px; height: 100px"
              :src="url" 
              :preview-src-list="srcList">
            </el-image>
          </div>

          <!-- <a href="../../assets/img/upload/">
            <img src="" alt="图片" width="100px" height="100px">
          </a> -->
        </el-table-column>
        <!-- <el-table-column
          prop="sellPoint"
          label="商品卖点"
          width="160"
          show-overflow-tooltip
        >
        </el-table-column> -->
        <el-table-column prop="content" label="商品描述" show-overflow-tooltip width="300">
        </el-table-column>
        
        <el-table-column label="操作" width="360">
          <template slot-scope="scope">
            <el-button
              class="btn"
              size="mini" 
              @click="lookBook(scope.$index, scope.row)"
              >
              查看</el-button>
            <el-button
              class="button01"
              type="primary"
              size="mini"
              @click="handleEdit(scope.$index, scope.row)"
            >
              编辑</el-button
            >
            <el-button
            class="button02"
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)"
              icon="el-icon-delete"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>
  <!-- 全选 -- 反选 -- 批量删除 -->
  <div class="bottom">
    <el-button type='primary' size='small' id="select" @click="SelectAll()">全选</el-button>
    <el-button type='primary' size='small'>反选</el-button>
    <el-button type='primary' size='small'>批量删除</el-button>
  </div>
    <!-- 3. 分页 -->
    <MyPagination
      :total="total"
      :pageSize="pageSize"
      @changePage="changePage"
      :currentPage="currentPage"
    />

    <!-- 4. 显示弹框组件 操作子组件：1. 父传子 2. children   3. ref  -->
    <!-- <GoodsDialog :dialogVisible='dialogVisible'  @changeDialog='changeDialog'/> -->
    <GoodsDialog ref="dialog" :title="title" :rowData='rowData' />
    <LookGood ref="lookGood" :title="title" :rowData="rowData" />
  </div>
</template>

<script>
import MyPagination from "../../components/MyPagination.vue";
import GoodsDialog from "./GoodsDialog.vue";
import LookGood from './LookGood.vue'
import axios  from 'axios'
export default {
  components: {
    MyPagination,
    GoodsDialog,
    LookGood,
  },
  data() {
    return {
      tableData:[],
      //所有书籍内容
      books: {},
      book:"",
      row:{},
      total: 10,
      pageSize: 1,
      type: 1,
      list: [],
      dialogVisible: false,
      currentPage: 1, //选中的高亮页码
      title:'添加商品',
      rowData:{},//当前行的数据对象
      input:"",
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      srcList: [
          'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
          'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
      ],
    }
  },
  mounted() {
    // 调用后端接口，并将返回的数据赋值给books
    axios.get('/api/getBooks')
      .then(res => {
        // console.log(res)
        this.books = res.data;
        // console.log(res.data);
        console.log(this.books);
  
        //获取'}'出现的次数
        var index = this.books.indexOf('}')
        var num = 0;
        var tempNum = 0;
        while(index !== -1){
          this.book = this.books.slice(tempNum+1,index+1);
          num++;
          //商品行号
          this.row[num-1] = num;
          // console.log(this.row);
          index = this.books.indexOf('}',index + 1);
        }
        //console.log('}出现的次数:' + num);

        //获取'}'出现的位置及次数，用于确定分割数组里面内容的位置
        index = this.books.indexOf('}');
        var tempNum = 0;
        var i = 0;
        while(index !== -1){
          // 获取书籍信息
          if ( i == 0) {
            this.book = this.books.slice(tempNum+1,index+2);
          } else if ( i>0 & i<num-1 ) {
            this.book = this.books.slice(tempNum+2,index+2);
          } else if ( i == num-1 ) {
            this.book = this.books.slice(tempNum+2,index+1);
          }

          //处理图片问题
          // var path = this.book.imageUrl;
          // console.log("path:", path);
          // var name = path.substring(path.lastIndexOf("\\") + 1);
          // this.url[i] = path.substring(0, path.lastIndexOf("\\") + 1)
          // .replace("../../assets/img/upload", "upload") + encodeURI*(name);
          
          // console.log(this.book);
          // console.log(index);
          i++;
          tempNum = index+1;
          index = this.books.indexOf('}',index + 1);       

          this.http(1);
        }
      });
  },
  methods: {
    /**
     * 添加商品--出现弹框
     */
    addGoods() {
      // this.dialogVisible = true;
      //修改子组件实例的数据
      this.$refs.dialog.dialogVisible = true;
      this.title ='添加商品';
    },
    changeDialog() {
      this.dialogVisible = false;
    },
    /**
     * 分页页码--------------------
     */
    changePage(num) {
      this.currentPage = num;
      if (this.type == 1) {
        this.http(num); //商品列表分页
      } else {
        //搜索分页 1 2 3 4 --  list=[0,1,2,3,4,5,6,7,8]  0-3  3-6  6-9 9-12
        console.log("搜索的分页处理---");
        //（num-1）*3  num*3
        this.tableData = this.list.slice((num - 1) * 3, num * 3);
      }
    },
    /**
      搜索查询数据-----------------------
     */
    searchInp(val) {
      if (!val) {
        this.http(1);
        this.currentPage = 1;
        this.type = 1;
        return;
      }
      console.log("val:", val);
      //请求接口----
      axios({
        methods: 'GET',
        url: '/api/searchBook',
        headers: {
          "Content-Type": "multipart/form-data",
        },
        params:{
          // id: val,
          name: val,
          // author: val,
        }
      }).then((res) => {
          // console.log("搜索---", res.data);
          console.log("res", res);
          this.books = res.data;
          console.log("this.books:", this.books);
          this.currentPage = 1;
          // if (res.data.status === 200) {
          if (this.books.id !== 0) {
            this.list = res.data.result; //获取的搜索的总数据条数---数据分割
            //假设需要分页---我们处理分页----
            // this.total = res.data.result.length;
            this.pageSize = 3;
            // this.books = res.data.result.slice(0, 3);
            this.type = 2;
            console.log("分页", this.currentPage);
          } else {
            this.books = {};
            this.tableData = [];
            this.total = 1;
            this.pageSize = 1;
            this.type = 1;
          }
          // this.searchHttp();
        });
    },
    /**
     * 查询操作更新视窗
     */ 
    searchHttp() {
      this.$router.go(0);
    },
    /**
     * 查看操作
     */
    lookBook(index, row) {
      this.$refs.lookGood.dialogVisible = true;
      this.title ='查看商品';
      this.rowData = {...row};
      console.log(this.rowData);
    },
    /**
     * 编辑操作
     */
    handleEdit(index,row) {//row={}
      //1. 点击编辑按钮 显示弹框  2. 弹框上回显数据展示 -当前的行的数据 
      this.$refs.dialog.dialogVisible = true;
      this.title ='编辑商品';
      this.rowData = {...row};
      console.log(this.rowData);
      // this.$refs.dialog.goodsForm = row;//方法1：
    },
    /**
     * 删除操作
     */
     handleDelete(index, row) {
      console.log("删除", index, row);
      this.$confirm("此操作将永久删除该商品, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          //请求接口----
            axios({
            methods: 'POST',
            url: '/api/deleteBook',
            headers: {
              "Content-Type": "multipart/form-data",
            },
            params:{
              id: row.id
            }
          })
          //视图更新
          location.reload();
          // this.http(1);
          this.$message({
            type: "success",
            message: "删除成功!",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
      },
    /**
     * 商品列表获取
     */
    http(page) {
      axios.get('/api/getBooks')
      .then(res => {
        // console.log(res)
        this.books = res.data;
        // console.log(res.data);
        console.log(this.books);
  
        //获取'}'出现的次数
        var index = this.books.indexOf('}')
        var num = 0;
        var tempNum = 0;
        while(index !== -1){
          this.book = this.books.slice(tempNum+1,index+1);
          num++;
          //商品行号
          this.row[num-1] = num;
          // console.log(this.row);
          index = this.books.indexOf('}',index + 1);
        }
        //console.log('}出现的次数:' + num);

        //获取'}'出现的位置及次数，用于确定分割数组里面内容的位置
        index = this.books.indexOf('}')
        var tempNum = 0;
        var i = 0;
        while(index !== -1){
          // 获取书籍信息
          if ( i == 0) {
            this.book = this.books.slice(tempNum+1,index+2);
          } else if ( i>0 & i<num-1 ) {
            this.book = this.books.slice(tempNum+2,index+2);
          } else if ( i == num-1 ) {
            this.book = this.books.slice(tempNum+2,index+1);
          }
          
          // console.log(this.book);
          // console.log(index);
          i++;
          tempNum = index+1;
          index = this.books.indexOf('}',index + 1);
        }

        this.tableData = res.data.data; //数据列表
        this.total = res.data.total;
        this.pageSize = res.data.pageSize;
        this.dialogVisible = true;
      });

      // this.$api
      //   .getGoodsList({
      //     page,
      //   })
      //   .then((res) => {
      //     console.log(res.data);
      //     if (res.data.status === 200) {
      //       this.tableData = res.data.data; //数据列表
      //       this.total = res.data.total;
      //       this.pageSize = res.data.pageSize;
      //       this.dialogVisible = true;
      //     }
      //   });
    },
    /**
     * 全选按钮
     */
    SelectAll() {
      document.getElementById('select').click();
    },

  },
  //生命周期函数
  created() {
    this.http(1);
  },
}


// import MyPagination from "../../components/MyPagination.vue";
// import GoodsDialog from "./GoodsDialog.vue";
// export default {
//   components: {
//     MyPagination,
//     GoodsDialog,
//   },
//   data() {
//     return {
//       input: "",
//       tableData: [
//         // {
//         //   id: '01',
//         //   title: 'Book1',
//         //   price: 12.34,
//         //   num: 1518,
//         //   category: '书籍',
//         //   image: 'NULL',
//         //   sellPoint: 'HOT!',
//         //   content: 'Good Book'
//         // }
//       ],
//       total: 10,
//       pageSize: 1,
//       type: 1,
//       list: [],
//       dialogVisible: false,
//       currentPage: 1, //选中的高亮页码
//       title:'添加商品',
//       rowData:{},//当前行的数据对象 
//     };
//   },
//   methods: {
//     /**
//      * 添加商品--出现弹框
//      */
//     addGoods() {
//       // this.dialogVisible = true;
//       //修改子组件实例的数据
//       this.$refs.dialog.dialogVisible = true;
//       this.title ='添加商品'
//     },
//     changeDialog() {
//       this.dialogVisible = false;
//     },
//     /**
//      * 分页页码--------------------
//      */
//     changePage(num) {
//       this.currentPage = num;
//       if (this.type == 1) {
//         this.http(num); //商品列表分页
//       } else {
//         //搜索分页 1 2 3 4 --  list=[0,1,2,3,4,5,6,7,8]  0-3  3-6  6-9 9-12
//         console.log("搜索的分页处理---");
//         //（num-1）*3  num*3
//         this.tableData = this.list.slice((num - 1) * 3, num * 3);
//       }
//     },
//     /**
//       搜索查询数据-----------------------
//      */
//     searchInp(val) {
//       if (!val) {
//         this.http(1);
//         this.currentPage = 1;
//         this.type = 1;
//         return;
//       }
//       this.$api
//         .getSearch({
//           search: val,
//         })
//         .then((res) => {
//           console.log("搜索---", res.data);
//           this.currentPage = 1;
//           if (res.data.status === 200) {
//             this.list = res.data.result; //获取的搜索的总数据条数---数据分割
//             //假设需要分页---我们处理分页----
//             this.total = res.data.result.length;
//             this.pageSize = 3;
//             this.tableData = res.data.result.slice(0, 3);
//             this.type = 2;
//             console.log("分页", this.currentPage);
//           } else {
//             this.tableData = [];
//             this.total = 1;
//             this.pageSize = 1;
//             this.type = 1;
//           }
//         });
//     },
//     /**
//      * 编辑操作
//      */
//     handleEdit(index,row) {//row={}
//       //1. 点击编辑按钮 显示弹框  2. 弹框上回显数据展示 -当前的行的数据 
//       this.$refs.dialog.dialogVisible = true;
//       this.title ='编辑商品';
//       this.rowData = {...row};
//       // this.$refs.dialog.goodsForm = row;//方法1：
  
//     },
//     /**
//      * 删除操作
//      */
//     handleDelete(index, row) {
//       console.log("删除", index, row);
//       this.$confirm("此操作将永久删除该商品, 是否继续?", "提示", {
//         confirmButtonText: "确定",
//         cancelButtonText: "取消",
//         type: "warning",
//       })
//         .then(() => {
//           //请求接口----
//           this.$api
//             .deleteGoods({
//               id: row.id,
//             })
//             .then((res) => {
//               console.log("删除", res.data);
//               if (res.data.status === 200) {
//                 this.$message({
//                   type: "success",
//                   message: "删除成功!",
//                 });
//                 //视图更新
//                 this.http(1);
//               }
//             });
//         })
//         .catch(() => {
//           this.$message({
//             type: "info",
//             message: "已取消删除",
//           });
//         });
//     },
//     /**
//      * 商品列表获取
//      */
//     http(page) {
//       this.$api
//         .getGoodsList({
//           page,
//         })
//         .then((res) => {
//           console.log(res.data);
//           if (res.data.status === 200) {
//             this.tableData = res.data.data; //数据列表
//             this.total = res.data.total;
//             this.pageSize = res.data.pageSize;
//             this.dialogVisible = true;
//           }
//         });
//     },
//   },
//   //生命周期函数
//   created() {
//     this.http(1);
//   },
// };
</script>

<style lang='less' scoped>
.goods {
  margin: 20px;
}
.header {
  display: flex;
  button {
    margin-left: 20px;
  }
}
.wrapper {
  margin: 20px 0;
}


//按钮样式
//1.
.button01 {
  padding: 0.8em 1.6em;
  font-size: 18px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 500;
  color: #000;
  background-color: #fff;
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
}

.button01:hover {
  background-color: #23c483;
  box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
  color: #fff;
  transform: translateY(-7px);
}

.button01:active {
  transform: translateY(-1px);
}

//2.
.main {
  display: flex;
  align-items: center;
  justify-content: center;
}

.btn {
  width: 100px;
  height: 40px;
  font-size: 18px;
  background: #fff;
  border: none;
  border-radius: 50px;
  color: #000;
  outline: none;
  cursor: pointer;
  transition: all 0.4s;
}

.btn:hover {
  box-shadow: inset 0 0 0 4px #ef476f, 
              inset 0 0 0 8px #ffd166, 
              inset 0 0 0 12px #06d6a0,
              inset 0 0 0 16px #118ab2;
  background: #073b4c;
  color: #fff;
}

//3.
.button02 {
  border: 1px solid black;
  padding: 12px 20px 12px 20px;
  border-radius: 30px;
  // background-color: #fdceb6;
  // background-color:#118ab2;
  background-color:#ef476f;
  font-weight: bolder;
  font-size: 15px;
  box-shadow: 0px 0px 1px;
  transform: all 2s esase;
  transition-duration: .3s;
}

.button02:hover {
  transform: translateY(-10px);
  box-shadow: 0px 7px 1px rgb(0, 0, 0);
  border: 1px solid black;
}

.button02:active {
  transform: translateY(10px);
  box-shadow: 0px 0px 1px;
}

//4.
.button03 {
  display: inline-block;
  padding: 12px 24px;
  font-size: 16px;
  font-weight: bold;
  text-transform: uppercase;
  text-align: center;
  color: #fff;
  background-color: #00ccff;
  border: none;
  border-radius: 50px;
  transition: background-color 0.3s ease, transform 0.2s ease;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
  cursor: pointer;
  position: relative;
  overflow: hidden;
  z-index: 1;
}

.button03::before {
  content: "";
  position: absolute;
  top: -50%;
  left: -50%;
  width: 200%;
  height: 200%;
  background-color: #57575700;
  border-radius: 50%;
  transform: translate(-50%, -50%);
  transition: all 0.4s ease;
  z-index: -1;
}

.button03::after {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: linear-gradient(45deg, rgba(255, 255, 255, 0.2) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.2) 50%, rgba(255, 255, 255, 0.2) 75%, transparent 75%, transparent);
  background-size: 30px 30px;
  opacity: 0;
  transition: opacity 0.4s ease;
}

.button03:hover {
  background-color: #239ccc;
  transform: scale(1.1) rotate(5deg);
  box-shadow: 0 8px 12px rgba(0, 0, 0, 0.3);
}

.button03:hover::before {
  top: 50%;
  left: 50%;
  width: 100%;
  height: 100%;
  transform: translate(-50%, -50%) rotate(45deg);
}

.button03:hover::after {
  opacity: 1;
}

.button03:active {
  background-color: rgb(13, 130, 207);
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
  transform: translateY(2px);
}

//5.
.button04 {
 color: #ecf0f1;
 font-size: 16px;
 background-color: #e67e22;
 border: 1px solid #f39c12;
 border-radius: 5px;
 padding: 10px;
 box-shadow: 0px 6px 0px #d35400;
 transition: all .1s;
}

.button04:active {
 box-shadow: 0px 2px 0px #d35400;
 position: relative;
 top: 2px;
}

//6.
.Btn01 {
  position: relative;
  width: 120px;
  height: 40px;
  border-radius: 45px;
  border: none;
  background-color: rgb(151, 95, 255);
  color: white;
  box-shadow: 0px 10px 10px rgb(210, 187, 253) inset,
  0px 5px 10px rgba(5, 5, 5, 0.212),
  0px -10px 10px rgb(124, 54, 255) inset;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
}

.Btn01::before {
  width: 70%;
  height: 2px;
  position: absolute;
  background-color: rgba(250, 250, 250, 0.678);
  content: "";
  filter: blur(1px);
  top: 7px;
  border-radius: 50%;
}

.Btn01::after {
  width: 70%;
  height: 2px;
  position: absolute;
  background-color: rgba(250, 250, 250, 0.137);
  content: "";
  filter: blur(1px);
  bottom: 7px;
  border-radius: 50%;
}

.Btn01:hover {
  animation: jello-horizontal 0.9s both;
}

@keyframes jello-horizontal {
  0% {
    transform: scale3d(1, 1, 1);
  }

  30% {
    transform: scale3d(1.25, 0.75, 1);
  }

  40% {
    transform: scale3d(0.75, 1.25, 1);
  }

  50% {
    transform: scale3d(1.15, 0.85, 1);
  }

  65% {
    transform: scale3d(0.95, 1.05, 1);
  }

  75% {
    transform: scale3d(1.05, 0.95, 1);
  }

  100% {
    transform: scale3d(1, 1, 1);
  }
}
</style>