package team.bxcc.sap.controller.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import team.bxcc.sap.service.impl.DaoService;

public class JobUtilsTest {
    @Autowired
    private DaoService service;
    @Test
    public void testAsync()throws Exception{
        System.out.println("start");
        service.update();
        System.out.println("end");
        Thread.sleep(1000);
    }
}
