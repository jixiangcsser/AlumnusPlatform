<template>
<div>
    <div class="regist_header clearfix">
        <div class="wrap">
            <a href="javascript:void(0);" class="logo">
                <img src="/static/img/logo.png" height="55" alt="校友平台" />
            </a>
            <div class="regist_header_right clearfix">
                <div class="help_wrap">
                    <a class="hd_menu" href="javascript:;" @click="unSupportNow()">
                        <s class="help_ico"></s>
                        <span class="fonttype">帮助中心</span>
                    </a>
                </div>
                <span class="fr fonttype">您好，欢迎登陆中科大软院校友平台！</span>
            </div>
        </div>
    </div>
    <input type="hidden" value="0" id="iscompletepassword" />

    <div class="find_wrap">
        <div class="find_step">
            <ul class="clearfix">
                <!--完成给li加done,当前状态加cur -->
                <li v-bind:class="find_wrap.li[0]">
                    <em>1</em>
                    <p>填写用户名</p>
                    <i></i>
                </li>
                <li v-bind:class="find_wrap.li[1]">
                    <em>2</em>
                    <p>验证身份</p>
                    <i></i>
                </li>
                <li v-bind:class="find_wrap.li[2]">
                    <em>3</em>
                    <p>设置新密码</p>
                    <i></i>
                </li>
                <li v-bind:class="find_wrap.li[3]">
                    <em>4</em>
                    <p>完成</p>
                </li>
            </ul>
        </div>
        <div class="find_detail">
            <div class="y_regist_form">
                <p v-show="code_prompt_show" class="find_tips" style="color:rgb(47, 47, 47);font-size:14px;">点击按钮后验证码将发送至您的邮箱</p>
                <ul class="clearfix">
                    <!-- 1 and 2 -->
                    <!--判断正确给li加class  “ipt_right ifocus”,错误给li加class  “ipt_wrong ifocus” -->
                    <!-- <li class="ishort_li clearfix"> -->
                    <li v-show="li_show" v-bind:class="ipt_li">
                        <!-- <div class="fl y_same_item"> -->
                        <div v-bind:class="input1or2">
                            <input class="ysame_input" type="text" id="login_account" v-model="ipt_input" @click="ipt_click"/>
                            <span class="y_same_label" style="left: -64px;">{{ info1or2 }}</span>
                        </div>
                        <!-- r_require_code 为白色, r_resend_code为黑色 -->
                        <a v-show="code_prompt_show" v-bind:class="receive_code_style" href="javascript:;" @click="receive_code" @dblclick="receive_code_dbc">获取验证码 {{endIntervalsec}}</a>
                        <!--提示信息begin y_regist_tips_red -->
                        <i class="item_icon_sure"></i>
                        <div v-bind:class="y_regist_tips">
                            <div class="y_regtip_rel">
                                <i></i>
                                <div class="y_tips_words">
                                    {{y_tips_words}}
                                </div>
                            </div>
                        </div>
                        <!--提示信息end -->
                    </li>
                    
                    <!-- 3 -->
                    <div v-show="psd_show">
                        <li v-bind:class= "psd_show_li1">
                            <div class="y_same_item">
                                <input class="ysame_input y_set_password" type="password" oncopy="return false;" oncut="return false;" onpaste="return false;"
                                    id="password" autocomplete="off" @click="psd_show_click(0)" v-model="psd_input1" @keyup="input_psd1" @keyup.tab="psd_show_click(0)"/>
                                <span class="y_same_label" style="left: -64px;">设置密码</span>
                            </div>
                            <!--错误提示 begin -->
                            <div v-bind:class="y_regist_tips_psd1" v-bind:style="y_regist_tips_style[3]">
                                <div class="y_regtip_rel">
                                    <i></i>
                                    <div class="y_tips_words">
                                        {{y_tips_words_psd1}}
                                    </div>
                                </div>
                            </div>
                            <div class="y_regist_tips_keywords strength_l" v-bind:style="y_regist_tips_style[0]">
                                <div class="y_regtip_rel">
                                    <i></i>
                                    <div class="y_tips_words y_tips_words_key">
                                        <em class="em_redA"></em>
                                        <em></em>
                                        <em></em>
                                        <b class="em_words">低</b>
                                    </div>
                                </div>
                            </div>

                            <div class="y_regist_tips_keywords strength_m" v-bind:style="y_regist_tips_style[1]">
                                <div class="y_regtip_rel">
                                    <i></i>
                                    <div class="y_tips_words y_tips_words_key">
                                        <em class="em_yellowA1"></em>
                                        <em class="em_yellowA1"></em>
                                        <em></em>
                                        <b class="em_words">中</b>
                                    </div>
                                </div>
                            </div>

                            <div class="y_regist_tips_keywords strength_h" v-bind:style="y_regist_tips_style[2]">
                                <div class="y_regtip_rel">
                                    <i></i>
                                    <div class="y_tips_words y_tips_words_key">
                                        <em class="em_greenA1"></em>
                                        <em class="em_greenA1"></em>
                                        <em class="em_greenA1"></em>
                                        <b class="em_words">高</b>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li v-bind:class= "psd_show_li2">
                            <div class="y_same_item">
                                <input class="ysame_input" type="password" oncopy="return false;" oncut="return false;" onpaste="return false;" id="password2"
                                    autocomplete="off" @click="psd_show_click(1)" v-model="psd_input2" @keyup="input_psd2" @keyup.tab="psd_show_click(1)"/>
                                <span class="y_same_label" style="left: -64px;">确认密码</span>
                            </div>
                            <div v-bind:class="y_regist_tips_psd2" v-bind:style="y_regist_tips_psd2_show">
                                <div class="y_regtip_rel">
                                    <i></i>
                                    <div class="y_tips_words">
                                        {{y_tips_words_psd2}}
                                    </div>
                                </div>
                            </div>
                            <!--正确-->
                            <div class="y_regist_right"></div>
                        </li>
                    </div>

                    <li v-show="next_step_show">
                        <a href="javascript:;" class="y_agreement_btn" id="confirmUser" @click="nextStep()">下一步</a>
                    </li>

                    <!-- 4 -->
                    <div v-show="!next_step_show" class="new_pswd_success">
                        <div class="success_tips">
                            <em></em>
                            <p>新密码设置成功！</p>
                            <p>请您牢记新密码</p>
                        </div>
                        <div class="buy_box">
                            <a href="javascript:void(0);" @click="toLogin()">前往登陆页</a>
                        </div>
                    </div>
                </ul>
            </div>
        </div>
    </div>

    <div id="simplefooter">
        <p class="fonttype">Copyright © 中科大软院校友平台 2018，All Rights Reserved</p>
    </div>
</div>
</template>

<script>
import matchObj from "../util/global/matchreg";

export default {
  data: function() {
    return {
      match: [
        matchObj.user_match,
        matchObj.password_match[0],
        matchObj.password_match[1],
        matchObj.password_match[2],
        matchObj.password_match[3],
        matchObj.password_match[4]
      ],
      find_wrap: {
        active: 0,
        li: [
          {
            done: false,
            cur: true
          },
          {
            done: false,
            cur: false
          },
          {
            done: false,
            cur: false
          },
          {
            done: false,
            cur: false
          }
        ]
      },
      ipt_li: {
        ipt_right: true,
        ipt_wrong: false,
        ifocus: false,
        ishort_li: false,
        clearfix: false
      },
      psd_show_li1: {
        ipt_right: false,
        ipt_wrong: false,
        ifocus: false
      },
      psd_show_li2: {
        ipt_right: false,
        ipt_wrong: false,
        ifocus: false
      },
      y_regist_tips_psd1: {
        y_regist_tips: true,
        y_regist_tips_red: false,
        y_regist_tips_black: true
      },
      y_regist_tips_psd2: {
        y_regist_tips: true,
        y_regist_tips_red: false,
        y_regist_tips_black: true
      },
      receive_code_style: {
        receive_code: true,
        fl: true,
        same_code_btn: true,
        r_require_code: true,
        r_resend_code: false
      },
      y_regist_tips: {
        y_regist_tips: true,
        y_regist_tips_red: false,
        y_regist_tips_black: true
      },
      y_regist_tips_style: [
        {
          display: "none"
        },
        {
          display: "none"
        },
        {
          display: "none"
        },
        {
          display: "block"
        }
      ],
      ipt_input: "",
      y_tips_words: "请输入您的用户名",
      y_tips_words_psd1: "同时含有数字和字母，且长度要在6-16位之间",
      y_tips_words_psd2: "请再次输入密码",
      endIntervalsec: "",
      current_username: "",
      Interval: null,
      psd_input1: "",
      psd_input2: "",
      y_regist_tips_psd2_show: {
        display: "block"
      }
    };
  },
  computed: {
    code_prompt_show: function() {
      return this.find_wrap.active == 1 ? true : false;
    },
    next_step_show: function() {
      return this.find_wrap.active == 3 ? false : true;
    },

    li_show: function() {
      return this.find_wrap.active == 0 || this.find_wrap.active == 1
        ? true
        : false;
    },
    psd_show: function() {
      return this.find_wrap.active == 2 ? true : false;
    },
    input1or2: function() {
      return this.find_wrap.active == 0 || this.find_wrap.active == 1
        ? this.find_wrap.active == 0
          ? { y_same_item: true }
          : { fl: true, y_same_item: true }
        : { y_same_item: true };
    },
    info1or2: function() {
      return this.find_wrap.active == 0 || this.find_wrap.active == 1
        ? this.find_wrap.active == 0 ? "用户名" : "验证码"
        : "";
    },
    access_token: function() {
      return this.$store.getters.access_token;
    }
  },
  methods: {
    unSupportNow() {
      this.$notify.error({
        title: "提示",
        message: "暂不支持该功能!敬请期待!"
      });
    },
    toLogin() {
      this.$router.push("/");
    },
    toNextBlock() {
      this.find_wrap.li[this.find_wrap.active].done = true;
      this.find_wrap.li[this.find_wrap.active].cur = false;
      this.find_wrap.li[this.find_wrap.active + 1].cur = true;
      this.find_wrap.active++;
    },
    change_ipt_li(ipt_right, ipt_wrong, ifocus) {
      this.ipt_li.ipt_right = ipt_right;
      this.ipt_li.ipt_wrong = ipt_wrong;
      this.ipt_li.ifocus = ifocus;
    },
    ipt_click() {
      if (this.find_wrap.active == 0) {
        this.y_regist_tips.y_regist_tips_red = false;
        this.y_regist_tips_black = true;
        this.y_tips_words = "请输入您的用户名";
      } else if (this.find_wrap.active == 1) {
        this.ipt_li.ishort_li = true;
        this.ipt_li.clearfix = true;
        this.ipt_li.ifocus = true;
        this.y_regist_tips.y_regist_tips_red = false;
        this.y_regist_tips_black = true;
        this.y_tips_words = "请输入获取到的验证码!";
      }
      this.change_ipt_li(true, false, true);
    },
    change_psd_show(id, ipt_right, ipt_wrong, ifocus) {
      if (id == 0) {
        this.psd_show_li1.ipt_right = ipt_right;
        this.psd_show_li1.ipt_wrong = ipt_wrong;
        this.psd_show_li1.ifocus = ifocus;
      } else {
        this.psd_show_li2.ipt_right = ipt_right;
        this.psd_show_li2.ipt_wrong = ipt_wrong;
        this.psd_show_li2.ifocus = ifocus;
      }
    },
    clear_block() {
      this.y_regist_tips_style[0].display = "none";
      this.y_regist_tips_style[1].display = "none";
      this.y_regist_tips_style[2].display = "none";
      this.y_regist_tips_style[3].display = "none";
    },
    input_psd1() {
      this.clear_block();
      if (this.match[1].test(this.psd_input1)) {
        this.y_regist_tips_style[0].display = "block";
      } else if (this.match[2].test(this.psd_input1)) {
        this.y_regist_tips_style[0].display = "block";
      } else if (this.match[3].test(this.psd_input1)) {
        this.y_regist_tips_style[0].display = "block";
      } else if (this.match[4].test(this.psd_input1)) {
        this.y_regist_tips_style[1].display = "block";
      } else if (this.match[5].test(this.psd_input1)) {
        this.y_regist_tips_style[2].display = "block";
      } else {
        this.y_regist_tips_style[3].display = "block";
      }
    },
    input_psd2() {
      this.y_regist_tips_psd2_show.display = "block";
      if (
        this.match[1].test(this.psd_input1) ||
        this.match[2].test(this.psd_input1) ||
        this.match[3].test(this.psd_input1) ||
        this.match[4].test(this.psd_input1) ||
        this.match[5].test(this.psd_input1)
      ) {
        if (this.psd_input2 == this.psd_input1) {
          this.y_regist_tips_psd2_show.display = "none";
          this.change_psd_show(1, true, false, true);
        } else {
          this.change_psd_show(1, false, false, true);
        }
      } else {
        this.change_psd_show(1, false, false, true);
      }
    },
    psd_show_click(id) {
      if (id == 0) {
        if (
          this.match[1].test(this.psd_input1) ||
          this.match[2].test(this.psd_input1) ||
          this.match[3].test(this.psd_input1) ||
          this.match[4].test(this.psd_input1) ||
          this.match[5].test(this.psd_input1)
        ) {
        } else {
          this.y_regist_tips_psd1.y_regist_tips_red = false;
          this.y_regist_tips_psd1.y_regist_tips_black = true;
          this.y_tips_words_psd1 = "同时含有数字和字母，且长度要在6-16位之间";
          this.change_psd_show(id, true, false, true);
        }
      } else {
        if (
          !(
            this.match[1].test(this.psd_input1) ||
            this.match[2].test(this.psd_input1) ||
            this.match[3].test(this.psd_input1) ||
            this.match[4].test(this.psd_input1) ||
            this.match[5].test(this.psd_input1)
          )
        ) {
          this.y_regist_tips_psd1.y_regist_tips_red = true;
          this.y_regist_tips_psd1.y_regist_tips_black = false;
          this.y_tips_words_psd1 = "密码格式不正确!";
          this.change_psd_show(0, false, true, true);
        }
        this.input_psd2();
      }
    },
    // 下一步按钮监听事件
    async nextStep() {
      if (this.find_wrap.active == 0) {
        if (this.match[0].test(this.ipt_input)) {
          let res = await this.$store.dispatch(
            "userModule/CheckUserExistController",
            this.ipt_input
          );
          if (res.code == 200) {
            this.current_username = this.ipt_input;
            this.ipt_input = "";
            this.ipt_li.clearfix = true;
            this.ipt_li.ishort_li = true;
            this.change_ipt_li(false, false, false);
          } else {
            this.y_regist_tips.y_regist_tips_red = true;
            this.y_regist_tips.y_regist_tips_black = false;
            this.y_tips_words = "账户名不存在!";
            this.change_ipt_li(true, true, true);
            return;
          }
        } else {
          this.y_regist_tips.y_regist_tips_red = true;
          this.y_regist_tips.y_regist_tips_black = false;
          this.y_tips_words = "请输入正确格式的用户名";
          this.change_ipt_li(true, true, true);
          return;
        }
      } else if (this.find_wrap.active == 1) {
        if (this.ipt_input.trim() != "") {
          let res = await this.$store.dispatch("emailModule/VerifyCodeEmail", {
            user_name: this.current_username,
            code: this.ipt_input
          });
          if (res.code != 200) {
            this.y_tips_words = "验证码错误!";
            this.y_regist_tips.y_regist_tips_red = true;
            this.y_regist_tips.y_regist_tips_black = false;
            return;
          }
        } else {
          this.ipt_li.ifocus = true;
          this.y_tips_words = "验证码不能为空!";
          this.y_regist_tips.y_regist_tips_red = true;
          this.y_regist_tips.y_regist_tips_black = false;
          return;
        }
      } else if (this.find_wrap.active == 2) {
        if (
          !(
            (this.match[1].test(this.psd_input1) ||
              this.match[2].test(this.psd_input1) ||
              this.match[3].test(this.psd_input1) ||
              this.match[4].test(this.psd_input1) ||
              this.match[5].test(this.psd_input1)) &&
            this.psd_input1 == this.psd_input2
          )
        ) {
          return;
        } else {
          let res = await this.$store.dispatch("userModule/UpdatePassWord", {
            user_name: this.current_username,
            password: this.psd_input1
          });
          if (res.code != 200) {
            console.error("UpdatePassWord失败!");
          }
        }
      }
      this.toNextBlock();
    },
    endInterval() {
      this.endIntervalsec = this.endIntervalsec - 1;
      if (this.endIntervalsec == 0) {
        clearInterval(this.Interval);
        this.receive_code_style.r_resend_code = false;
        this.receive_code_style.r_require_code = true;
        this.endIntervalsec = "";
      }
    },
    receive_code_dbc() {
      this.receive_code();
    },
    // 发送验证码按钮监听事件
    receive_code() {
      if (this.endIntervalsec == "") {
        //设置定时器，每1秒刷新一次
        this.endIntervalsec = 50;
        this.Interval = setInterval(this.endInterval, 1000);
        this.receive_code_style.r_resend_code = true;
        this.receive_code_style.r_require_code = false;
        this.ipt_li.ifocus = true;
        this.y_tips_words =
          "验证码已发送至您的邮箱，请查收(邮件有时比较慢，请耐心等候!)";
        this.y_regist_tips.y_regist_tips_red = false;
        this.y_regist_tips_black = true;
        this.$store.dispatch(
          "emailModule/SendCodeEmail",
          this.current_username
        );
      }
    }
  }
};
</script>


<style lang="less" scoped>
@import "../style/findpsd";
</style>