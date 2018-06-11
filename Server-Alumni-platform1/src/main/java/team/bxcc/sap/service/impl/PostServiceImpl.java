package team.bxcc.sap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.bxcc.sap.dao.mysql.MessageDao;
import team.bxcc.sap.dao.mysql.PostDao;
import team.bxcc.sap.dao.mysql.UserDao;
import team.bxcc.sap.dao.redis.PageBeanCacheDao;
import team.bxcc.sap.forum.model.PageBean;
import team.bxcc.sap.forum.model.Post;
import team.bxcc.sap.service.PostService;
import team.bxcc.sap.util.time.FormatTime;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static team.bxcc.sap.config.ConStants.OPERATION_CLICK_LIKE;
/**
 * 帖子操作 实现类
 *
 * @author JiXiang
 * @date 2018/5/13.
 */
@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostDao postDao;
    @Autowired
    PageBeanCacheDao pageBeanCacheDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    UserDao userDao;
    @Override
    public List<Post> getPostList(int uid) {

        return null;
    }

    /**
     * 发布一个梯子
     * @param post
     * @return
     */
    @Override
    public String PublishPost(Post post) {
        String id = UUID.randomUUID().toString().replace("-", "");

        post.setPid(id);
        post.setPublishTime(FormatTime.formatDate(new Date()));
        post.setReplyTime(FormatTime.formatDate(new Date()));
        post.setReplyCount(0);
        post.setLikeCount(0);
        post.setScanCount(0);
        //插入一条帖子记录
        try {
            boolean success=postDao.insertPost(post.getPid(),post.getTitle(),post.getContent(),post.getPublishTime(),
                    post.getReplyTime(),post.getReplyCount(),
                    post.getLikeCount(), post.getScanCount(),
                    post.getUid());
            if(success==true){
                return post.getPid();
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    /**
     * 列出当前叶梯子
     * @param curPage 请求的页面
     * @param readType 获取的类型
     * @return
     */
    @Override
    public PageBean<Post> listPostByreadType(int curPage,String readType) {

            int limit = 8;
            int offset = (curPage - 1) * limit;
            int allCount = postDao.selectPostCount();

            int allPage = 0;
            if (allCount <= limit) { //如果总数一页可以显示完全就显示
                allPage = 1;
            } else if (allCount / limit == 0) {//正好整除页面的大小
                allPage = allCount / limit;
            } else {
                allPage = allCount / limit + 1;
            }
            List<Post> postList = null;
            if (readType.equals("recent")) {
                postList = postDao.listPostByTime(offset, limit);
            } else if (readType.equals("heat")) {
                postList = postDao.listPostByHeat(offset, limit);
            }
            PageBean<Post> pageBean = new PageBean<>(allPage, curPage);
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

        List<Post> postList =postDao.listPostByUserTime(offset,limit,uid);
        PageBean<Post> pageBean=new PageBean<>(allPage,curPage);
        pageBean.setList(postList);
        return pageBean;

    }



    /**
     * 查看是否点赞
     * @param pid 帖子id
     * @param uid 浏览者的id
     * @return
     */
    @Override
    public Post getpost(String pid,String uid) {

        postDao.updateScanCount(pid);
        Post post=postDao.getpost(pid);
        //查看是否已经点过赞
        if(messageDao.selectLiked(pid,uid,OPERATION_CLICK_LIKE)!=null){
            post.setLiked("true");
        }
        else {
            post.setLiked("false");
        }
        return post;
    }

    /**
     * 点赞的操作
     * @param pid
     * @param replyUser_id
     * @return
     */
    @Override
    public boolean ajaxClickLike(String pid, String replyUser_id) {
        String mid = UUID.randomUUID().toString().replace("-", "");
        try {
            Post post = postDao.getTitleUidbyId(pid);
            String replyname = userDao.getNamebyId(replyUser_id);
            postDao.updateLikedCount(pid);
            messageDao.InsertMessage(mid, pid, post.getUid(), replyUser_id, post.getTitle(), replyname, OPERATION_CLICK_LIKE);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
