package team.bxcc.sap.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.bxcc.sap.forum.model.Reply;
import team.bxcc.sap.service.ReplyService;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;
import java.util.List;
import static team.bxcc.sap.config.HttpStatus.DATABASE_EXCEPTION;
import static team.bxcc.sap.config.HttpStatus.OK;
/**
 * 用户回复信息的控制器
 *
 * @author JiXiang
 * @date 2018/5/30.
 */
@RestController
@Component
@RequestMapping("/api/forum/reply")
public class ForumReplyController {
    @Autowired
    ReplyService replyService;

    //添加用户的回复
    @RequestMapping(method=RequestMethod.POST)
    public HttpResponseObj reply( Reply reply,@RequestParam String user_id,@RequestParam String post_id){//传过来的有用户的id,和post的ID，还有评价的内容。

        if(replyService.addreply(reply,user_id,post_id)) {

            return new HttpResponseObj(OK, "add reply success");
        }
        return new HttpResponseObj(DATABASE_EXCEPTION, "add reply failure");

    }
    @RequestMapping(method = RequestMethod.GET)
    public HttpResponseObj getReply(@RequestParam String pid){

        List<Reply> replyList=replyService.getReply(pid);

        return new HttpResponseObj(OK,"get reply success",replyList);
    }
}
