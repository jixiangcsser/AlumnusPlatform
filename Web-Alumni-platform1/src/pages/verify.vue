<template>
<div>
<div class="wrap">
    <div class="logo">
        <h1>恭喜你，激活成功</h1>
        <p> {{second}} 秒后跳至登录页面！</p>
    </div>
</div>
</div>
</template>

<script>
export default {
  data: function() {
    return {
      second: 5,
      Interval: null
    };
  },
  methods: {
    endInterval() {
      if (this.second == 0) {
        clearInterval(this.Interval);
        this.$router.push("/");
      } else {
        this.second = this.second - 1;
      }
    }
  },
  mounted() {
    //设置定时器，每1秒刷新一次
    this.Interval = setInterval(this.endInterval, 1000);
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
  font-size: 50px;
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
