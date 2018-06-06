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
import $ from 'jquery';
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
      async publish(){
          console.log(this.postMessage.editorContent+"和"+this.postMessage.editorTitle);
          await this.$store.dispatch("forumModule/publish", {
            content: this.postMessage.editorContent, //注意':'前的content一定要与你对于的post中的属性名一样
            title: this.postMessage.editorTitle,
            uid:this.postMessage.uid
          });
        await this.open();//弹出提示框提示发布成功
        
        this.$router.push("myPost");
        
          
      },
     async open() {
       this.$message({
          message: '发布成功，跳转用户页面',
          type: 'success'
        });
      },
      editorCreate(){
        //这是wangEditor中给出的获取数据的方法
        var editor = new E('#editorElem')
        var httpurl="http://localhost:9090"//这里部署上去需修改。
        editor.customConfig.showLinkImg = false//隐藏网络图片
        editor.customConfig.uploadImgShowBase64 = true;//添加上传图片的功能
        editor.customConfig.customUploadImg = function (files, insert) {
           
            var date = new FormData();
            date.append("file", files[0]);
            $.ajax({//请求后台
                type: "POST",
                url: httpurl + "/wangEditor/upload",
                data: date,
                dataType: 'json',
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (result) {
                    console.log(result);
                    insert(result.data);// insert 是获取图片 url 后，插入到编辑器的方法
                }
            })
        }
        editor.customConfig.onchange = (html) => {
          this.postMessage.editorContent = editor.txt.html() //这里获取了文本编辑器中的内容不加上<p>
          //console.log(this.postMessage.editorContent);
        }
        // 表情面板可以有多个 tab ，因此要配置成一个数组。数组每个元素代表一个 tab 的配置
        editor.customConfig.emotions = [
          {
              // tab 的标题
              title: '默认',
              // type -> 'emoji' / 'image'
              type: 'image',
              // content -> 数组
              content: [
                  {
                      alt: '[坏笑]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png'
                  },
                  {
                      alt: '[舔屏]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png'
                  },
                  {
                      alt: '[太开心]',
                      src: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/58/mb_thumb.gif'

                  },
                  {
                      alt: '[神马]',
                      src: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/60/horse2_thumb.gif'

                  },
                  {
                      alt: '[给力]',
                      src: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c9/geili_thumb.gif'
      

                  },
                  {
                      alt: '[拜拜]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/fd/2018new_baibai_org.png'

                  },
                  {
                      alt: '[右哼哼]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c1/2018new_youhengheng_org.png'

                  },
                  {
                      alt: '[左哼哼]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/43/2018new_zuohengheng_org.png'

                  },
                  {
                      alt: '[微笑]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e3/2018new_weixioa02_org.png'

                  },
                  {
                      alt: '[偷笑]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/71/2018new_touxiao_org.png'

                  },
                  {
                      alt: '[亲亲]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/2c/2018new_qinqin_org.png'

                  },
                  {
                      alt: '[笑而不语]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/2d/2018new_xiaoerbuyu_org.png'

                  },
                  {
                      alt: '[爱你]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f6/2018new_aini_org.png'

                  },
                  {
                      alt: '[鼓掌]',
                      src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6e/2018new_guzhang_thumb.png'

                  }
              ]
          },
         
        ]

       
        editor.create() ; 
      }
  },
  async mounted() {
      
        this.editorCreate();
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
