<template>
    <div>
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
          <el-form-item label="类目隶属:" prop="category">
            <div>{{goodsForm.category}}</div>
          </el-form-item>
  
          <el-form-item label="商品名称:" prop="name">
            <div>{{goodsForm.name}}</div>
          </el-form-item>
          <el-form-item label="商品价格:" prop="price">
            <div>{{goodsForm.price}}</div>
          </el-form-item>
          <el-form-item label="书籍作者:" prop="author">
            <div>{{goodsForm.author}}</div>
          </el-form-item>
          <el-form-item label="商品数量:" prop="num">
            <div>{{goodsForm.num}}</div>
          </el-form-item>
          <el-form-item label="商品图片" prop="image">
            <img
              :src="goodsForm.imageurl"
              height="200px"
              style="margin-left: 10px"
              alt=""
            />
          </el-form-item>
          <el-form-item label="商品描述:" prop="content">
            <p name="content" id="" cols="100" rows="10" prop="content">{{goodsForm.content}}</p>
          </el-form-item>
        </el-form>
  
        <!-- 弹框底部区域 -->
        <span slot="footer" class="dialog-footer">
          <el-button @click="clearForm">取 消</el-button>
          <el-button type="primary" @click="submitForm">确 定</el-button>
        </span>
      </el-dialog>
    </div>
  </template>
  
  <script>
  import TreeGoods from "../Goods/TreeGoods.vue";
  import UploadImg from "../Goods/UploadImg.vue";
  import WangEditor from "../Goods/WangEditor.vue";
  export default {
  props: {
    title: {
      type: String,
      default: "查看商品",
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
        contnet: "",
        cid: "", //类目的id
        category: "", //商品类目
        date1: "", //商品时间
        date2: "", //商品时间
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
      this.goodsForm.contnet = val;
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
  </style>

  