package team.bxcc.sap.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.forum.model.PageBean;
import team.bxcc.sap.forum.model.Post;
import team.bxcc.sap.service.PostService;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;

import java.lang.reflect.Method;
/**
 * 帖子的详细内容
 *
 * @author JiXiang
 * @date 2018/5/20.
 */
@RestController
@Component
@RequestMapping("/api/forumUser/toIndex")
public class ForumUserListController {
    @Autowired
    PostService postService;
    @RequestMapping(method = RequestMethod.GET)
    public HttpResponseObj toIndex(PageBean p){
        try{
            PageBean<Post> pageBean = postService.listPostByUserTime(p.getCurPage(),p.getUid());

            return new HttpResponseObj(HttpStatus.OK,"success",pageBean);

        }catch (Exception e){
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "Unexpected exception");
        }

    }
}
