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
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
        >
          <!-- <el-form-item label="类目选择" prop="category">
            <el-button type="primary" @click="innerVisible = true"
              >类目选择</el-button
            >
            <span style="margin-left: 10px">{{ goodsForm.category }}</span>
          </el-form-item> -->
  
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
                <!-- <el-date-picker
                  type="date"
                  placeholder="选择日期"
                  v-model="goodsForm.date1"
                  style="width: 100%"
                ></el-date-picker> -->
              </el-form-item>
            </el-col>
            <el-col class="line" :span="2">-</el-col>
            <el-col :span="11">
              <el-form-item prop="date2">
                <!-- <el-time-picker
                  placeholder="选择时间"
                  v-model="goodsForm.date2"
                  style="width: 100%"
                ></el-time-picker> -->
              </el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item label="商品图片" prop="image">
            <img
              :src="goodsForm.image"
              height="200px"
              style="margin-left: 10px"
              alt=""
            />
          </el-form-item>
          <el-form-item label="商品描述" prop="content">
            <WangEditor ref="myEditor" @sendEditor="sendEditor" />
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>
  </template>
  


<script>
import TreeGoods from "./TreeGoods.vue";
import UploadImg from "./UploadImg.vue";
import WangEditor from "./WangEditor.vue";
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
        image: "",
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
      this.goodsForm.image = this.imgUrl;
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
        image: "",
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