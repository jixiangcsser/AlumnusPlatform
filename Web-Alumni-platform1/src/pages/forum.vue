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
						<a href="#" class="post-choice-current">最近</a>
						<a href="#">最热</a>
						<a href="#" class="post-choice-last">精华</a>
					</div>

					<ul class="post-list">
						<li v-for= "post in posts">
							
							<div class="post-image">
								<img :src="post.imgUrl" />
							</div>
							<div class="post-content">
								<div class="post-title"><a href="toPost.do?pid=${post.pid}">{{post.title}}</a></div>
								<div class="post-other">
									<div class="post-other-left">
										<span class="post-username"><a href="toProfile.do?uid=${post.user.uid}">{{post.user.user_name}}</a></span>
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
				<div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;近期活跃用户</div></div>
				<ul class="hot-user-list">
					<c:forEach items="${hotUserList}" var="user">
						<li class="clearfix">
							<a href="toProfile.do?uid=${user.uid}" class="hot-user-image"><img src="${user.headUrl}"></a>
							<a href="toProfile.do?uid=${user.uid}" class="hot-user-name">${user.username}</a>
						</li>
					</c:forEach>
				</ul>
			</div>

			<div class="hot-user">
				<div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;近期加入用户</div></div>
				<ul class="hot-user-list">
					<c:forEach items="${userList}" var="user">
						<li class="clearfix">
							<a href="toProfile.do?uid=${user.uid}" class="hot-user-image"><img src="${user.headUrl}"></a>
							<a href="toProfile.do?uid=${user.uid}" class="hot-user-name">${user.username}</a>
						</li>
					</c:forEach>
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
		
    };
  },
  
  async mounted() {
	  try {
			//向后台获取阿里云文件服务器操作权限
			console.log("将获取到了阿里权限")
			await this.$store.dispatch("GetAliClient", "sse-ustc-usericon");
			console.log("获取到了阿里权限")
     
      
			
      
        await this.$store.dispatch("userModule/GetUserIcon");
				this.$store.commit("userModule/changeIsNewUser", false);
				this.getPageList(1);//这个必须放到异步中！不要放到外面
      
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
				convertimg2bs64(url).then(function(value){ //返回一个promise的对象，所以一旦成功返回这个值
				post.imgUrl=value;
			},function(error){//失败返回
				post.imgUrl="/static/img/default.jpg";
			}
			)   		
	  })
	
      return myPosts;
	},

	//总共的帖子的个数
	totalPosts:function(){
		console.log(this.$store.getters["forumModule/pageBean"].allPage+"总页数");
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
        this.getPageList(val);
		},
		getPageList(val){
			this.$store.dispatch("forumModule/toIndex", {
							curPage:val
				});
		},
		
 }

};
</script>

<style lang="less">
@import "../style/base";

</style>
