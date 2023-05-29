package com.bjit.orderapp.controller;

import com.bjit.orderapp.dto.ItemListDto;
import com.bjit.orderapp.dto.OrderDto;
import com.bjit.orderapp.service.ItemListService;
import com.bjit.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ItemListService itemListService;
    @PostMapping("/add")
    public ResponseEntity<Object> addOrder(@RequestBody OrderDto orderDto) {
        return  orderService.addOrder(orderDto);
    }
    @PutMapping("/addItemList/{orderId}")
    public ResponseEntity<Object> addItemList(@PathVariable("orderId") Integer orderId, @RequestBody ItemListDto itemListDto) {
        return  orderService.addItemList(orderId,itemListDto);
    }
    @GetMapping("/orderDetails/{orderId}")
    public OrderDto orderDetails(@PathVariable("orderId") Integer orderId) {
        return  orderService.orderDetails(orderId);
    }

    @GetMapping("/orderItemList/{orderId}")
    public List<ItemListDto> orderItemListByOrderId(@PathVariable("orderId") Integer orderId) {
        return  orderService.orderItemListByOrderId(orderId);
    }
    @GetMapping("/allOrder")
    public ResponseEntity<Object> getAllOrder() {
        return  orderService.getAllOrder();
    }

    @GetMapping("/getAllItemList")
    public ResponseEntity<Object> getAllItemList() {
        return  itemListService.getAllItemList();
    }

}
