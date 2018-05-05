<template>
  <div class="header clearfix">
    <div class="w" >
        <h1 class="logo"><a href="forum">SSE</a></h1>
        <ul class="left-nav">
            <li class="current-nav"><a href="main">首页</a></li>
            <li><a href="forum">话题</a></li>
            <li><a href="myPost">我的帖子</a></li>
            <li><a href="toMessage.do">消息</a></li>
        </ul>
        <el-dropdown @command="handleCommand" menu-align='start' style="margin-left: 400px; margin-top:10px">
          <img :src="defaultimg" class="avator" style="width:40px;height:40px;">
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="home">首页</el-dropdown-item>
            <el-dropdown-item command="singout">退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
    </div>
</div>
</template>
<script>
import cookie from "../../util/cookie";

export default {
  computed: {
      defaultimg: function() {
      return this.$store.getters["userModule/img_bs64_url"];
      },
      access_token: function() {
        return this.$store.getters.access_token;
      },
  },
  methods: {
     async handleCommand(command) {
      if (command == "home") {
         this.$router.push("/main");
      } else if (command == "singout") {
        cookie.delete("access_token", this.access_token);//这里吧cookie删除了！
        this.$store.commit("clear_accesstoken");
        this.$store.commit("userModule/clearInfomation");
        await this.controlFullscreen("您已成功注销,即将跳转至登陆页...", 1000);
        this.$router.push("/");
      }
    }
  }
}
</script>
<!--注意这里必须加上lang="less"-->
<style lang="less"> 
@import "../../style/base";
.avator {
  
  border-radius: 50%;
  margin-right: 37px;
  
}
</style>
