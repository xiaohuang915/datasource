package com.huang.datasource.mapper.order;

import com.huang.datasource.domain.Order;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/11/23 15:20
 */
public interface OrderMapper {
    void save(Order order);
}
