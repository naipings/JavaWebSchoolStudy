<template>
    <div class="login">
        <h1
      style="
        text-align: center;
        color: aliceblue;
        font-size: 300%;
        font-family: 华文新魏;
      "
    >
      -- 欢迎访问网上书城 --
    </h1>
    <br /><br />

    <div class="con">
      <h2 style="margin-top: 5px; text-align: center">Login</h2>
      <table>
        <tr>
          <td>
            <center>
              <form method="post">
                <div class="T">user name</div>
                <div class="co">
                  <input type="text" name="user" value="Anna" prop="user"/>
                </div>
                <br /><br />
                <div class="T">password</div>
                <div class="co">
                  <input type="password" name="pass" value="123456" prop="pass"/>
                </div>
                <br /><br />
                <div class="T">code</div>
                <div class="co"><input type="text" name="code" prop="code"/></div>
                <img src="/api/code" />
                <span>
                  <a href="/api/register">注册账号</a>
                  <a href="/api/delete">注销账户</a>
                </span>
                <div class="go">
                  <input type="submit" value="Login" @click="isLogin()" />
                  <div class="L_" style="pointer-events: none">
                    <div class="l_"></div>
                    <div class="l_"></div>
                    <div class="l_"></div>
                  </div>
                </div>
              </form>
            </center>
          </td>
        </tr>
      </table>
    </div>
    </div>
</template>

<script>
export default {
data() {
  return {
    user,
    pass,
    code,
  }
},
methods: {
  isLogin() {
    console.log(this.user,this.pass,this.code)
    //请求接口----
    // axios({
    //   methods: 'POST',
    //   url: '/api/login',
    //   params:{
    //     user: this.user,
    //     pass: this.pass,
    //     code: this.code,
    //   }
    // })
  }
}


}
</script>

<style lang='less' scoped>
*{
    padding:0;
    margin:0;
   }

   body{
    background-image: url(../assets/img/loginback2.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    width:100%;
    height:745px;
    display:flex;
    justify-content: center;
    align-items: center;
   }

   h1 {
   position: absolute;
   top:3%;
   left:center;
    color:black;
    text-shadow: 0 1px 0 slateblue;
   }

   .con{
    position:relative;
    /* left:42%;
    top:30%; */
    width:360px;
    height:570px;
    background-image: linear-gradient(to right top,rgba(161,192,277,0.6),rgba(179,168,232,0.7),rgba(99,94,147,0.5),rgba(251,252,253,0.5));
   }
   .con::before{
    position:absolute;
    border:2px solid white;
    top:0;
    right:0;
    box-sizing: border-box;
    content:"";
    width:360px;
    height:570px;
    clip-path: inset(0 130px 250px 0);
    animation: ch 8s infinite;
   }
   @keyframes ch{
    0%,100%{
         clip-path: inset(0 0 368px 0);
    }
    25%{
        clip-path: inset(0 258px 0 0);
    }
    50%{
        clip-path: inset(368px 0 0 0);
    }
    75%{
        clip-path: inset(0 0 0 258px);
    }
   }
   .con form{
    width:75%;
    height:80%;
    margin:50px auto;
   }
   .con .T{
    width:100px;
    margin:22px auto 0;
    font-size: 19px;
    color:white;
    font-weight: 320;
    text-rendering: 0 1px 2px rgb(255,255,255);
   }
   .con .co input{
    width:100%;
    margin-top: 10px;
    font-size: 22px;
    border:none;
    outline:none;
    background-color: rgba(0,0,0,0);
    box-shadow: 0 2px 0 rgb(255,255,255);
    color:white;
   }
   .con h2{
    color:white;
    text-shadow: 0 1px 0 slateblue;
   }

   .con img {
    margin:10px 200px auto 0;
    position: relative;
    
   }

   .con span {
    float: right;
    margin: -50px auto;
    position: relative;
   }

   .con span a {
    color:aqua; /* 设置链接的颜色 */
    text-decoration: none; /* 去除下划线 */
    font-weight: bold; /* 设置链接字体为粗体 */
    font-size: 17px;
    font-family: 华文新魏;
   }

   .con span a:hover {
    color:pink;
    font-weight: bold;
    font-family: 方正舒体;
    /* text-decoration: underline;*/ /*鼠标悬停时添加下划线 */
  }

   .go{
    width:100px;
    margin:30px auto;
    position:relative;
   }
   .go input{
    width:100px;
    margin:auto;
    font-size:22px;
    border:none;
    outline:none;
    background-color: rgba(0,0,0,0);
    color:white;
    font-weight:bolder;
   }
   .L_{
    position:absolute;
    width:85px;
    height:85px;
    border-radius: 50%;
    top:-25px;
   }
   .l_{
    position:absolute;
    width:100%;
    height:100%;
    border-radius: 50%;
   }
   .l_:nth-of-type(1){
    border-bottom:6px solid rgb(101,167,202);
    transform:rotatex(35deg) rotatey(-45deg);
    animation:one 1.5s linear infinite;
   }
   .l_:nth-of-type(2){
    border-right:6px solid rgb( 152,140,221);
    transform:rotatex(50deg) rotatey(10deg);
    animation:two 1.5s linear infinite;
   }
   .l_:nth-of-type(3){
    border-top:6px solid rgb(255,255,255);
    transform:rotatex(35deg) rotatey(55deg);
    animation:three 1.5s linear infinite;
   }
   @keyframes one{
    to{
        transform:rotatex(35deg) rotatey(-45deg) rotatez(360deg);
    }
   }
   @keyframes two{
    to{
        transform:rotatex(50deg) rotatey(10deg) rotatez(360deg);
    }
   }
   @keyframes three{
    to{
        transform:rotatex(35deg) rotatey(55deg) rotatez(360deg);
    }
   }
   .go:hover .l_{
    transform: none;
   }
   .go:hover input{
    text-shadow: 0 2px 3px rgb(255,255,255);
   }

</style>