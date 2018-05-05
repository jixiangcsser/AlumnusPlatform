<template>
<div>
    <div class="regist_header clearfix">
        <div class="wrap">
            <a href="javascript:void(0);" @click="back2Home" class="logo">
                <img src="/static/img/logo.png" height="55" alt="校友平台" />
            </a>
            <div class="regist_header_right clearfix">
                <!--<a href="#" class="english_edition" id="edition" style="display:none">English</a>-->
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
    <input type="hidden" id="validateSig" />
    <input type="hidden" name="returnUrl" value="http://www.yhd.com" id="returnUrl">
    <input id="p" type="hidden" value="" />
    <input type="password" style="display:none">
    <div class="y_regist_wrap">
        <!--背景小图标 -->
        <div class="r_icon1"></div>
        <div class="r_icon2"></div>
        <div class="r_icon3"></div>
        <div class="r_icon4"></div>
        <div class="r_icon5"></div>
        <div class="y_regist_model">

            <h4 class="y_regist_tit">软院校友注册</h4>

            <div class="y_regist_form">
                <ul class="clearfix">
                    <li v-bind:class="liclassobjAry[0][1]">
                        <div class="y_same_item">
                            <input v-model="username" class="ysame_input" type="text" id="userName" @click="selectLi(0)" />    
                              <span class="y_same_label" v-bind:style="liclassobjAry[0][2]">用户名</span>
                        </div>

                        <div class="y_regist_tips" v-bind:style="liclassobjAry[0][0]" v-bind:class="liclassobjAry[0][3]">
                            <div class="y_regtip_rel">
                                <i></i>
                                <div class="y_tips_words">{{infocontentArray[0]}}</div>
                            </div>
                        </div>

                        <div class="y_regist_right"></div>
                        <!--提示信息end -->
                    </li>

                    <!--邮箱-->
                    <li v-bind:class="liclassobjAry[4][1]">
                        <div class="y_same_item">
                            <input v-model="email" class="ysame_input" type="text" id="email" @click="selectLi(4)" @keyup.tab="selectLi(4)"/>
                            <span class="y_same_label" v-bind:style="liclassobjAry[4][2]">邮箱</span>

                        </div>
                        <div class="y_regist_tips" v-bind:style="liclassobjAry[4][0]" v-bind:class="liclassobjAry[4][3]">
                            <div class="y_regtip_rel">
                                <i></i>
                                <div class="y_tips_words">
                                    {{infocontentArray[4]}}
                                </div>
                            </div>
                        </div>

                        <div class="y_regist_right"></div>
                    </li>

                    <li v-bind:class="liclassobjAry[1][1]">
                        <div class="y_same_item">
                            <input v-model="phone" class="ysame_input" type="text" id="phone" @click="selectLi(1)" @keyup.tab="selectLi(1)" />
                            <span class="y_same_label" v-bind:style="liclassobjAry[1][2]">手机号</span>

                        </div>
                        <div class="y_regist_tips" v-bind:style="liclassobjAry[1][0]" v-bind:class="liclassobjAry[1][3]">
                            <div class="y_regtip_rel">
                                <i></i>
                                <div class="y_tips_words">
                                    {{infocontentArray[1]}}
                                </div>
                            </div>
                        </div>

                        <div class="y_regist_right"></div>
                    </li>

                    <li v-bind:class="liclassobjAry[2][1]">
                        <div class="y_same_item">
                            <input v-model="password" class="ysame_input y_set_password" type="password" oncopy="return false;" oncut="return false;"
                                onpaste="return false;" autocomplete="off" id="password" @click="selectLi(2)" @keyup="inputpassword"
                                @keyup.tab="selectLi(2)" />
                            <span class="y_same_label" v-bind:style="liclassobjAry[2][2]">设置密码</span>
                        </div>
                        <div class="y_regist_tips" v-bind:style="liclassobjAry[2][0]" v-bind:class="liclassobjAry[2][3]">
                            <div class="y_regtip_rel">
                                <i></i>
                                <div class="y_tips_words">
                                    {{infocontentArray[2]}}
                                </div>
                            </div>
                        </div>

                        <div class="y_regist_tips_keywords strength_l" v-bind:style="safetylevel[0]">
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

                        <div class="y_regist_tips_keywords strength_m" v-bind:style="safetylevel[1]">
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

                        <div class="y_regist_tips_keywords strength_h" v-bind:style="safetylevel[2]">
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

                    <li v-bind:class="liclassobjAry[3][1]">
                        <div class="y_same_item">
                            <input v-model="twicepassword" class="ysame_input" type="password" oncopy="return false;" oncut="return false;" onpaste="return false;"
                                id="password2" @click="selectLi(3)" @keyup="twiceinputpassword" @keyup.tab="selectLi(3)" />
                            <span class="y_same_label" v-bind:style="liclassobjAry[3][2]">确认密码</span>
                        </div>

                        <div class="y_regist_tips" v-bind:style="liclassobjAry[3][0]" v-bind:class="liclassobjAry[3][3]">
                            <div class="y_regtip_rel">
                                <i></i>
                                <div class="y_tips_words">
                                    {{infocontentArray[3]}}
                                </div>
                            </div>
                        </div>

                        <div class="y_regist_right"></div>
                    </li>
                    <li>
                        <div class="y_agreement_word">点击注册，加入科大软院的校友平台,为软院发展尽一份力!</div>
                        <a class="y_agreement_btn" href="javascript:void(0);" @click="submit" @dblclick="dblsubmit">注册</a>
                    </li>
                </ul>
            </div>
            <!-- // y_regist_form ending -->
        </div>
    </div>
    <!--// y_regist_wrap ending -->
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
      //手机号正则，账户正则，邮箱正则
      othermatch: [
        matchObj.phone_match,
        matchObj.user_match,
        matchObj.mail_match
      ],
      //密码正则
      // 弱： 8-16位数字，字母，字符其中两种
      // 中 8-14位    数字，字母，字符其中三种
      // 强 14-16位    数字，字母，字符其中三种
      passwordmatch: matchObj.password_match,
      twicepassword: "",
      username: "",
      phone: "",
      email: "",
      password: "",
      beforelastchoose: null,
      infocontentArray: ["", "", "", "", ""],
      infocontentconstantAry: [
        "数字和字母，且长度要在6-15位之间",
        "请填写正确的手机号码，以便 接收订单通知，找回密码等",
        "同时含有数字和字母，且长度要在6-16位之间",
        "请再次输入密码",
        "请填写正确的邮箱，以便激活账号，找回密码等"
      ],
      safetylevel: [
        {
          display: "none"
        },
        {
          display: "none"
        },
        {
          display: "none"
        }
      ],
      liclassobjAry: [
        [
          {
            top: "16px"
          },
          {
            ifocus: false,
            ipt_wrong: false,
            ipt_right: false
          },
          {
            left: null
          },
          {
            y_regist_tips_black: true,
            y_regist_tips_red: false
          }
        ],
        [
          {
            top: "-4px"
          },
          {
            ifocus: false,
            ipt_wrong: false,
            ipt_right: false
          },
          {
            left: null
          },
          {
            y_regist_tips_black: true,
            y_regist_tips_red: false
          }
        ],
        [
          {
            top: "6px"
          },
          {
            ifocus: false,
            ipt_wrong: false,
            ipt_right: false
          },
          {
            left: null
          },
          {
            y_regist_tips_black: true,
            y_regist_tips_red: false
          }
        ],
        [
          {
            top: "6px"
          },
          {
            ifocus: false,
            ipt_wrong: false,
            ipt_right: false
          },
          {
            left: null
          },
          {
            y_regist_tips_black: true,
            y_regist_tips_red: false
          }
        ],
        [
          {
            top: "-4px"
          },
          {
            ifocus: false,
            ipt_wrong: false,
            ipt_right: false
          },
          {
            left: null
          },
          {
            y_regist_tips_black: true,
            y_regist_tips_red: false
          }
        ]
      ]
    };
  },
  computed: {
    access_token: function() {
      return this.$store.getters.access_token;
    }
  },
  methods: {
    clearblock() {
      this.liclassobjAry[2][0].display = "none";
      this.safetylevel[0].display = "none";
      this.safetylevel[1].display = "none";
      this.safetylevel[2].display = "none";
    },
    inputpassword() {
      this.clearblock();
      if (this.passwordmatch[0].test(this.password)) {
        this.safetylevel[0].display = "block";
      } else if (this.passwordmatch[1].test(this.password)) {
        this.safetylevel[0].display = "block";
      } else if (this.passwordmatch[2].test(this.password)) {
        this.safetylevel[0].display = "block";
      } else if (this.passwordmatch[3].test(this.password)) {
        this.safetylevel[1].display = "block";
      } else if (this.passwordmatch[4].test(this.password)) {
        this.safetylevel[2].display = "block";
      } else {
        this.liclassobjAry[2][0].display = "block";
      }
    },
    changeState(
      id,
      ifocus,
      ipt_wrong,
      ipt_right,
      display,
      top,
      y_regist_tips_red,
      y_regist_tips_black,
      left
    ) {
      ifocus != null ? (this.liclassobjAry[id][1].ifocus = ifocus) : null;
      ipt_wrong != null
        ? (this.liclassobjAry[id][1].ipt_wrong = ipt_wrong)
        : null;
      ipt_right != null
        ? (this.liclassobjAry[id][1].ipt_right = ipt_right)
        : null;
      display != null ? (this.liclassobjAry[id][0].display = display) : null;
      top != null ? (this.liclassobjAry[id][0].top = top) : null;
      y_regist_tips_red != null
        ? (this.liclassobjAry[id][3].y_regist_tips_red = y_regist_tips_red)
        : null;
      y_regist_tips_black != null
        ? (this.liclassobjAry[id][3].y_regist_tips_black = y_regist_tips_black)
        : null;
      left != null ? (this.liclassobjAry[id][2].left = left) : null;
    },
    twiceinputpassword() {
      if (this.password != "" && this.password == this.twicepassword) {
        this.changeState(
          3,
          false,
          false,
          true,
          "none",
          "6px",
          null,
          null,
          "-62px"
        );
      } else if (this.password != "") {
        this.changeState(
          3,
          true,
          true,
          false,
          "block",
          "-4px",
          true,
          false,
          "-62px"
        );
        this.infocontentArray[3] = "两次输入的密码不一致!";
      } else {
        this.changeState(
          3,
          true,
          false,
          false,
          "block",
          "-4px",
          false,
          true,
          "-62px"
        );
        this.infocontentArray[3] = this.infocontentconstantAry[3];
      }
    },
    checklastselect(id) {
      if (id == 0) {
        if (this.othermatch[1].test(this.username)) {
          this.changeState(
            0,
            false,
            false,
            true,
            null,
            "16px",
            null,
            null,
            null
          );
        } else {
          this.changeState(
            0,
            true,
            true,
            false,
            null,
            "-4px",
            true,
            false,
            null
          );
          if (this.username == "") {
            this.infocontentArray[0] = "用户名不能为空!";
          } else {
            this.infocontentArray[0] = "用户名格式错误!";
          }
        }
      } else if (id == 1) {
        if (this.othermatch[0].test(this.phone)) {
          this.changeState(
            1,
            false,
            false,
            true,
            null,
            "-4px",
            null,
            null,
            null
          );
        } else {
          this.changeState(
            1,
            true,
            true,
            false,
            null,
            "-4px",
            true,
            false,
            null
          );
          if (this.phone == "") {
            this.infocontentArray[1] = "手机号不能为空!";
          } else {
            this.infocontentArray[1] = "手机号格式错误!";
          }
        }
      } else if (id == 2) {
        if (
          this.passwordmatch[0].test(this.password) ||
          this.passwordmatch[1].test(this.password) ||
          this.passwordmatch[2].test(this.password) ||
          this.passwordmatch[3].test(this.password) ||
          this.passwordmatch[4].test(this.password)
        ) {
          this.changeState(2, false, false, null, null, null, null, null, null);
        } else {
          this.changeState(
            2,
            true,
            true,
            null,
            null,
            "-4px",
            true,
            false,
            null
          );
          if (this.password == "") {
            this.infocontentArray[2] = "密码不能为空!";
          } else {
            this.infocontentArray[2] = "密码格式错误!";
          }
        }
      } else if (id == 3) {
        if (this.password != "" && this.password != this.twicepassword) {
          this.changeState(
            3,
            true,
            true,
            false,
            "block",
            "-4px",
            true,
            false,
            null
          );
          this.infocontentArray[3] = "两次输入的密码不一致!";
        } else if (this.password == "") {
          this.changeState(
            3,
            false,
            false,
            false,
            "none",
            "6px",
            null,
            null,
            null
          );
        }
      } else if (id == 4) {
        if (this.othermatch[2].test(this.email)) {
          this.changeState(
            4,
            false,
            false,
            true,
            null,
            "-4px",
            null,
            null,
            null
          );
        } else {
          this.changeState(
            4,
            true,
            true,
            false,
            null,
            "-4px",
            true,
            false,
            null
          );
          if (this.email == "") {
            this.infocontentArray[4] = "邮箱不能为空!";
          } else {
            this.infocontentArray[4] = "邮箱格式错误!";
          }
        }
      }
    },
    dblsubmit() {
      this.submit();
    },
    //注册
    async submit() {
      if (!this.othermatch[1].test(this.username)) {
        this.checklastselect(0);
      } else if (!this.othermatch[0].test(this.phone)) {
        this.checklastselect(1);
      } else if (!this.othermatch[2].test(this.email)) {
        this.checklastselect(4);
      } else if (
        this.password == "" ||
        this.twicepassword == "" ||
        this.password != this.twicepassword
      ) {
        if (this.password == "") {
          this.checklastselect(2);
        } else {
          this.checklastselect(2);
          this.checklastselect(3);
        }
      } else {
        try {
          var res = await this.$store.dispatch(
            "userModule/RegisterController",
            {
              user_name: this.username,
              password: this.password,
              phone: this.phone,
              email: this.email
            }
          );
        } catch (error) {
          console.error("RegisterController失败!");
          this.$notify.error({
            title: "错误",
            message: "服务器异常或者您的网络异常!"
          });
        }
        // success
        if (res.code == 200) {
          try {
            await this.$confirm(
              "注册成功!点击确定后将跳转至登陆界面！(重要提醒：激活邮件已经发送，请您到邮箱处激活！未激活的账号将无法登陆)",
              "提示",
              {
                confirmButtonText: "确定",
                showCancelButton: false,
                type: "success",
                center: true
              }
            );
          } catch (error) {
            //此处error是对话框选择叉号的时候需要执行的内容
          }
          this.$router.push("/");
        } else {
          this.changeState(
            0,
            true,
            true,
            false,
            null,
            "-4px",
            true,
            false,
            null
          );
          this.infocontentArray[0] = "用户名" + this.username + "已存在!";
        }
      }
    },
    back2Home() {
      this.$router.push("/");
    },
    unSupportNow() {
      this.$notify.error({
        title: "提示",
        message: "暂不支持该功能!敬请期待!"
      });
    },
    selectLi(id) {
      if (id == 3) {
        this.twiceinputpassword();
      } else {
        if (this.liclassobjAry[id][1].ipt_right != true) {
          this.changeState(
            id,
            true,
            false,
            null,
            null,
            "-4px",
            false,
            true,
            "-62px"
          );
          this.infocontentArray[id] = this.infocontentconstantAry[id];
        }
      }
      if (this.beforelastchoose != null && this.beforelastchoose != id) {
        this.checklastselect(this.beforelastchoose);
      }
      this.beforelastchoose = id;
    }
  },
  mounted() {}
};
</script>

<style lang="less" scoped>
@import "../style/register";
</style>