<template>
<div>
<jiaoyiHeader></jiaoyiHeader>
<div class="main w clearfix">
		<div class="m-left">

			<div class="user-post">
				<div class="user-post-title"><span></span>&nbsp;发帖</div>
				<ul class="user-post-list">
					
						<li v-for= "post in posts">
							<span class="glyphicon glyphicon-file"></span>&nbsp;
							<a href="javascript:void(0)" @click="getPostContent(post.pid)">{{post.title}}</a>
							<span class="user-post-time">发布于 {{post.publishTime}}</span>
						</li>
					
				</ul>
			</div>
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

		<!--div class="m-right">
			<div class="user-attr">
				<span class="user-like-count">获赞：{{user.likeCount}}</span>
				<span class="user-post-count">发帖：{{user.postCount}}</span>

			</div>
			<div class="user-scan-count">个人主页被浏览${user.scanCount}次</div>
		</div-->

	</div><!-- 主体结束 -->
					

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
        user:'',
		
    };
  },
  
  async mounted() {
	  try {
      //向后台获取阿里云文件服务器操作权限
        await this.$store.dispatch("GetAliClient", "sse-ustc-usericon");
        await this.$store.dispatch("userModule/GetUserIcon");
		    this.getPageList(1);

    } catch (error) {
      console.error("GetUserInfoController失败!");
    }
	  

  },
  computed: {
	//总共的帖子的个数
	totalPosts:function(){
		return this.$store.getters["forumUserModule/pageBean"].allPage*8;
	},
	//当前的页数
	curPage:function(){
		return this.$store.getters["forumUserModule/pageBean"].curPage;
    },
    posts: function() { //获取每页的所有帖子信息，并将楼主的照片加上去
      return this.$store.getters["forumUserModule/pageBean"].list;
	},
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
        this.$store.dispatch("forumUserModule/toIndex", {
           curPage:val
        });
  },
  getPostContent(val){//点击进入帖子详细信息的方法！
		//建一个本地变量，可以在点击进入后获取用户的id.并且刷新了也不消失。比用参数在地址中传递要好
		window.localStorage.setItem("postPid",val);
		this.$router.push("Post")
	}
		
 }

};
</script>

<style lang="less">
@import "../style/base";
@import "../style/myProfile";

</style>
