package com.huang.datasource.service;

import com.huang.datasource.domain.Order;
import com.huang.datasource.domain.Pay;
import com.huang.datasource.mapper.order.OrderMapper;
import com.huang.datasource.mapper.pay.PayMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 15:24
 */
@Service
@AllArgsConstructor
public class PaymentService {

    private PayMapper payMapper;
    private OrderMapper orderMapper;

    @Transactional(rollbackFor = Exception.class)
    public void test() {
        Order order = new Order();
        order.setName("order");
        orderMapper.save(order);

        System.out.println(1/0);

        Pay pay = new Pay();
        pay.setName("pay");
        payMapper.save(pay);
    }

}
