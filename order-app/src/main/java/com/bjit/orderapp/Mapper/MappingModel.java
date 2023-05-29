package com.bjit.orderapp.Mapper;

import com.bjit.orderapp.dto.ItemListDto;
import com.bjit.orderapp.dto.OrderDto;
import com.bjit.orderapp.entity.ItemListEntity;
import com.bjit.orderapp.entity.OrderEntity;

public class MappingModel {
    public static OrderDto orderEntityToDto(OrderEntity orderEntity) {
        return OrderDto.builder()
                .orderID(orderEntity.getOrderID())
                .userID(orderEntity.getUserID())
                .orderDate(orderEntity.getOrderDate())
                .shipping_Address(orderEntity.getShipping_Address())
                .order_Status(orderEntity.getOrder_Status())
                .itemList(orderEntity.getItemList())
                .totalPrice(orderEntity.getTotalPrice())
                .build();
    }

    public static OrderEntity DtoToOrderEntity(OrderDto orderDto) {
        return OrderEntity.builder()
                .userID(orderDto.getUserID())
                .orderDate(orderDto.getOrderDate())
                .shipping_Address(orderDto.getShipping_Address())
                .order_Status(orderDto.getOrder_Status())
                .itemList(orderDto.getItemList())
                .totalPrice(orderDto.getTotalPrice())
                .build();
    }
    public static ItemListEntity DtoToItemListEntity(ItemListDto itemListDto) {
        return ItemListEntity.builder()
                .bookId(itemListDto.getBookId())
                .price(itemListDto.getPrice())
                .quantity(itemListDto.getQuantity())
                .build();
    }
    public static ItemListDto ItemListEntityToDto(ItemListEntity itemList) {
        return ItemListDto.builder()
                .bookId(itemList.getBookId())
                .ItemId(itemList.getItemId())
                .price(itemList.getPrice())
                .quantity(itemList.getQuantity())
                .build();
    }
}
