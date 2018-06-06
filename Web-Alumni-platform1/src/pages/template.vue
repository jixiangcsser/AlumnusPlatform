<template>
<div>
   页面刷新中.......
</div>
</template>

<script>

export default {
  data: function() {
    return {};
  },
  
  methods: {},
  mounted(){
      this.$router.replace("Post");
  }
};
</script>


<style lang="less" scoped>
@import "../style/mixin";
</style>
