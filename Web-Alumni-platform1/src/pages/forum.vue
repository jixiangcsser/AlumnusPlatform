<template>
<div>
<jiaoyiHeader></jiaoyiHeader>
<div class="main w clearfix">
		<div class="main-left">
			<div class="share">
				<div class="share-left"><span></span>&nbsp;分享与提问</div>
				<div class="share-right">
					<a href="publish"><span class="glyphicon glyphicon-pencil"></span>&nbsp;我要发布</a>
				</div>
			</div>
			<div class="post">
				<div class="post-wrap">
					<div class="post-choice">
						<a href="javascript:void(0)" v-bind:class="{'post-choice-current':recentClass}" @click="changeToRecent()">最近</a>
						<a href="javascript:void(0)" v-bind:class="{'post-choice-current':heatClass}" @click="changeToheat()">最热</a>
						<a href="javascript:void(0)" class="post-choice-last" @click="unSupportNow()">精华</a>
					</div>

					<ul class="post-list">
						<li v-for= "post in posts">
							
							<div class="post-image">
								<img :src="post.imgUrl" />
							</div>
							<div class="post-content">
								<div class="post-title">
									<!--这里使用javascript:void(0)，就是为了出现ß箭头-->
									<a href="javascript:void(0);" @click="getPostContent(post.pid)">
										{{post.title}}</a>
									<!--<router-link :to="{ name:'PostPage',params:{id:post.pid}}">
										{{post.title}}
									</router-link>-->
								</div>
								<div class="post-other">
									<div class="post-other-left">
										<span class="post-username"><a href="javascript:void(0)">{{post.user.user_name}}</a></span>
										<span>&nbsp;发表</span>
										<span class="post-time">&nbsp;{{post.publishTime}}</span>
										<span>&nbsp;最后回复&nbsp;</span>
										<span class="post-reply-time">{{post.replyTime}}</span>
									</div>
									<div class="post-other-right">
										<span class="post-reply-count">回复 {{post.replyCount}}</span>&nbsp;
										<span class="post-like-count">赞 {{post.likeCount}}</span>&nbsp;
										<span class="post-scan-count">浏览 {{post.scanCount}}</span>
									</div>
								</div>
							</div>
						</li>
						
					</ul>
					<!--下面默认一页就8个内容，因为我传输过来的也是8个帖子-->
					<div class="block">
						<el-pagination
						@size-change="handleSizeChange"
						@current-change="handleCurrentChange"
						:current-page.sync="startPage"
						:page-size="8"
						layout="prev, pager, next, jumper"
						:total="totalPosts">
						</el-pagination>
					</div>
				</div>
			</div>
		</div>
		<div class="main-right">
			
			<div class="hot-user">
				<div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;活跃用户</div></div>
				<ul class="hot-user-list">
					
					<li class="clearfix" v-for= "hotUser in hotUsers">
						<a href="toProfile.do?uid=${user.uid}" class="hot-user-image"><img :src="hotUser.imgUrl" /></a>
						<a href="toProfile.do?uid=${user.uid}" class="hot-user-name">{{hotUser.user_name}}</a>
					</li>
					
				</ul>
			</div>

			<div class="hot-user">
				<div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;近期加入用户</div></div>
				<ul class="hot-user-list">
					<li class="clearfix" v-for= "RecentUser in RecentUsers">
						
						<a href="toProfile.do?uid=${user.uid}" class="hot-user-image"><img :src="RecentUser.imgUrl" /></a>
						<a href="toProfile.do?uid=${user.uid}" class="hot-user-name">{{RecentUser.user_name}}</a>
					</li>
				
				</ul>
			</div>
		</div>
    
	</div>
	

<div class="footer">
      <div class="w">SSE交易市场@2018 All Rights Reserved</div>
    </div>
</div>
</template>

<script>
import jiaoyiHeader from "./header/jiaoyiHeader.vue";
//import { functionDeclaration } from 'babel-types';
import convertimg2bs64 from '../util/global/imgresolver'
export default {
  data() {
    return {
		startPage: 1,
        currentPage2: 5,
        currentPage3: 1,
		currentPage4: 4,
		//readType:'',// heatSlect,recentSelct
		readClass:'',//样式的选择
		recentClass:true,//这里为false时不显示那个样式
		heatClass:false,
    };
  },
  
  async mounted() {
	  try {
		//向后台获取阿里云文件服务器操作权限
		
		await this.$store.dispatch("GetAliClient", "sse-ustc-usericon");
		
        await this.$store.dispatch("userModule/GetUserIcon");
		sessionStorage.setItem("readType",'recent');//我让页面重新加载的时候缓存改为最近，防止选页时出现错误，选择成为最近的
		this.getPageList(1,'recent');
		this.getHotUserList(5);
		
		this.getRecentUserList(5);
    } catch (error) {
      console.error("GetUserInfoController失败!");
    }
	  

  },
  computed: {
	posts: function() { //获取每页的所有帖子信息，并将楼主的照片加上去
		
		var myPosts=this.$store.getters["forumModule/pageBean"].list;
		
		let that=this;
		myPosts.forEach(function(post){//这里我给每个post的转换成字符的图片赋值
			var url=that.$store.getters.ali_client.signatureUrl(post.user.id);
			
			if(post.user.headUrlFlag==0){
                post.imgUrl='/static/img/default.jpg'
            }
            else{
                post.imgUrl=url;
            }  
			
			 		
		})
		
		return myPosts;
	},
	//近期加入用户

	RecentUsers: function(){
		var RecenetUsersList=this.$store.getters["forumModule/recentUsers"];
		
		let that=this;
		RecenetUsersList.forEach(function(recentUser){//这里我给每个post的转换成字符的图片赋值
			//reply.imgUrl=reply.user.headUrl;
            let url= that.$store.getters.ali_client.signatureUrl(recentUser.id);//根据用户id获取你的头像存储的地址
            if(recentUser.headUrlFlag==0){
                recentUser.imgUrl='/static/img/default.jpg'
            }
            else{
                recentUser.imgUrl=url;
            }  
        });
        return RecenetUsersList;
	},
	//获取活跃用户的个数。
	hotUsers: function(){
		var hotUsersList=this.$store.getters["forumModule/hotUsers"];
		let that=this;
		hotUsersList.forEach(function(hotUser){//这里我给每个post的转换成字符的图片赋值
			//reply.imgUrl=reply.user.headUrl;
            let url= that.$store.getters.ali_client.signatureUrl(hotUser.id);//根据用户id获取你的头像存储的地址
            if(hotUser.headUrlFlag==0){
                hotUser.imgUrl='/static/img/default.jpg'
            }
            else{
                hotUser.imgUrl=url;
            }  
        });
        return hotUsersList;
	},
	//总共的帖子的个数
	totalPosts:function(){
		return this.$store.getters["forumModule/pageBean"].allPage*8;
	},
	//当前的页数
	curPage:function(){
		return this.$store.getters["forumModule/pageBean"].curPage;
	}
  },
  components: {
    jiaoyiHeader
  },
  methods: {
    handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
    },
	handleCurrentChange(val) {//当你选择页面的时候的应该从新请求
		var readType=sessionStorage.getItem("readType");
		
        this.getPageList(val,readType);
	},
	getPageList(val,readtype){
		this.$store.dispatch("forumModule/toIndex", {
			curPage:val,
			readType:readtype
		});
	},
	getHotUserList(val){
		this.$store.dispatch("forumModule/getHotUserList", {
			count:val //后台接受的也是int 类型的变量名count.
		});
	},
	getRecentUserList(val){
		this.$store.dispatch("forumModule/getRecentUserList", {
			count:val //后台接受的也是int 类型的变量名count.
		});
	},
	getPostContent(val){//点击进入帖子详细信息的方法！
		//建一个本地变量，可以在点击进入后获取用户的id.并且刷新了也不消失。比用参数在地址中传递要好
		window.localStorage.setItem("postPid",val);
		
		
		this.$router.push("Post")
	},
	changeToheat(){
		sessionStorage.setItem("readType",'heat');//设置获取pageList的类型是heat类型。
		this.recentClass=false;
		this.heatClass=true;
		this.startPage=1;//这里是让页面无论在几，只要获取类型改变就让下面的页面显示为1，
		this.getPageList(1,'heat');//点击后就跳到最热页面。
	},
	changeToRecent(){
		sessionStorage.setItem("readType",'recent');//设置获取pageList的类型是heat类型。
		this.recentClass=true;
		this.heatClass=false;
		this.startPage=1;
		this.getPageList(1,'recent');//点击后就跳到最近页面。
	},
	unSupportNow(){
		this.$notify.info({
          title: '消息',
          message: '学长还没想好怎么算是精华？'
        });
	}
		
 }

};
</script>

<style lang="less">
@import "../style/base";

</style>
