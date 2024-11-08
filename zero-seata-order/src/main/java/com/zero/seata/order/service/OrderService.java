package com.zero.seata.order.service;

import java.io.IOException;

public interface OrderService {
    Integer createOrder(Long userId, Long productId, Integer price) throws IOException;
}
