<template>
<div>
    <jiaoyiHeader></jiaoyiHeader>
    <!-- 中间主体板块 -->
	<div class="main w clearfix" style="margin-bottom: 550px;">
		<div class="message-header"><span></span>&nbsp;消息列表</div>
    
        <li v-for= "(value,key) in MessageList">
            <div class="m-wrap">
                <div class="m-date">{{key}}</div>
                <ul class="m-list">
                    <li v-for= "item in value">
                     
                        <a href="toProfile.do?uid=${m.otherId}"><span>{{item.replyUsername}}</span></a>{{item.operation}}<a href="javascript:void(0)" @click="getPostContent(item.pid)"><span>{{item.displayedContent}}</span></a>
                    </li>
                
                </ul>
            </div>
        </li>
	</div><!-- 主体结束 -->
    <div class="footer">
      <div class="w">SSE交易市场@2018 All Rights Reserved</div>
    </div>

</div>
</template>

<script>
import E from 'wangeditor';
import jiaoyiHeader from "./header/jiaoyiHeader.vue";
import convertimg2bs64 from '../util/global/imgresolver';

export default {
  data() {
    return {
		
        replyMessage:"",
        PostId:'',
        post:'',
       
    };
  },
  computed: {
	
    
    MessageList: function(){//查看所有回复的列表！
        return this.$store.getters["forumModule/MessageList"];
    },
    access_token:function(){
        return this.$store.getters.access_token;
    },
  },
  components: {
    jiaoyiHeader
  },
  methods: {
    cliklike(){
        this.store.dispatch
    },
    async getMessageContent(){
  
  
	   var code=await this.$store.dispatch("forumModule/getMessageContent", {
			
        });
       
       /* var myPost=await this.$store.getters["forumModule/post"];
        myPost.userName=myPost.user.user_name;//很重要这一步！丢了话页面就不一定能显示了。
        this.PostId=myPost.pid;

        var url= this.$store.getters.ali_client.signatureUrl(myPost.user.id);//根据用户id获取你的头像存储的地址
        this.post=myPost; */
       
	},
	getPostContent(val){//点击进入帖子详细信息的方法！
        //建一个本地变量，可以在点击进入后获取用户的id.并且刷新了也不消失。比用参数在地址中传递要好
        if(window.localStorage.getItem("postPid")==null){
            
            window.localStorage.setItem("postPid",val);
        }
		
		
		this.$store.dispatch("forumModule/getPostContent", {
			pid:val
		});
		this.$router.push("Post")
	}
    
   
		
    },
  async mounted() {
       
	    try {   
        //向后台获取阿里云文件服务器操作权限
            await this.$store.dispatch("GetAliClient", "sse-ustc-usericon");
            await this.$store.dispatch("userModule/GetUserIcon");
            this.getMessageContent()
           
        } catch (error) {
            console.error("GetUserInfoController失败!");
        }
    },
    

};
</script>

<style lang="less">

@import "../style/base";

@import "../style/message";



</style>