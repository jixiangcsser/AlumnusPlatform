package team.bxcc.sap.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.forum.model.Message;
import team.bxcc.sap.service.MessageService;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;

import java.util.List;
import java.util.Map;

/**
 * 获取用帖子的评论等消息
 * @author JiXiang
 * @date 2018/5/28.
 */
@RestController
@RequestMapping("/api/forum/getMessage")
public class ForumMessageController {
    @Autowired
    MessageService messageService;
    @RequestMapping(method = RequestMethod.GET)
    public HttpResponseObj getMessage(@RequestParam String uid){
        System.out.println("nihaoya "+uid);
        Map<String,List<Message>> MessageMap =messageService.ListMessageByUid(uid);
        try{
            if(MessageMap!=null){
                return new HttpResponseObj(HttpStatus.OK,"获取评论信息成功",MessageMap);
            }
            else {
                return new HttpResponseObj(HttpStatus.DATABASE_EXCEPTION,"数据库发生意外");
            }
        }catch (Exception e){
            return new HttpResponseObj(HttpStatus.UNEXPECTED,"未知错误");
        }
    }
}
