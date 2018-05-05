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

@RestController
@Component
@RequestMapping("/api/forum/toIndex")
public class ForumListController {
    @Autowired
    PostService postService;
    @RequestMapping(method = RequestMethod.GET)
    public HttpResponseObj toIndex(PageBean p){
        System.out.println("Uid="+p.getUid());
        try{
            PageBean<Post> pageBean = postService.listPostByTime(p.getCurPage());
            System.out.println(pageBean);
            return new HttpResponseObj(HttpStatus.OK,"It is first page",pageBean);

        }catch (Exception e){
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "Unexpected exception");
        }

    }
}
