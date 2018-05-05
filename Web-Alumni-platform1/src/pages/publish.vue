<template>
  <div>
    <jiaoyiHeader></jiaoyiHeader>
      <!-- 中间主体板块 -->
	<div class="main w clearfix">
		
        <input type="hidden" name="topic.tid" value="1" id="tid">
        <input type="hidden" name="user.uid" value="${sessionScope.uid}">

        <div class="pub-header"><span></span>&nbsp;话题发布</div>
        <div class="pub-title">
            <input type="text" name="title" placeholder="标题：一句话说明你遇到的问题或想分享的经验" v-model="postMessage.editorTitle">
        </div>

        <div class="pub-textarea">
            <!--这里直接引入这段代码就可以将编辑器引入了，当然你必须你npm install wangeditor后，或是配置文件中已经有了-->
            <div>
                <div id="editorElem" style="text-align:left"></div>
            </div>
            <button class="pub-button" @click="publish()">发布</button>
        </div>
		

	</div><!-- 主体结束 -->
    <div class="footer">
      <div class="w">SSE交易市场@2018 All Rights Reserved</div>
    </div>
</div>
 
</template>
<script>
import E from 'wangeditor'
import jiaoyiHeader from "./header/jiaoyiHeader.vue";
export default {
  name: 'editor',
  
  data: function() {
    return {
        postMessage:{
            editorContent:'',
            editorTitle:'',
            uid:""
        },
    };
  },
  components: {
    jiaoyiHeader
  },
  methods: {
      publish(){
          console.log(this.postMessage.editorContent+"和"+this.postMessage.editorTitle);
          this.$store.dispatch("forumModule/publish", {
            content: this.postMessage.editorContent, //注意':'前的content一定要与你对于的post中的属性名一样
            title: this.postMessage.editorTitle,
            uid:this.postMessage.uid
          });
      }
  },
  async mounted() {
      //这是wangEditor中给出的获取数据的方法
        var editor = new E('#editorElem')
        editor.customConfig.onchange = (html) => {
          this.postMessage.editorContent = html //这里获取了文本编辑器中的内容
        }
        editor.create()  

        try {
        //向后台获取阿里云文件服务器操作权限
        await this.$store.dispatch("GetAliClient", "sse-ustc-usericon");
        await this.$store.dispatch("userModule/GetUserIcon");
        } catch (error) {
        console.error("获取alitoken失败!");
        }
  }
};
</script>


<style lang="less" scoped>
@import "../style/base";
@import "../style/publish";
</style>
