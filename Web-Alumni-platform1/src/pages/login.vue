<template>
<div>
    <div class="regist_header clearfix">
        <div class="wrap">
            <a href="javascript:void(0);" class="logo">
                <img src="/static/img/logo.png" height="55" alt="校友平台" />
            </a>
            <div class="regist_header_right clearfix">
                <div class="help_wrap">
                    <a class="hd_menu" href="javascript:void(0);" @click="unSupportNow()">
                        <s class="help_ico"></s>
                        <span class="fonttype">帮助中心</span>
                    </a>
                </div>
                <span class="fr fonttype">您好，欢迎登陆中科大软院校友平台！</span>
            </div>
        </div>
    </div>
    <input type="hidden" id="isAutoLogin" value="0" />
    <input type="hidden" id="autoLoginFlag" value="1" />
    <input type="hidden" id="uuid">
    <div class="login_wrap">
        <div class="wrap clearfix">
            <div class="mod_login_wrap">
                <div class="login_pc">
                    <p id="error_tips" class="error_tips fonttype" v-bind:style="error_input">{{error_input_msg}}</p>
                    <div class="clearfix">
                        <h3>软院校友用户登录</h3>
                        <a href="javascript:void(0);" class="regist_new blue_link" @click="toRister()">
                            <span class="fonttypes">注册新账号</span>
                        </a>
                    </div>

                    <div class="login_form">
                        <input id="login_source" type="hidden" value="1" />
                        <input id="login_pc_home_page" type="hidden" value="1" />


                        <div class="form_item_wrap">
                            <div class="form_item">
                                <label class="user_ico">&nbsp;</label>
                                <input id="un" type="text" name="credentials.username" spellcheck="false" tabIndex="1" class="ipt ipt_username" style="outline: none;"
                                    placeholder="用户名" v-model="loginForm.username" />
                            </div>
                            <div class="form_item">
                                <label class="paswd_ico">&nbsp;</label>
                                <input id="pwd" type="password" oncopy="return false" onpaste="return false" oncut="return false" oncontextmenu="return false"
                                    name="credentials.password" tabIndex="2" class="ipt ipt_password gay_text" placeholder="密码"
                                    style="outline: none;" v-model="loginForm.password" />

                            </div>

                            <div class="auto_login clearfix">
                                <p class="clearfix"></p>
                                <a href="javascript:void(0);" class="forget_pswd" tabIndex="-1" @click="toFindePsd()">忘记密码？</a>
                            </div>

                            <button id="login_button" type="button" class="login_btn" @click="login()" @dblclick="dbl_login">登录</button>

                        </div>

                        <div class="joint_landing_wrap">
                            <p class="fonttype">更多合作网站账号登录</p>
                            <div class="clearfix">
                                <ul class="account_list clearfix">
                                    <li>
                                        <a href="javascript:void(0);" @click="unSupportNow()">
                                            <img src="/static/img/qq.png" class="iconfont qq" title="QQ" style="width:40px;height:35px;"></img>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0);" @click="unSupportNow()">
                                            <img src="/static/img/weixin.png" class="iconfont weixin" title="weixin" style="width:40px;height:35px;"></img>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0);" @click="unSupportNow()">
                                            <img src="/static/img/weibo.png" class="iconfont sina" title="sina" style="width:40px;height:35px;"></img>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mod_left_banner">
                <a id="imgLink" target="_blank">
                    <img id="img" src="/static/img/leftloginbody.jpg" />
                </a>
            </div>
        </div>
    </div>
    <div class="mod_login_bindmb_point"></div>


    <div id="simplefooter">
        <p class="fonttype">Copyright © 中科大软院校友平台 2018，All Rights Reserved</p>
    </div>
</div>
</template>

<script>
export default {
  data: function() {
    return {
      error_input_msg: "",
      error_input: {
        display: "none"
      },
      loginForm: {
        username: "",
        password: ""
      },
      fullscreenLoading: false,
      //密码正则
      // 弱： 8-16位数字，字母，字符其中两种
      // 中 8-14位    数字，字母，字符其中三种
      // 强 14-16位    数字，字母，字符其中三种
      passwordmatch: [
        /^(?!\d+$)(?![a-zA-Z]+$)[\dA-Za-z]{8,16}$/,
        /^(?!((?=[\x21-\x7e]+)[^A-Za-z0-9])+$)(?![a-zA-Z]+$)[^\u4e00-\u9fa5\d]{8,16}$/,
        /^(?!((?=[\x21-\x7e]+)[^A-Za-z0-9])+$)(?!\d+$)[^\u4e00-\u9fa5a-zA-Z]{8,16}$/,
        /^(?=.*((?=[\x21-\x7e]+)[^A-Za-z0-9]))(?=.*[a-zA-Z])(?=.*[0-9])[^\u4e00-\u9fa5]{8,13}$/,
        /^(?=.*((?=[\x21-\x7e]+)[^A-Za-z0-9]))(?=.*[a-zA-Z])(?=.*[0-9])[^\u4e00-\u9fa5]{14,16}$/
      ]
    };
  },
  computed: {
    access_token: function() {
      return this.$store.getters.access_token;
    }
  },
  methods: {
    toFindePsd() {
      this.$router.push("findpsd");
    },
    toRister() {
      this.$router.push("register");
    },
    unSupportNow() {
      this.$notify.error({
        title: "提示",
        message: "暂不支持该功能!敬请期待!"
      });
    },
    dbl_login() {
      this.login();
    },
    async login() {
      // 如果账户密码不为空
      if (this.loginForm.username == "" || this.loginForm.password == "") {
        this.btn_could_press = false;
        this.error_input.display = "block";
        this.error_input_msg = "账户密码不能为空!";
      } else if (
        /^[A-Za-z0-9]{6,15}$/.test(this.loginForm.username) &&
        (this.passwordmatch[0].test(this.loginForm.password) ||
          this.passwordmatch[1].test(this.loginForm.password) ||
          this.passwordmatch[2].test(this.loginForm.password) ||
          this.passwordmatch[3].test(this.loginForm.password))
      ) {
        this.error_input.display = "none";
        try {
          var res = await this.$store.dispatch("userModule/LoginController", {
            user_name: this.loginForm.username,
            password: this.loginForm.password
          });
        } catch (error) {
          console.error("LoginController失败!");
          this.$notify.error({
            title: "错误",
            message: "服务器异常或者您的网络异常!"
          });
        }
        if (res.code == 200) {
          await this.controlFullscreen("您已成功登陆,即将跳转至主页...", 600);
          this.$router.push("main");
        } else if (res.code == 405) {
          this.error_input.display = "block";
          this.error_input_msg = "账户未激活!请到邮箱激活";
        } else {
          this.error_input.display = "block";
          this.error_input_msg = "账户密码错误!";
        }
      } else {
        // 账户密码格式有误
        this.error_input.display = "block";
        this.error_input_msg = "账户密码格式错误!";
      }
    }
  },
  mounted() {}
};
</script>

<style lang="less" scoped>
@import "../style/login";
</style>