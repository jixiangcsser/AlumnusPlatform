<template>
    <div class="header_container" style="background-color:#DCDFE6;">
		<el-breadcrumb separator="/">
			<el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in $route.meta.info" :item="item" :index="index" :key="index">{{item}}</el-breadcrumb-item>
		</el-breadcrumb>
		<el-dropdown @command="handleCommand" menu-align='start' style="margin-right: 37px;">
			<img :src="defaultimg" class="avator" style="width:40px;height:40px;">
			<el-dropdown-menu slot="dropdown">
				<el-dropdown-item command="home">首页</el-dropdown-item>
				<el-dropdown-item command="singout">退出</el-dropdown-item>
			</el-dropdown-menu>
		</el-dropdown>
    </div>
</template>

<script>
import cookie from "../../util/cookie";

export default {
  computed: {
    access_token: function() {
      return this.$store.getters.access_token;
    },
    defaultimg: function() {
      return this.$store.getters["userModule/img_bs64_url"];
    }
  },
  created() {},
  methods: {
    async handleCommand(command) {
      if (command == "home") {
        // this.$router.push("/main");
        // console.log(this.defaultimg);
        // console.log(this.access_token);
      } else if (command == "singout") {
        cookie.delete("access_token", this.access_token);
        this.$store.commit("clear_accesstoken");
        this.$store.commit("userModule/clearInfomation");
        await this.controlFullscreen("您已成功注销,即将跳转至登陆页...", 1000);
        this.$router.push("/");
      }
    }
  }
};
</script>

<style lang="less">
@import "../../style/mixin";
.header_container {
  background-color: #eff2f7;
  height: 60px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-left: 20px;
}
.avator {
  .wh(36px, 36px);
  border-radius: 50%;
  margin-right: 37px;
}
.el-dropdown-menu__item {
  text-align: center;
}
</style>
