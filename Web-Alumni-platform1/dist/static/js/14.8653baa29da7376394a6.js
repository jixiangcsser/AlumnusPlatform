webpackJsonp([14],{315:function(t,e,s){s(488);var a=s(129)(s(450),s(506),"data-v-add41f50",null);t.exports=a.exports},450:function(t,e,s){"use strict";function a(t){return function(){var e=t.apply(this,arguments);return new Promise(function(t,s){function a(n,i){try{var r=e[n](i),o=r.value}catch(t){return void s(t)}if(!r.done)return Promise.resolve(o).then(function(t){a("next",t)},function(t){a("throw",t)});t(o)}return a("next")})}}Object.defineProperty(e,"__esModule",{value:!0}),e.default={computed:{defaultActive:function(){return this.$route.path.replace("/","")},access_token:function(){return this.$store.getters.access_token},isNewUser:function(){return this.$store.getters["userModule/isNewUser"]}},methods:{},mounted:function(){function t(){return e.apply(this,arguments)}var e=a(regeneratorRuntime.mark(function t(){var e;return regeneratorRuntime.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,this.$store.dispatch("GetAliClient","sse-ustc-usericon");case 3:return t.next=5,this.$store.dispatch("userModule/GetUserInfoController",!0);case 5:if(e=t.sent,200!=e.code){t.next=10;break}return t.next=9,this.$store.dispatch("userModule/GetUserIcon");case 9:this.$store.commit("userModule/changeIsNewUser",!1);case 10:t.next=15;break;case 12:t.prev=12,t.t0=t.catch(0),console.error("GetUserInfoController失败!");case 15:case"end":return t.stop()}},t,this,[[0,12]])}));return t}()}},470:function(t,e,s){e=t.exports=s(305)(!1),e.push([t.i,".allcover[data-v-add41f50]{position:absolute;top:0;right:0}.ctt[data-v-add41f50]{position:absolute;top:50%;left:50%;transform:translate(-50%,-50%)}.tb[data-v-add41f50]{position:absolute;top:50%;transform:translateY(-50%)}.lr[data-v-add41f50]{position:absolute;left:50%;transform:translateX(-50%)}",""])},488:function(t,e,s){var a=s(470);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);s(306)("13f91b3c",a,!0)},506:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"manage_page fillcontain"},[s("el-row",{staticStyle:{height:"100%"}},[s("el-col",{staticStyle:{"min-height":"100%","background-color":"#324057"},attrs:{span:4}},[s("el-menu",{staticClass:"el-menu-vertical-demo",staticStyle:{"border-right":"none"},attrs:{"default-active":t.defaultActive,backgroundColor:"#324057",textColor:"#E4E7ED","active-text-color":"#ffd04b",router:""}},[s("el-menu-item",{attrs:{index:"main"}},[s("i",{staticClass:"el-icon-menu"}),t._v("首页")]),t._v(" "),s("el-submenu",{attrs:{index:"2"}},[s("template",{slot:"title"},[s("i",{staticClass:"el-icon-document"}),t._v("论文与简历\n                        \n                        ")]),t._v(" "),s("el-menu-item",{attrs:{index:"paper"}},[s("i",{staticClass:"fa fa-handshake-o fa-fw"}),t._v("  论文指导")]),t._v(" "),s("el-menu-item",{attrs:{index:"resume"}},[s("i",{staticClass:"fa fa-id-card-o fa-fw"}),t._v("  简历编写\n                        "),s("sup",{staticClass:"el-badge__content is-fixed",staticStyle:{position:"relative"}},[t._v("beta")])])],2),t._v(" "),s("el-submenu",{attrs:{index:"3"}},[s("template",{slot:"title"},[s("i",{staticClass:"el-icon-star-on"}),t._v("信息\n                        "),s("sup",{directives:[{name:"show",rawName:"v-show",value:t.isNewUser,expression:"isNewUser"}],staticClass:"el-badge__content is-fixed",staticStyle:{position:"relative",border:"none"}},[t._v("new")])]),t._v(" "),s("el-menu-item",{attrs:{index:"infobroadcast"}},[s("i",{staticClass:"fa fa-toggle-right fa-fw"}),t._v("  信息展播\n                    ")]),t._v(" "),s("el-menu-item",{attrs:{index:"forum"}},[s("i",{staticClass:"fa fa-comments fa-fw"}),t._v("  交易广场\n                        "),s("sup",{directives:[{name:"show",rawName:"v-show",value:t.isNewUser,expression:"isNewUser"}],staticClass:"el-badge__content is-fixed is-dot",staticStyle:{position:"relative"}})])],2),t._v(" "),s("el-submenu",{attrs:{index:"4"}},[s("template",{slot:"title"},[s("i",{staticClass:"el-icon-setting"}),t._v("设置\n                       \n                    ")]),t._v(" "),s("el-menu-item",{attrs:{index:"edit"}},[s("i",{staticClass:"el-icon-edit-outline"}),t._v("完善个人信息\n                    ")])],2),t._v(" "),s("el-submenu",{attrs:{index:"5"}},[s("template",{slot:"title"},[s("i",{staticClass:"el-icon-warning"}),t._v("说明")]),t._v(" "),s("el-menu-item",{attrs:{index:"explain"}},[s("i",{staticClass:"fa fa-question fa-fw"}),t._v("  说明")])],2)],1)],1),t._v(" "),s("el-col",{staticStyle:{height:"100%",overflow:"auto","background-color":"rgb(246,247,254)"},attrs:{span:20}},[s("keep-alive",[s("router-view")],1)],1)],1)],1)},staticRenderFns:[]}}});