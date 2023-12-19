<template>
  <div>
    <!-- 
            title="添加商品" 弹框的标题
            :visible.sync="dialogVisible" 控制弹框显示隐藏 boolean  true显示
            width="70%" 宽度 大小
       -->
    <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      width="70%"
      :before-close="clearForm"
    >
      <!-- 内容区域 -->
      <el-form
        :model="goodsForm"
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="类目选择" prop="category">
          <button class="button01" type="primary" @click="innerVisible = true">
            <svg class="layer" viewBox="0 0 734.93 1135.91">
              <defs></defs>
              <path class="cls-1" d="M1.25,0V1128.28c0,6.54,0,6.54,6.52,6.54H734.91c-.22.31.5,1-.5,1h-4q-362.83,0-725.67.09c-3.75,0-4.59-.84-4.59-4.59Q.32,567.92.37,4.52C.37,3-.83,1.11,1.25,0Z" transform="translate(-0.03)"></path>
              <path class="cls-2" d="M574.37,543.4C572.14,538,570,533,568,527.89c-1.14-3-2.79-4-6.06-3.28Q496.49,538.92,431,553.08a54.57,54.57,0,0,1-11.8,1.44c-32.76,0-65.53-.14-98.29.08-11.5.08-22.34-3.17-33.35-5.51q-56.28-12-112.46-24.4c-3.3-.72-5.2-.1-6.33,3.41-1.38,4.25-3.45,8.28-5.11,12.45-.86,2.15-1.56,3.07-3.65.89-4.83-5-9.93-9.84-14.8-14.84-2.73-2.8-3.53-6-2.52-10.07,3.57-14.17,7.83-28.17,9.67-42.76,1.11-8.78-.19-17.35-1.64-25.8-8.61-50.48-8.6-101.37-7.77-152.31.1-6.66.05-13.31.16-20a20.72,20.72,0,0,1,6.95-15.86c12.77-11.66,24.95-24,37.83-35.52,18.35-16.44,41-24.25,64.27-30.4,6.74-1.78,13.58-3.22,20.26-5.19,3.54-1,4.65.08,5.18,3.44,3.27,20.68,6.3,41.41,10.13,62,5,27.12,7.13,54.74,13.88,81.56a148.51,148.51,0,0,0,7.12,21.25c3.17,7.55,8.37,12.17,17,12.18,25,0,49.89.19,74.84.27,3.32,0,6.65-.09,10-.14,9.11-.15,14.71-4.94,18-13.21a179.88,179.88,0,0,0,10.88-40.85c5.45-38,12.37-75.77,18.43-113.68.55-3.44,1-6.9,1.56-10.35.3-2,.65-3.52,3.42-2.79,25.52,6.72,51.55,11.89,74.15,26.77,10.09,6.64,18.41,15.26,27.17,23.4,7.8,7.25,15.4,14.71,23.25,21.89a17.4,17.4,0,0,1,6.09,13.16c.47,49.06,3.21,98.17-4.15,147-2,13.3-3.43,26.7-5,40.07-1.52,12.87,2.26,25.06,5.18,37.33q2.31,9.7,4.82,19.36c.72,2.77.58,5.46-1.39,7.49C587,531.05,580.82,537,574.37,543.4Z" transform="translate(-0.03)"></path>
              <path class="cls-2" d="M278.88,806.78a13.6,13.6,0,0,0-9,9.92c-1.7,6.51-5.84,11.48-9.91,16.53-1,1.17-1.66,2-3.19.84C249.22,828.43,240.7,824,235,816c-3.43-4.85-6.24-10-6.45-16-1.18-33.61-15.46-62-34.05-89-19-27.67-37.83-55.51-54.92-84.45-6-10.12-10.47-20.73-12.25-32.42-.82-5.44.66-10.6,1.64-15.79,2.69-14.21,5.56-28.38,8.4-42.56a39.65,39.65,0,0,1,1.29-4l22.82,22.27c3.69,3.61,7.73,6.93,10.94,10.93,7.85,9.79,18.38,14,30.25,16.5,16.17,3.38,32.24,5.61,48.91,4.24,12.73-1,25.53-1.34,38.19-3.27a56,56,0,0,0,10.56-2.84,11.6,11.6,0,0,0,7.93-8.12c2.06-6.7,4.29-8.17,11.27-8.18q48.9-.09,97.8,0c7.09,0,9.08,1.33,11.11,8.2,1.92,6.5,7.11,8.44,12.63,9.86,8.39,2.15,17.07,2.71,25.65,3.52,27.51,2.6,54.76,1.93,81.27-7.19a22.34,22.34,0,0,0,8.78-5.37c12.67-12.5,25.46-24.88,38.13-37.38,2.6-2.57,3.75-3.23,4.59,1.31,2.62,14.22,5.58,28.38,8.53,42.53,3.43,16.49-1.25,31.21-9.45,45.27-14.92,25.58-31.53,50.07-47.88,74.74-10.54,15.92-22.09,31.24-30,48.82a138.26,138.26,0,0,0-12.27,50.08c-.51,10.61-5.56,18.68-13.21,25.31-4.38,3.79-9.41,6.83-14,10.34-1.92,1.45-3.22,1.76-4.86-.48-3.62-5-7.73-9.55-9.26-15.79A13.83,13.83,0,0,0,458.3,807c-1.67-1.43-3.68-1.3-5.68-1.3H283.53C281.91,805.67,280.16,805.28,278.88,806.78Z" transform="translate(-0.03)"></path>
              <path class="cls-2" d="M441.92,825.09c9.25,1.71,15.53,8,21.52,14.45,4.61,5,8.92,10.31,13.09,15.69,2,2.55,3.17,2.4,5.3.21,9.4-9.65,18.95-19.15,28.46-28.69,1.16-1.16,2.41-2.23,4.26-3.92,2.32,9.92,4.51,19.22,6.68,28.53,1.24,5.35,2.31,10.73,3.7,16,.85,3.22.35,5.56-2.25,8q-17.59,16.23-34.86,32.84c-2.58,2.47-4.79,2.5-7.39.41-6.87-5.51-14.19-10.55-20.53-16.62-8.62-8.25-18.83-11.37-30.29-11.9-4.48-.21-9-.93-13.42-.9-7.39,0-14.25-.91-19.23-7.16a2.31,2.31,0,0,0-.39-.31c-14.91-11.24-46.73-9.55-60.08,3.42-3.24,3.15-7,3.47-11,3.78-10.43.79-20.92.93-31.24,3a25,25,0,0,0-11.1,5.29c-8.81,7.08-17.72,14-26.51,21.14-3,2.4-5.14,2.34-8-.48q-16.67-16.14-33.83-31.75c-2.93-2.67-3.88-5.2-2.9-9.14,3.27-13.22,6.14-26.54,9.31-39.79.3-1.29,0-3.4,1.76-3.73,1.37-.25,2.1,1.42,3,2.34,9.58,9.71,19.21,19.37,28.64,29.22,2.48,2.6,3.89,2.54,6.12-.23,5.73-7.12,11.16-14.51,18-20.66,4.62-4.16,9.57-7.73,15.84-9,1.39-.84,2.92-.47,4.39-.47H437.46C439,824.66,440.51,824.38,441.92,825.09Z" transform="translate(-0.03)"></path><path class="cls-3" d="M278.88,806.78c.91-2.46,3-1.6,4.71-1.6q84.56-.07,169.09,0c1.92,0,4.49-1.16,5.59,1.78-3.13-.28-6.25-.81-9.38-.81q-79.8-.07-159.6,0C285.81,806.12,282.31,805.92,278.88,806.78Z" transform="translate(-0.03)"></path>
              <path class="cls-4" d="M441.92,825.09H294.58c2.79-1.57,5.79-1.07,8.79-1.07q65.43-.09,130.86,0C436.77,824,439.51,823.52,441.92,825.09Z" transform="translate(-0.03)"></path></svg>
            <p>类目选择</p>
          </button>
          <!-- <el-button type="primary" @click="innerVisible = true"
            >类目选择</el-button
          > -->
          <span style="margin-left: 10px">{{ goodsForm.category }}</span>
        </el-form-item>

        <el-form-item label="商品名称" prop="name">
          <el-input v-model="goodsForm.name"></el-input>
        </el-form-item>
        <el-form-item label="商品价格" prop="price">
          <el-input v-model="goodsForm.price"></el-input>
        </el-form-item>
        <el-form-item label="书籍作者" prop="author">
          <el-input v-model="goodsForm.author"></el-input>
        </el-form-item>
        <el-form-item label="商品数量" prop="num">
          <el-input v-model="goodsForm.num"></el-input>
        </el-form-item>
        <el-form-item label="发布时间" required>
          <el-col :span="11">
            <el-form-item prop="date1">
              <el-date-picker
                type="date"
                placeholder="选择日期"
                v-model="goodsForm.date1"
                style="width: 100%"
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-form-item prop="date2">
              <el-time-picker
                placeholder="选择时间"
                v-model="goodsForm.date2"
                style="width: 100%"
              ></el-time-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
        <!-- <el-form-item label="商品卖点" prop="sellPoint">
          <el-input v-model="goodsForm.sellPoint"></el-input>
        </el-form-item> -->
        <el-form-item label="商品图片" prop="imageurl">
          <el-button class="button02" type="primary" @click="innerVisibleImg = true">
            上传图片
          </el-button>
          <!-- <el-button type="primary" @click="innerVisibleImg = true"
            >上传图片</el-button
          > -->
          <img
            :src="goodsForm.imageurl"
            height="200px"
            style="margin-left: 10px"
            alt=""
          />
        </el-form-item>
        <el-form-item label="商品描述" prop="content">
          <textarea name="content" id="" cols="100" rows="10" prop="content" v-model="goodsForm.content"></textarea>
          <!-- <WangEditor name="content" prop="content" ref="myEditor" v-model="goodsForm.content" @sendEditor="sendEditor"/> -->
        </el-form-item>
      </el-form>

      <!-- 弹框底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="clearForm">取 消</el-button>
        <el-button type="primary" @click="submitForm">确 定</el-button>
      </span>

      <!-- 1. 内弹框--- 类目选择 -->
      <el-dialog
        width="40%"
        title="类目选择"
        :visible.sync="innerVisible"
        append-to-body
      >
        <TreeGoods @sendTreeData="sendTreeData" />
        <span slot="footer" class="dialog-footer">
          <el-button @click="innerVisible = false">取 消</el-button>
          <el-button type="primary" @click="showTreeData">确 定</el-button>
        </span>
      </el-dialog>

      <!-- 2. 内弹框 --- 上传图片 -->
      <el-dialog
        width="40%"
        title="上传图片"
        :visible.sync="innerVisibleImg"
        append-to-body
      >
        <UploadImg @sendImg="sendImg" ref="upload" />
        <span slot="footer" class="dialog-footer">
          <el-button @click="innerVisibleImg = false">取 消</el-button>
          <el-button type="primary" @click="showImg">确 定</el-button>
        </span>
      </el-dialog>
    </el-dialog>
  </div>
</template>

<script>
import TreeGoods from "./TreeGoods.vue";
import UploadImg from "./UploadImg.vue";
import WangEditor from "./WangEditor.vue";
import axios  from 'axios'
export default {
  props: {
    title: {
      type: String,
      default: "添加商品",
    },
    rowData: {
      type: Object,
      default: function () {
        return {};
      },
    },
  },
  components: {
    TreeGoods,
    UploadImg,
    WangEditor,
  },
  data() {
    return {
      dialogVisible: false, //外弹框
      innerVisible: false, //内弹框
      innerVisibleImg: false, //图片弹框
      treeData: {}, //接受tree数据
      imgUrl: "",
      goodsForm: {
        //表单容器-对象
        id: "",
        name: "", //商品名称
        price: "",
        num: "",
        author:"",
        sellPoint: "",
        imageurl: "",
        content: "",
        cid: "", //类目的id
        category: "", //商品类目
        date1: "", //商品时间
        date2: "", //商品时间
      },
      rules: {
        //校验规则
        title: [
          { required: true, message: "请输入商品名称", trigger: "blur" },
          { min: 2, max: 80, message: "长度在 2 到 8 个字符", trigger: "blur" },
        ],
        price: [{ required: true, message: "请输入价格", trigger: "blur" }],
        num: [{ required: true, message: "请输入数量", trigger: "blur" }],
        content: [{required: true, max: 200, message: "长度不超过200个字符", trigger: "blur"}],
      },
    };
  },
  //监听器---------
  watch: {
    rowData(val) {
      console.log("监听数据变化", val);
      this.goodsForm = val;
      //设置富文本编辑的数据内容
      this.$nextTick(() => {
        this.$refs.myEditor.editor.txt.html(val.content);
      });
    },
  },
  methods: {
    /**
     * 接受wangeditor数据
     */
    sendEditor(val) {
      this.goodsForm.content = val;
    },
    /**
     * 显示图片的地址
     */
    sendImg(val) {
      console.log("显示图片的地址", val);
      this.imgUrl = val;
    },
    /**
     * 显示图片--确定按钮
     */
    showImg() {
      this.innerVisibleImg = false;
      this.goodsForm.imageurl = this.imgUrl;
      //清空图片上传的列表
      this.$refs.upload.fileList = [];
    },
    /**
     * 显示tree数据
     */
    showTreeData() {
      this.innerVisible = false;
      //显示tree数据
      this.goodsForm.category = this.treeData.name;
      this.goodsForm.cid = this.treeData.cid;
    },
    /**
     * 获取tree数据
     */
    sendTreeData(val) {
      console.log("tree数据", val);
      this.treeData = val;
    },
    //自定义事件--通知父亲--修改dialogVisible
    close() {
      this.$emit("changeDialog");
    },
    submitForm() {
      this.$refs.ruleForm.validate((valid) => {
        if (valid) {
          console.log("获取输入的信息", this.goodsForm);
          //title cid  category sellPoint price num content paramsInfo imageurl
          let {
            name,
            cid,
            category,
            sellPoint,
            author,
            price,
            num,
            content,
            imageurl,
            id,
          } = this.goodsForm;
          //判断当前的确定按钮类型：
          if (this.title === "添加商品") {
            console.log("添加商品");

            axios({
              methods: 'POST',
              url: '/api/addBook',
              headers: {
                "Content-Type": "multipart/form-data",
              },
              params:{
                name: this.goodsForm.name, //商品名称
                price: this.goodsForm.price,
                author: this.goodsForm.author,
                num: this.goodsForm.num,
                // imageurl: this.imageurl,
                content: this.goodsForm.content,
                category: this.category, //商品类目
                date1: this.date1, //商品时间
                date2: this.date2, //商品时间
              }
            }).then((res) => {
                console.log("添加---实现---", res.data);
                  // if (res.data.status === 200) {
                  if (res.data.id !== 0) { 
                    //成功
                    this.$parent.http(1); //更新父组件列表数据
                    this.$message({
                      message: "恭喜你，添加商品成功",
                      type: "success",
                    });
                    //清空表单
                    this.clearForm();
                  }
                  else {
                    this.$message.error("错了哦，这是一条错误消息");
                  }
              });
      } else {
        console.log("编辑商品");

        axios({
              methods: 'POST',
              url: '/api/updateBook',
              headers: {
                "Content-Type": "multipart/form-data",
              },
              params:{
                id: this.goodsForm.id,
                name: this.goodsForm.name, //商品名称
                price: this.goodsForm.price,
                author: this.goodsForm.author,
                num: this.goodsForm.num,
                imageurl: this.imageurl,
                content: this.goodsForm.content,
                category: this.category, //商品类目
                date1: this.date1, //商品时间
                date2: this.date2, //商品时间
              }
            }).then((res) => {
                console.log(res.data);
                // if (res.data.status === 200) {
                if (res.data.id !== 0) { 
                  this.$parent.http(1); //更新父组件列表数据
                  this.$message({
                    message: "恭喜你，修改商品成功",
                    type: "success",
                  });
                  //清空表单
                  this.clearForm();
                } else {
                  //修改失败了--
                  this.$message({
                    message: "抱歉，修改商品失败",
                    type: "fail",
                  });
                }
              });
          }
        } 
        else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    /**
     * 清空表单数据列表
     */
    clearForm() {
      this.dialogVisible = false; //1.关闭弹框
      // 清空表单  1 使用element里面的重置表单  2 自己手动初始化goodsForm
      // this.$refs.ruleForm.resetFields();
      this.goodsForm = {
        name: "", //商品名称
        price: "",
        author: "",
        num: "",
        sellPoint: "",
        imageurl: "",
        content: "",
        cid: "", //类目的id
        category: "", //商品类目
        date1: "", //商品时间
        date2: "", //商品时间
      };
      //单独-清空编辑器内容--editor.txt.clear()
      this.$refs.myEditor.editor.txt.clear();
    },
  },
};
</script>

<style lang='less' scoped>
.line {
  text-align: center;
}

//按钮样式
//1.
.button01 {
  position: relative;
  width: 180px;
  height: 50px;
  border: none;
  background-color: rgb(231, 0, 0);
  display: flex;
  align-items: center;
  justify-content: center;
  overflow-y: hidden;
  border-radius: 0px;
  cursor: pointer;
  box-shadow: 8px 8px 0px rgb(12, 12, 12);
  transition-duration: .3s;
}

.layer {
  width: 60px;
  position: absolute;
  left: -30px;
  transition-duration: .3s;
  fill: #ffaf02;
}

.button01:hover {
  transform: translateY(5px);
  box-shadow: 3px 3px 0px rgb(0, 0, 0);
  transition-duration: .3s;
}

.button01:hover .layer {
  left: 0%;
  width: 100%;
  transition-duration: .3s;
}

.button01 p {
  color: white;
  font-weight: 600;
  font-size: 14px;
  position: absolute;
  z-index: 2;
  transition-duration: .1s;
  font-family: Whitney, -apple-system, BlinkMacSystemFont, Segoe UI, Roboto, Helvetica, Arial, sans-serif;
}

.button01:hover p {
  color: transparent;
  transition-duration: .3s;
}

//2.
.button02 {
  padding: 0.6em 0.9em;
  font-weight: 600;
  font-size: 14px;
  // background-color: transparent;
  background-color:  black;
  border: 0.2em solid;
  border-color: #00ffff #04ff00 #0051ff #d400ff;
  border-radius: 1.5em;
  color: #fff;
  cursor: pointer;
  transition: transform 0.2s ease, border-radius 0.2s ease, color 0.2s ease,
    border-shadow 0.2s ease, border-style 0.2s ease;
}

.button02:active {
}

.button02:hover {
  transform: scale(1.3);
  border-radius: 1.5em;
  animation: btn-animation 0.4s 0.2s linear infinite;
  color: #00ddff;
  background-color: black;
}

@keyframes btn-animation {
  0% {
    border-color: #00ffff #04ff00 #0051ff #d400ff;
    transform: rotate(5deg) scale(1.3);
  }

  25% {
    border-color: #d400ff #00ffff #04ff00 #0051ff;
    transform: rotate(-5deg) scale(1.3);
  }

  50% {
    border-color: #0051ff #d400ff #00ffff #04ff00;
    transform: rotate(5deg) scale(1.3);
  }

  75% {
    border-color: #04ff00 #0051ff #d400ff #00ffff;
    transform: rotate(-5deg) scale(1.3);
  }

  100% {
    border-color: #00ffff #04ff00 #0051ff #d400ff;
    transform: rotate(5deg) scale(1.3);
  }
}
</style>