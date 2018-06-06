package team.bxcc.sap.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.forum.model.Post;
import team.bxcc.sap.service.PostService;
import team.bxcc.sap.service.UserService;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;

import javax.servlet.http.HttpServletRequest;
/**
 * 帖子的详细内容
 *
 * @author JiXiang
 * @date 2018/5/30.
 */
@RestController
@RequestMapping("/api/forum/publishPost")
public class ForumIndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    /**
     * 添加的发布表中
     * @param
     * @return
     */

    @RequestMapping(method = RequestMethod.POST)
    public HttpResponseObj pulishPost(Post post){
        try {
            if(postService.PublishPost(post)!=null){
                return new HttpResponseObj(HttpStatus.OK,"success");
            }
            else {
                return new HttpResponseObj(HttpStatus.DATABASE_EXCEPTION,"database Exception");
            }
        }catch (Exception e){
            return new HttpResponseObj(HttpStatus.UNEXPECTED,"UnExpect Error");
        }

        //return ;//这里不好还需要返回给httpResponseObj的内容，前端处理，
    }

    /**
     * 获取发布内容
     * @param
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public HttpResponseObj getPulishPost(Post post,String uid){
        System.out.println(post+uid);
        try {
            Post postReturn=postService.getpost(post.getPid(),uid);
            if(postReturn!=null) {
                return new HttpResponseObj(HttpStatus.OK, "success", postReturn);
            }
            else {
                return new HttpResponseObj(HttpStatus.DATABASE_EXCEPTION,"databaseException");
            }
        }catch (Exception e){
            return new HttpResponseObj(HttpStatus.UNEXPECTED,"Error");
        }

    }

    /**
     * 异步点赞
     * @param pid
     * @param uid
     * @return
     */
    @RequestMapping(value = "/ajaxClickLike")
    public HttpResponseObj ajaxClickLike(String pid, String uid){
        System.out.println("没进来吗？");
        try {
            if(postService.ajaxClickLike(pid,uid)){

                return new HttpResponseObj(HttpStatus.OK,"Like Success");
            }else {
                return new HttpResponseObj(HttpStatus.DATABASE_EXCEPTION,"database exception");
            }
        }catch (Exception e){
            return new HttpResponseObj(HttpStatus.UNEXPECTED,"未知错误");
        }

    }

}
