package com.bjit.orderapp.service;

import com.bjit.orderapp.dto.ItemListDto;
import com.bjit.orderapp.dto.OrderDto;
import com.bjit.orderapp.entity.ItemListEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;


public interface OrderService {
    ResponseEntity<Object> addOrder(OrderDto orderDto);

    ResponseEntity<Object> getAllOrder();

    ResponseEntity<Object> addItemList(Integer orderId,ItemListDto itemListDto);

    OrderDto orderDetails(Integer orderId);

    List<ItemListDto> orderItemListByOrderId(Integer orderId);
}
