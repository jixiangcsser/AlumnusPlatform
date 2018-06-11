<template>
<div class="manage_page fillcontain">
    <el-row style="height: 100%;">
        <el-col :span="4" style="min-height: 100%; background-color: #324057;">
            <el-menu :default-active="defaultActive" class="el-menu-vertical-demo" style="border-right:none;" backgroundColor="#324057" textColor="#E4E7ED" active-text-color="#ffd04b"router>
                <el-menu-item index="main">
                    <i class="el-icon-menu"></i>首页</el-menu-item>
                <el-submenu index="2">
                    <template slot="title">
                        <i class="el-icon-document"></i>论文与简历
                        
                        </template>
                    <el-menu-item index="paper">
                        <i class="fa fa-handshake-o fa-fw"></i>&nbsp; 论文指导</el-menu-item>
                    <el-menu-item index="resume">
                        <i class="fa fa-id-card-o fa-fw"></i>&nbsp; 简历编写
                        <sup class="el-badge__content is-fixed" style="position:relative;">beta</sup>
                        </el-menu-item>
                </el-submenu>
                <el-submenu index="3">
                    <template slot="title">
                        <i class="el-icon-star-on"></i>信息
                        <sup v-show="isNewUser" class="el-badge__content is-fixed" style="position:relative;border:none;">new</sup>
                    </template>
                    <el-menu-item index="infobroadcast">
                        <i class="fa fa-toggle-right fa-fw"></i>&nbsp; 信息展播
                    </el-menu-item>
                    <el-menu-item index="forum">
                        <i class="fa fa-comments fa-fw"></i>&nbsp; 交易广场
                        <sup v-show="isNewUser" class="el-badge__content is-fixed is-dot" style="position:relative;"></sup>
                        </el-menu-item>

                </el-submenu>

                <el-submenu index="4">
                    <template slot="title">
                        <i class="el-icon-setting"></i>设置
                       
                    </template>
                    <el-menu-item index="edit">
                        <i class="el-icon-edit-outline"></i>完善个人信息
                    </el-menu-item>
                </el-submenu>
                <el-submenu index="5">
                    <template slot="title">
                        <i class="el-icon-warning"></i>说明</template>
                    <el-menu-item index="explain">
                        <i class="fa fa-question fa-fw"></i>&nbsp; 说明</el-menu-item>
                </el-submenu>
            </el-menu>
        </el-col>
        <el-col :span="20" style="height: 100%;overflow: auto; background-color: rgb(246,247,254);">
            <keep-alive>
                <router-view></router-view>
            </keep-alive>
        </el-col>
    </el-row>
</div>
</template>

<script>
export default {
  computed: {
    defaultActive: function() {
      return this.$route.path.replace("/", "");
    },
    access_token: function() {
      return this.$store.getters.access_token;
    },
    isNewUser: function() {
      return this.$store.getters["userModule/isNewUser"];
    }
  },
  methods: {},
  async mounted() {
    try {
      //获取阿里云文件服务器操作权限
      await this.$store.dispatch("GetAliClient", "sse-ustc-usericon");
      //获取用户基本信息
      var res = await this.$store.dispatch(
        "userModule/GetUserInfoController",
        true
      );

      if (res.code == 200) {
        await this.$store.dispatch("userModule/GetUserIcon");
        this.$store.commit("userModule/changeIsNewUser", false);
      }
    } catch (error) {
      console.error("GetUserInfoController失败!");
    }
  }
};
</script>


<style lang="less" scoped>
@import "../style/mixin";
</style>
