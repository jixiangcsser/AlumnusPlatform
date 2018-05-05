package team.bxcc.sap.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import team.bxcc.sap.forum.model.Post;
import team.bxcc.sap.service.PostService;
import team.bxcc.sap.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/forum/publishPost")
public class ForumIndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    /**
     * 发布内容
     * @param
     * @return
     */

    @RequestMapping(method = RequestMethod.POST)
    public String pulishPost(Post post){
        System.out.println("发帖的内容"+post.getContent());
        System.out.println("发帖的主题"+post.getTitle());
        String id=postService.PublishPost(post);
        return null;
    }

}
