<template>
<div>
<div class="wrap">
    <div class="logo">
        <h1>404</h1>
        <p> 对不起 - 页面找不到!</p>
        <div class="sub">
            <p>
                <a href="javascript:void(0);" @click="backhome()"> 回到首页</a>
            </p>
        </div>
    </div>
</div>
</div>
</template>

<script>
export default {
  data: function() {
    return {};
  },
  methods: {
    backhome() {
      this.$router.push("/");
    }
  }
};
</script>


<style lang="less" scoped>
body {
  font-family: "Capriola", sans-serif;
}
body {
  background: #dad6cc;
}
.wrap {
  margin: 0 auto;
  width: 1000px;
}
.logo h1 {
  font-size: 200px;
  color: #ff7a00;
  text-align: center;
  margin-bottom: 1px;
  text-shadow: 4px 4px 1px white;
}
.logo p {
  color: #b1a18d;
  font-size: 20px;
  margin-top: 1px;
  text-align: center;
}
.logo p span {
  color: lightgreen;
}
.sub a {
  color: #ff7a00;
  text-decoration: none;
  padding: 5px;
  font-size: 13px;
  font-family: arial, serif;
  font-weight: bold;
}
.footer {
  color: white;
  position: absolute;
  right: 10px;
  bottom: 10px;
}
.footer a {
  color: #ff7a00;
}
</style>
