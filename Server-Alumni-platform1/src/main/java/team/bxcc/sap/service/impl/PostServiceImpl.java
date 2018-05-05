package team.bxcc.sap.service.impl;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.bxcc.sap.dao.mysql.PostDao;
import team.bxcc.sap.forum.model.PageBean;
import team.bxcc.sap.forum.model.Post;
import team.bxcc.sap.service.PostService;
import team.bxcc.sap.util.time.FormatTime;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostDao postDao;
    @Override
    public List<Post> getPostList(int uid) {

        return null;
    }

    @Override
    public String PublishPost(Post post) {
        String id = UUID.randomUUID().toString().replace("-", "");
        System.out.println("uid="+post.getUid());
        post.setPid(id);
        post.setPublishTime(FormatTime.formatDate(new Date()));
        post.setReplyTime(FormatTime.formatDate(new Date()));
        post.setReplyCount(0);
        post.setLikeCount(0);
        post.setScanCount(0);
        //插入一条帖子记录
        postDao.insertPost(post.getPid(),post.getTitle(),post.getContent(),post.getPublishTime(),
                post.getReplyTime(),post.getReplyCount(),
                post.getLikeCount(), post.getScanCount(),
                post.getUid());
        return post.getPid();
    }

    @Override
    public PageBean<Post> listPostByTime(int curPage) {
        int limit =8;
        int offset =(curPage-1)* limit;
        int allCount =postDao.selectPostCount();
        int allPage =0;
        if(allCount<=limit){ //如果总数一页可以显示完全就显示
            allPage=1;
        }else if(allCount/limit ==0){//正好整除页面的大小
            allPage=allCount/limit;
        }else {
            allPage=allCount/limit+1;
        }

        List<Post> postList =postDao.listPostByTime(offset,limit);

        PageBean<Post> pageBean=new PageBean<>(allPage,curPage);
        pageBean.setList(postList);
        return pageBean;
    }

    @Override
    public PageBean<Post> listPostByUserTime(int curPage, String uid) {
        int limit =8;
        int offset =(curPage-1)* limit;
        int allCount =postDao.selectPostCountByUid(uid);
        int allPage =0;
        if(allCount<=limit){ //如果总数一页可以显示完全就显示
            allPage=1;
        }else if(allCount/limit ==0){//正好整除页面的大小
            allPage=allCount/limit;
        }else {
            allPage=allCount/limit+1;
        }
        System.out.println("78");
        List<Post> postList =postDao.listPostByUserTime(offset,limit,uid);
        System.out.println("post"+postList);

        PageBean<Post> pageBean=new PageBean<>(allPage,curPage);
        pageBean.setList(postList);
        return pageBean;

    }
}
