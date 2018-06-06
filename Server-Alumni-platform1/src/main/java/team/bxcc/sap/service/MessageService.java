package team.bxcc.sap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.bxcc.sap.forum.model.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {
    Map<String,List<Message>>ListMessageByUid(String uid);
}
