package com.bjit.inventoryapp.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer orderID;
    private Integer userID;
    private String orderDate;
    private String shipping_Address;
    private String order_Status;
    private Integer totalPrice;
    private List<ItemListDto> itemList;
}
