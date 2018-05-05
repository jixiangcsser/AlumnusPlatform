<template>
  <div id="app" class="fillcontain">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "app",
  async mounted() {
    // 检查浏览器是否支持File API
    if (
      window.File &&
      window.FileReader &&
      window.FileList &&
      window.Blob &&
      window.localStorage
    ) {
    } else {
      try {
        await this.$confirm(
          "检测到您的浏览器不支持 HTML5,请您更换新版本的浏览器（ IE10以上,以免影响你的使用体验.谢谢合作!",
          "提示",
          {
            confirmButtonText: "确定",
            showCancelButton: false,
            type: "error",
            center: true
          }
        );
      } catch (error) {
        //此处error是对话框选择叉号的时候需要执行的内容
      }
    }
  }
};
</script>

<style lang="less">
@import "./style/common";
</style>
