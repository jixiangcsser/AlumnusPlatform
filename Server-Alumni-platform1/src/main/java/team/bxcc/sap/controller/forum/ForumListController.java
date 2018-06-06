package team.bxcc.sap.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.forum.model.PageBean;
import team.bxcc.sap.forum.model.Post;
import team.bxcc.sap.service.PostService;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;

import javax.servlet.http.HttpServletRequest;
/**
 * forum.vue页面的获取控制
 *
 * @author JiXiang
 * @date 2018/5/30.
 */
@RestController
@Component
@RequestMapping("/api/forum/toIndex")
public class ForumListController {
    @Autowired
    PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpResponseObj toIndex(PageBean p,String readType){
        try{

            PageBean<Post> pageBean = postService.listPostByreadType(p.getCurPage(),readType);

            return new HttpResponseObj(HttpStatus.OK,"It is first page",pageBean);

        }catch (Exception e){
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "Unexpected exception");
        }

    }

}
