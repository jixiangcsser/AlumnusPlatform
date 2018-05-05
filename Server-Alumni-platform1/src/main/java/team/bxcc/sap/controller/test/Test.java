package team.bxcc.sap.controller.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tokenww")
public class Test {

    @RequestMapping(method = RequestMethod.POST)
    public void run(){
        System.out.println("你是不是饿的慌");
    }
}
