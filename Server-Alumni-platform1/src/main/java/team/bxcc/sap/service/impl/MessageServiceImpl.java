package team.bxcc.sap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import team.bxcc.sap.dao.mysql.MessageDao;
import team.bxcc.sap.forum.model.Message;
import team.bxcc.sap.service.MessageService;
import team.bxcc.sap.util.time.FormatTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户消息的 实现类
 *
 * @author JiXiang
 * @date 2018/5/28.
 */
@Service
@Component
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;
    @Override
    public Map<String, List<Message>> ListMessageByUid(String uid) {
        List<Message> messageList=messageDao.ListMessageByUid(uid);

        Map<String,List<Message>> MessageListMap=new ConcurrentHashMap<String, List<Message>>();
        for(Message message:messageList){
            String time=FormatTime.MessageformateDate(message.getMsgTime());
            if(MessageListMap.get(time)==null){//若干map中还没有这天的信息

                MessageListMap.put(time,new LinkedList<Message>());
                MessageListMap.get(time).add(message);
            }else {
                MessageListMap.get(time).add(message);
            }
        }
        return MessageListMap;
    }
}
