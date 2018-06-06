package team.bxcc.sap.service;

import org.springframework.beans.factory.annotation.Autowired;
import team.bxcc.sap.forum.model.PageBean;
import team.bxcc.sap.forum.model.Post;

import java.util.List;

/**
 * @Author: JiXiang
 * @Description: 贴子展示类
 * @Date: Created on 14:21 2018/5/1.
 */
public interface PostService {
    //根据uid,获取帖子列表
    List<Post> getPostList(int uid);
    //发布帖子
    String PublishPost(Post post);
    //根据时间列出帖子
    PageBean<Post> listPostByreadType(int curPage,String readType);
    // 根据用户和时间列出帖子
    PageBean<Post> listPostByUserTime(int CurPage,String Uid);

    //根据pid获取用户的帖子信息
    Post getpost(String pid,String uid);
    boolean ajaxClickLike(String pid,String uid);
}
