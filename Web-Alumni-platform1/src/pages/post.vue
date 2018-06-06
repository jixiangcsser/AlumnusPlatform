<template>
<div>
    <jiaoyiHeader></jiaoyiHeader>
    <!-- 中间主体板块 -->
	<div class="main w clearfix">

		<!-- 主体左部分 -->
		<div class="main-left">
			
			<!-- 帖子内容板块 -->
			<div class="post-content">
				<div class="post-title">
					<span class="glyphicon glyphicon-th"></span>&nbsp;{{post.title}}
				</div>
				<div class="post-user clearfix">
					<div class="user-image"><a href="javascript:void(0)"><img :src="post.imgUrl" /></a></div>
					<div class="user-info">
						<div class="user-name">{{post.userName}}</div>
						<div class="post-time">编辑于 {{post.publishTime}}</div>
					</div>
					<div class="other-count">
						<span class="reply-count"><a href="#">回复 {{post.replyCount}}</a></span>&nbsp;
                        
                        <span v-if="liked ==false" class="up-count" ><a href="javscript:void(0)" @click="clicklike()">赞 {{post.likeCount}}</a></span>
                    
                        <span class="up-count" v-else><a style="color:#2e6da4;">已赞 {{post.likeCount}}</a></span>
                        
						<span class="scan-count"><a href="#">浏览 {{post.scanCount}}</a></span>
					</div>
				</div>
				<div class="post-desc">
					    <p v-html='post.content'></p>
				</div>
			</div>



			<!-- 帖子回复内容板块 -->
			<div class="post-reply">
				<!-- 回复区标题 -->
				<div class="post-reply-title">
					<h2 class="reply-count"><span class="glyphicon glyphicon-th"></span>&nbsp;{{post.replyCount}}条回帖</h2>
					<a href="#reply-area">回复</a>
				</div>
				<!-- 回复区内容 -->
				<div class="post-reply-content">
					<!-- 回复条目 -->
                    <li v-for= "reply in replyList">
                    
                        <div class="post-reply-item clearfix">
                            <div class="item-image"><a href="javascript:void(0)"><img :src="reply.imgUrl" /></a></div>

                            <div class="item-info">
                                <div class="item-user-name"><a href="#">{{reply.user.user_name}}</a></div>
                                <div class="item-content" v-html='reply.content'>
                                    
                                </div>
                                
                                <div class="item-date">发表于 {{reply.replyTime}}</div>
                                
                            </div>
          

                        </div>
                     </li> 
				</div>
			</div>
            <div class="pub-textarea">
            <!--这里直接引入这段代码就可以将编辑器引入了，当然你必须你npm install wangeditor后，或是配置文件中已经有了-->
            <div>
                <div id="editor" style="text-align:left"></div>
            </div>
                <a href="javascript:void(0)" class="pub-button" @click="reply()">回贴</a>
           
            </div>
            <el-col :span="20" style="height: 100%;overflow: auto; background-color: rgb(246,247,254);">
            <keep-alive>
                <router-view></router-view>
            </keep-alive>
            </el-col>

			

		</div>
	</div>
					
    
    <div class="footer">
        <div class="w">SSE交易市场@2018 All Rights Reserved</div>
    </div>
</div>
</template>

<script>
import E from 'wangeditor';
import jiaoyiHeader from "./header/jiaoyiHeader.vue";
import convertimg2bs64 from '../util/global/imgresolver';
import $ from 'jquery';
export default {
  data() {
    return {
		
        replyMessage:"",
        PostId:'',
        post:'',
        liked:false
        
    };
  },
  computed: {
	
	
    
    replyList: function(){//查看所有回复的列表！
        let replyList=this.$store.getters["forumModule/replyList"]
       
        let that=this;
        replyList.forEach(function(reply){//这里我给每个post的转换成字符的图片赋值
            //reply.imgUrl=reply.user.headUrl;
            let url= that.$store.getters.ali_client.signatureUrl(reply.user.id);//根据用户id获取你的头像存储的地址
            if(reply.user.headUrlFlag==0){
                reply.imgUrl='/static/img/default.jpg'
            }
            else{
                reply.imgUrl=url;
            }  
        });
        return replyList;
    },
    access_token:function(){
        return this.$store.getters.access_token;
    },
  },
  components: {
    jiaoyiHeader
  },
  methods: {
    clicklike(){
        this.liked=true;
        this.post.likeCount=this.post.likeCount+1;
        this.$store.dispatch("forumModule/addClickCount",{
           pid: this.post.pid
        })
        //this.store.dispatch
    },
    async getPostContent(val){
  
	   await this.$store.dispatch("forumModule/getPostContent", {
			pid:val
        });
       
        var myPost=await this.$store.getters["forumModule/post"];
        myPost.userName=myPost.user.user_name;//很重要这一步！丢了话页面就不一定能显示了。
        this.PostId=myPost.pid;
        console.log(myPost.liked);

        if(myPost.liked=="true"){//这里之所以不直接赋值，因为后台传来的是string类型，我这里是boolean类型
            this.liked=true;
        }
        var url= this.$store.getters.ali_client.signatureUrl(myPost.user.id);//根据用户id获取你的头像存储的地址

        convertimg2bs64(url).then(function(value){ //返回一个promise的对象，所以一旦成功返回这个值
            console.log("获取成功");
            myPost.imgUrl=value;
            
        },function(error){//失败返回
            console.log("获取失败");
            myPost.imgUrl="/static/img/default.jpg";
        }
        ) 
        this.post=myPost; 
       
	},
	
    async reply(){
       
        var user_id=JSON.parse(atob(this.access_token.split(".")[0])).user_id
        var post_id=this.post.pid;
        var message=this.replyMessage;
        var res=await this.$store.dispatch("forumModule/reply",
                        {
                            content:message,
                            user_id:user_id,
                            post_id:post_id
                        });
        if(res.code==200){//如果成功就刷新一下页面重新请求一下回复。

            console.log("code="+res.code);
            this.$store.dispatch("forumModule/getPostContent", {
                            pid:post_id
                        });
            this.$router.replace("template");//不要用this.$router.push，这样产生后退时无法推出这个页面
            
        }
        else{
            //添加错误提示
        }
        
    },
    editorCreate(){
        //这是wangEditor中给出的获取数据的方法
        var editor = new E('#editor')
        console.log("shaqing");
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
          this.replyMessage = editor.txt.html() //这里获取了文本编辑器中的内容不加上<p>
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
        //wangeditor编辑器的使用。
        this.editorCreate();
        // var s=this.$route.params.id;//获取从forum中ip地址中带的参数！
	    try {   
        //向后台获取阿里云文件服务器操作权限
            await this.$store.dispatch("GetAliClient", "sse-ustc-usericon");
            await this.$store.dispatch("userModule/GetUserIcon");
            var s =window.localStorage.getItem("postPid");
            this.getPostContent(s);  
        } catch (error) {
            console.error("GetUserInfoController失败!");
        }
    },
    

};
</script>

<style lang="less">

@import "../style/base";
@import "../style/post";
@import "../style/publish";



</style>
