package com.huang.datasource;

import com.huang.datasource.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 15:27
 */
@SpringBootTest(classes = DataApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void test(){
        paymentService.test();
    }
}
