<template>
    <div class="wrapper">
      <!-- <div
        class="sidebar"
        data-color="purple"
        data-image="../assets/img/sidebar-5.jpg"
      >
        <div class="sidebar-wrapper">
          <div class="logo">
            <div class="simple-text">网上书城</div>
          </div>

          <ul class="nav">
            <li>
              <a href="./dashboard.html">
                <i class="pe-7s-graph"></i>
                <p>主页</p>
              </a>
            </li>
            <li class="active">
              <a href="./user.html">
                <i class="pe-7s-user"></i>
                <p>个人界面</p>
              </a>
            </li>
            <li>
              <a href="./table.html">
                <i class="pe-7s-note2"></i>
                <p>购物车</p>
              </a>
            </li>
            <li>
              <a href="./typography.html">
                <i class="pe-7s-news-paper"></i>
                <p>设置</p>
              </a>
            </li>
          </ul>
        </div>
      </div> -->      
        <nav class="navbar navbar-fixed" style="width: 100%;">
          <div style="float:right; padding-right: 10%;">
            <div class="loader">
            <svg height="0" width="0" viewBox="0 0 64 64" class="absolute">
              <defs class="s-xJBuHA073rTt" xmlns="http://www.w3.org/2000/svg">
                <linearGradient class="s-xJBuHA073rTt" gradientUnits="userSpaceOnUse" y2="2" x2="0" y1="62" x1="0" id="b">
                  <stop class="s-xJBuHA073rTt" stop-color="#973BED"></stop>
                  <stop class="s-xJBuHA073rTt" stop-color="#007CFF" offset="1"></stop>
                </linearGradient>
                <linearGradient class="s-xJBuHA073rTt" gradientUnits="userSpaceOnUse" y2="0" x2="0" y1="64" x1="0" id="c">
                  <stop class="s-xJBuHA073rTt" stop-color="#FFC800"></stop>
                  <stop class="s-xJBuHA073rTt" stop-color="#F0F" offset="1"></stop>
                  <animateTransform repeatCount="indefinite" keySplines=".42,0,.58,1;.42,0,.58,1;.42,0,.58,1;.42,0,.58,1;.42,0,.58,1;.42,0,.58,1;.42,0,.58,1;.42,0,.58,1" keyTimes="0; 0.125; 0.25; 0.375; 0.5; 0.625; 0.75; 0.875; 1" dur="8s" values="0 32 32;-270 32 32;-270 32 32;-540 32 32;-540 32 32;-810 32 32;-810 32 32;-1080 32 32;-1080 32 32" type="rotate" attributeName="gradientTransform"></animateTransform>
                </linearGradient>
                <linearGradient class="s-xJBuHA073rTt" gradientUnits="userSpaceOnUse" y2="2" x2="0" y1="62" x1="0" id="d">
                  <stop class="s-xJBuHA073rTt" stop-color="#00E0ED"></stop>
                  <stop class="s-xJBuHA073rTt" stop-color="#00DA72" offset="1"></stop>
                </linearGradient>
              </defs>
            </svg>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 64 64" height="64" width="64" class="inline-block">
              <path stroke-linejoin="round" stroke-linecap="round" stroke-width="8" stroke="url(#b)" d="M 54.722656,3.9726563 A 2.0002,2.0002 0 0 0 54.941406,4 h 5.007813 C 58.955121,17.046124 49.099667,27.677057 36.121094,29.580078 a 2.0002,2.0002 0 0 0 -1.708985,1.978516 V 60 H 29.587891 V 31.558594 A 2.0002,2.0002 0 0 0 27.878906,29.580078 C 14.900333,27.677057 5.0448787,17.046124 4.0507812,4 H 9.28125 c 1.231666,11.63657 10.984383,20.554048 22.6875,20.734375 a 2.0002,2.0002 0 0 0 0.02344,0 c 11.806958,0.04283 21.70649,-9.003371 22.730469,-20.7617187 z" class="dash" id="y" pathLength="360"></path>
            </svg>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" style="--rotation-duration:0ms; --rotation-direction:normal;" viewBox="0 0 64 64" height="64" width="64" class="inline-block">
              <path stroke-linejoin="round" stroke-linecap="round" stroke-width="10" stroke="url(#c)" d="M 32 32
                  m 0 -27
                  a 27 27 0 1 1 0 54
                  a 27 27 0 1 1 0 -54" class="spin" id="o" pathLength="360"></path>
            </svg>
            <div class="w-2"></div>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" style="--rotation-duration:0ms; --rotation-direction:normal;" viewBox="0 0 64 64" height="64" width="64" class="inline-block">
              <path stroke-linejoin="round" stroke-linecap="round" stroke-width="8" stroke="url(#d)" d="M 4,4 h 4.6230469 v 25.919922 c -0.00276,11.916203 9.8364941,21.550422 21.7500001,21.296875 11.616666,-0.240651 21.014356,-9.63894 21.253906,-21.25586 a 2.0002,2.0002 0 0 0 0,-0.04102 V 4 H 56.25 v 25.919922 c 0,14.33873 -11.581192,25.919922 -25.919922,25.919922 a 2.0002,2.0002 0 0 0 -0.0293,0 C 15.812309,56.052941 3.998433,44.409961 4,29.919922 Z" class="dash" id="u" pathLength="360"></path>
            </svg>
          </div>
        </div>



          <div class="container-fluid">

            <!-- <div class="navbar-header">
              <a class="navbar-brand" href="https://10.69.34.196:8081/user">User Center</a>
            </div> -->

            <div class="collapse navbar-collapse">
              <!-- <ul class="nav navbar-nav navbar-left">
                <li>
                  <a href="">
                    <i class="fa fa-search"></i>
                    <p class="hidden-lg hidden-md">Search</p>
                  </a>
                </li>
              </ul> -->

              <ul class="nav navbar-nav navbar-right ul01">
                <li>
                  <a href="http://127.0.0.1:8080/demo1/registerUserData.html">
                    <!-- <p>完善个人信息</p> -->
                    <button class="button01">完善个人信息
                      <div class="star-1">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                      </div>
                      <div class="star-2">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                      </div>
                      <div class="star-3">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                      </div>
                      <div class="star-4">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                      </div>
                      <div class="star-5">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                      </div>
                      <div class="star-6">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                      </div>
                    </button>
                  </a>
                </li>
                <li>
                  <a href="http://127.0.0.1:8080/demo1/logout">
                    <button class="Btn" onclick="http://127.0.0.1:8080/demo1/logout">
                      <div class="sign"><svg viewBox="0 0 512 512"><path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></path></svg></div>
                      <div class="text">退出登录</div>
                    </button>
                  </a>
                </li>
                <li class="separator hidden-lg"></li>
              </ul>
            </div>
          </div>
        </nav>
        <div class="main-panel">
        <div class="content">
          <div class="container-fluid">
            <div class="row">
              <div class="col-md-8">
                <div class="card" style="background-color: black;">
                  <div class="header">
                    <h4 class="title" style="color:#FFE699; font-weight: bold; font-size: 20px;">个人中心</h4>
                  </div>
                  <div class="content">
                    <form method="post">
                      <div class="row">
                        <div class="col-md-3" >
                          <div class="form__group field">
                            <input type="text" placeholder="Nickname" class="form__field" v-model="userInfo.nickname">
                            <label class="form__label">昵称</label>
                          </div>

                          <!-- <div class="form-group" >
                            <label class="label01">昵称</label>
                            <input
                              type="text"
                              class="form-control"
                              placeholder="Nickname"
                              id="nickname"
                              v-model="userInfo.nickname"
                            />
                          </div> -->
                        </div>
                        <div class="col-md-4">
                          <div class="form__group field" style="max-width: 200px;">
                            <input type="email" placeholder="email" class="form__field" v-model="userInfo.email">
                            <label class="form__label" for="exampleInputEmail1">邮箱</label>
                          </div>

                          <!-- <div class="form-group">
                            <label for="exampleInputEmail1" class="label01">邮箱</label>
                            <input
                              type="email"
                              class="form-control"
                              placeholder="email"
                              id="email"
                              v-model="userInfo.email"
                            />
                          </div> -->
                        </div>
                        <div class="col-md-4">
                          <div class="form__group field" style="margin-left: 10px;">
                            <input type="text" placeholder="phone" class="form__field" v-model="userInfo.phone">
                            <label class="form__label">电话</label>
                          </div>

                          <!-- <div class="form-group">
                            <label class="label01">电话</label>
                            <input
                              type="text"
                              class="form-control"
                              placeholder="phone"
                              id="phone"
                              v-model="userInfo.phone"
                            />
                          </div> -->
                        </div>
                      </div>
                      <br>
                      <div class="row">
                        <div class="col-md-6">
                          <div class="form__group field">
                            <input type="text" placeholder="FirstName" class="form__field" v-model="userInfo.firstName">
                            <label class="form__label">姓氏</label>
                          </div>

                          <!-- <div class="form-group">
                            <label>姓氏</label>
                            <input
                              type="text"
                              class="form-control"
                              placeholder="FirstName"
                              id="FirstName"
                              v-model="userInfo.firstName"
                            />
                          </div> -->
                        </div>
                        <div class="col-md-6">
                          <div class="form__group field">
                            <input type="text" placeholder="LastName" class="form__field" v-model="userInfo.lastName">
                            <label class="form__label">名字</label>
                          </div>

                          <!-- <div class="form-group">
                            <label>名字</label>
                            <input
                              type="text"
                              class="form-control"
                              placeholder="LastName"
                              v-model="userInfo.lastName"
                            />
                          </div> -->
                        </div>
                      </div>

                      <div class="row" style="position: relative;">
                        <div class="col-md-12">
                          <div class="form__group_address field">
                            <input type="text" placeholder="address" class="form__field" v-model="userInfo.address">
                            <label class="form__label">地址</label>
                          </div>

                          <!-- <div class="form-group">
                            <label>地址</label>
                            <input
                              type="text"
                              class="form-control"
                              placeholder="address"
                              id="address"
                              v-model="userInfo.address"
                            />
                          </div> -->
                        </div>
                      </div>
                      <br>
                      <div class="row">
                        <div class="col-md-4">
                          <div class="form__group field">
                            <input type="text" placeholder="city" class="form__field" v-model="userInfo.city">
                            <label class="form__label">居住地</label>
                          </div>

                          <!-- <div class="form-group">
                            <label>居住地</label>
                            <input
                              type="text"
                              class="form-control"
                              placeholder="City"
                              id="city"
                              v-model="userInfo.city"
                            />
                          </div> -->
                        </div>
                        <div class="col-md-4">
                          <div class="form__group field">
                            <input type="text" placeholder="country" class="form__field" v-model="userInfo.country">
                            <label class="form__label">国家</label>
                          </div>

                          <!-- <div class="form-group">
                            <label>国家</label>
                            <input
                              type="text"
                              class="form-control"
                              placeholder="country"
                              id="country"
                              v-model="userInfo.country"
                            />
                          </div> -->
                        </div>
                        <div class="col-md-4">
                          <div class="form__group field">
                            <input type="number" placeholder="ZIP Code" class="form__field">
                            <label class="form__label">邮政编码</label>
                          </div>

                          <!-- <div class="form-group">
                            <label>邮政编码</label>
                            <input
                              type="number"
                              class="form-control"
                              placeholder="ZIP Code"
                            />
                          </div> -->
                        </div>
                      </div>
                      <br>
                      <div class="row">
                        <div class="col-md-12">
                          <div class="form__group field">
                            <textarea
                              rows="5"
                              class="form__field"
                              placeholder="Here can be your description"
                              value="Mike"
                              style="width: 300%; height: 100%;"
                            >
                            {{userInfo.introduce}}</textarea
                            >
                            <label class="form__label">关于我</label>
                          </div>

                          <!-- <div class="form-group" >
                            <label>关于我</label>
                            <textarea
                              rows="5"
                              class="form-control"
                              placeholder="Here can be your description"
                              value="Mike"
                              style="width: 300%; height: 100%;"
                            >
                            {{userInfo.introduce}}</textarea
                            >
                          </div> -->
                        </div>
                      </div>

                      <!-- <button
                        type="submit"
                        class="btn btn-info btn-fill "
                        style="display: block;padding-top: 10px; margin-top: 10px;"
                        formaction="/api/registerUserData"
                      >
                        Update Profile
                      </button> -->
                      <div class="clearfix"></div>
                    </form>
                  </div>
                </div>
              </div>
              <div class="col-md-4" style="position: absolute; ">
                <div class="card card-user">
                  <div class="image">
                    <img
                      src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400"
                      alt="..."
                    />
                  </div>
                  <div class="content">
                    <div class="author">
                      <a href="#">
                        <img
                          class="avatar border-gray"
                          src="../assets/img/faces/Default avatar.jpg"
                          alt="..."
                        />

                        <!-- <el-dialog
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
                        </el-dialog> -->
                      </a>

                        <h4 class="title">
                          {{userInfo.nickname}}<br />
                          <small>{{userInfo.nickname}}</small>
                        </h4>
                      
                    </div>
                    <p class="description text-center" style="font-size: 24px;">{{userInfo.introduce}}</p>
                  </div>
                  <hr />
                  <div class="text-center">
                    <button href="#" class="btn btn-simple">
                      <i class="fa fa-facebook-square"></i>
                    </button>
                    <button href="#" class="btn btn-simple">
                      <i class="fa fa-twitter"></i>
                    </button>
                    <button href="#" class="btn btn-simple">
                      <i class="fa fa-google-plus-square"></i>
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import axios  from 'axios'
export default {
  data() {
    return {
      userInfo: {},
      innerVisible: false, //内弹框
      innerVisibleImg: false, //图片弹框
    }
  },
  mounted() {
    // 调用后端接口，并将返回的数据赋值给userInfo
    axios.get('/api/userCenter')
      .then(res => {
        this.userInfo = res.data
        console.log(res);
        console.log(res.data);
      });
    console.log(this.userInfo);
  },
  methods: {
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
  }
}
</script>

<!-- <script src="../assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../assets/js/chartist.min.js"></script>
<script src="../assets/js/bootstrap-notify.js"></script> -->
<!-- <script
  type="text/javascript"
  src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"
></script> -->
<!-- <script src="../assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script> -->
<!-- <script src="../assets/js/demo.js"></script> -->
<!-- <script src="../assets/js/jquery/jquery.min.js"></script> -->

<style scoped>

    /* @import '../assets/css/bootstrap.min.css'; */
    /* @import 'https://github.com/naipings/bootstrap/blob/main/dist/js/bootstrap.min.js'; */
    
    @import '../assets/css/animate.min.css';
    @import '../assets/css/light-bootstrap-dashboard.css?v=1.4.0';
    @import '../assets/css/demo.css';
    @import '../assets/css/font-awesome.min.css';
    /* @import 'http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'; */
    /* @import 'https://fonts.googleapis.com/css?family=Roboto:400,700,300'; */
    @import '../assets/css/fonts-googleapis.css';
    @import '../assets/css/pe-icon-7-stroke.css';

    /* <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../assets/css/animate.min.css" rel="stylesheet" />
    <link
    href="../assets/css/light-bootstrap-dashboard.css?v=1.4.0"
    rel="stylesheet"
    />
    <link href="../assets/css/demo.css" rel="stylesheet" />
    <link
    href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
    rel="stylesheet"
    />
    <link
    href="http://fonts.googleapis.com/css?family=Roboto:400,700,300"
    rel="stylesheet"
    type="text/css"
    />
    <link href="../assets/css/pe-icon-7-stroke.css" rel="stylesheet" /> */

/* 上面那个you效果的css */
.absolute {
  position: absolute;
}

.inline-block {
  display: inline-block;
}

.loader {
  display: flex;
  margin: 0.25em 0;
}

.w-2 {
  width: 0.5em;
}

.dash {
  animation: dashArray 2s ease-in-out infinite,
    dashOffset 2s linear infinite;
}

.spin {
  animation: spinDashArray 2s ease-in-out infinite,
    spin 8s ease-in-out infinite,
    dashOffset 2s linear infinite;
  transform-origin: center;
}

@keyframes dashArray {
  0% {
    stroke-dasharray: 0 1 359 0;
  }

  50% {
    stroke-dasharray: 0 359 1 0;
  }

  100% {
    stroke-dasharray: 359 1 0 0;
  }
}

@keyframes spinDashArray {
  0% {
    stroke-dasharray: 270 90;
  }

  50% {
    stroke-dasharray: 0 360;
  }

  100% {
    stroke-dasharray: 270 90;
  }
}

@keyframes dashOffset {
  0% {
    stroke-dashoffset: 365;
  }

  100% {
    stroke-dashoffset: 5;
  }
}

@keyframes spin {
  0% {
    rotate: 0deg;
  }

  12.5%,
  25% {
    rotate: 270deg;
  }

  37.5%,
  50% {
    rotate: 540deg;
  }

  62.5%,
  75% {
    rotate: 810deg;
  }

  87.5%,
  100% {
    rotate: 1080deg;
  }
}

/* 按钮样式 */
/* 1. */
.Btn {
  display: flex;
  align-items: center;
  justify-content: flex-start;
  width: 45px;
  height: 45px;
  border: none;
  border-radius: 50%;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition-duration: .3s;
  box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.199);
  background-color: rgb(255, 65, 65);
  top: 10px
}

/* plus sign */
.sign {
  width: 100%;
  transition-duration: .3s;
  display: flex;
  align-items: center;
  justify-content: center;
}

.sign svg {
  width: 17px;
}

.sign svg path {
  fill: white;
}
/* text */
.text {
  position: absolute;
  right: 0%;
  width: 0%;
  opacity: 0;
  color: white;
  font-size: 1.2em;
  font-weight: 600;
  transition-duration: .3s;
}
/* hover effect on button width */
.Btn:hover {
  width: 125px;
  border-radius: 40px;
  transition-duration: .3s;
}

.Btn:hover .sign {
  width: 30%;
  transition-duration: .3s;
  padding-left: 5px;
  
}
/* hover effect button's text */
.Btn:hover .text {
  opacity: 1;
  width: 70%;
  transition-duration: .3s;
  padding-right: 10px;
}
/* button click effect*/
.Btn:active {
  transform: translate(2px ,2px);
}

/* 2. */
.button01 {
  position: relative;
  padding: 12px 35px;
  background: #FEC195;
  font-size: 17px;
  font-weight: 500;
  color: #181818;
  border: 3px solid #FEC195;
  border-radius: 8px;
  box-shadow: 0 0 0 #fec1958c;
  transition: all .3s ease-in-out;
  top: -22px;
  text-align: center;
}

.star-1 {
  position: absolute;
  top: 20%;
  left: 20%;
  width: 25px;
  height: auto;
  filter: drop-shadow(0 0 0 #fffdef);
  z-index: -5;
  transition: all 1s cubic-bezier(0.05, 0.83, 0.43, 0.96);
}

.star-2 {
  position: absolute;
  top: 45%;
  left: 45%;
  width: 15px;
  height: auto;
  filter: drop-shadow(0 0 0 #fffdef);
  z-index: -5;
  transition: all 1s cubic-bezier(0, 0.4, 0, 1.01);
}

.star-3 {
  position: absolute;
  top: 40%;
  left: 40%;
  width: 5px;
  height: auto;
  filter: drop-shadow(0 0 0 #fffdef);
  z-index: -5;
  transition: all 1s cubic-bezier(0, 0.4, 0, 1.01);
}

.star-4 {
  position: absolute;
  top: 20%;
  left: 40%;
  width: 8px;
  height: auto;
  filter: drop-shadow(0 0 0 #fffdef);
  z-index: -5;
  transition: all .8s cubic-bezier(0, 0.4, 0, 1.01);
}

.star-5 {
  position: absolute;
  top: 25%;
  left: 45%;
  width: 15px;
  height: auto;
  filter: drop-shadow(0 0 0 #fffdef);
  z-index: -5;
  transition: all .6s cubic-bezier(0, 0.4, 0, 1.01);
}

.star-6 {
  position: absolute;
  top: 5%;
  left: 50%;
  width: 5px;
  height: auto;
  filter: drop-shadow(0 0 0 #fffdef);
  z-index: -5;
  transition: all .8s ease;
}

.button01:hover {
  background: transparent;
  color: #FEC195;
  background-color: black;
  box-shadow: 0 0 25px #fec1958c;
}

.button01:hover .star-1 {
  position: absolute;
  top: -80%;
  left: -30%;
  width: 25px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

.button01:hover .star-2 {
  position: absolute;
  top: -25%;
  left: 10%;
  width: 15px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

.button01:hover .star-3 {
  position: absolute;
  top: 55%;
  left: 25%;
  width: 5px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

.button01:hover .star-4 {
  position: absolute;
  top: 30%;
  left: 80%;
  width: 8px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

.button01:hover .star-5 {
  position: absolute;
  top: 25%;
  left: 115%;
  width: 15px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

.button01:hover .star-6 {
  position: absolute;
  top: 5%;
  left: 60%;
  width: 5px;
  height: auto;
  filter: drop-shadow(0 0 10px #fffdef);
  z-index: 2;
}

.fil0 {
  fill: #FFFDEF
}


/* input框样式 */
/* 1. */
.form__group {
  position: relative;
  padding: 20px 0 0;
  padding-left: 20px;
  width: 100%;
  max-width: 180px;
}

.form__group_address {
  position: relative;
  padding: 20px 0 0;
  padding-left: 20px;
  width: 100%;
  max-width: 300px;
}

.form__field {
  font-family: inherit;
  width: 100%;
  border: none;
  border-bottom: 2px solid #6b6b6b;
  outline: 0;
  font-size: 17px;
  color: #fff;
  padding: 7px 0;
  background: transparent;
  transition: border-color 0.2s;
}

.form__field::placeholder {
  color: transparent;
}

.form__field:placeholder-shown ~ .form__label {
  font-size: 17px;
  cursor: text;
  top: 20px;
}

.form__label {
  position: absolute;
  top: 0;
  display: block;
  transition: 0.2s;
  font-size: 16px;
  color: #FFE699;
  pointer-events: none;
}

.form__field:focus {
  padding-bottom: 6px;
  font-weight: 700;
  border-width: 3px;
  border-image: linear-gradient(to right, #FFE699, #5D3294);
  border-image-slice: 1;
}

.form__field:focus ~ .form__label {
  position: absolute;
  top: 0;
  display: block;
  transition: 0.2s;
  font-size: 17px;
  color: #FFE699;
  font-weight: 700;
}

/* reset input */
.form__field:required, .form__field:invalid {
  box-shadow: none;
}

</style>