package com.bjit.inventoryapp.service;

import com.bjit.inventoryapp.config.FeignBookConfig;
import com.bjit.inventoryapp.config.FeignOrderConfig;
import com.bjit.inventoryapp.config.FeignPaymentConfig;
import com.bjit.inventoryapp.config.FeignUserConfig;
import com.bjit.inventoryapp.dto.BookResponseModel;
import com.bjit.inventoryapp.dto.ItemListDto;
import com.bjit.inventoryapp.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final FeignOrderConfig feignOrderConfig;
    private final FeignBookConfig feignBookConfig;
    private final FeignPaymentConfig feignPaymentConfig;
    private final FeignUserConfig feignUserConfig;

    public String orderDelivered(Integer orderId) {
        OrderDto orderDto=feignOrderConfig.orderDetails(orderId);
        List<ItemListDto> lists=orderDto.getItemList();
        if(isInStock(lists)){
            updateQuantity(lists);
            return "successFull placed";
        }
        feignUserConfig.refundMoney(orderDto.getUserID(),orderDto.getTotalPrice());
        feignPaymentConfig.refund(orderDto.getOrderID());
        return "Product are insufficient,, so refund the money to the User";
    }
    public boolean isInStock(List<ItemListDto> lists){
        for (ItemListDto it:lists){
            BookResponseModel bookResponseModel=feignBookConfig.bookDetails(it.getBookId());
            if (bookResponseModel.getQuantity()<it.getQuantity()){
                return false;
            }
        }
        return true;
    }
    public void updateQuantity(List<ItemListDto> lists){
        for (ItemListDto it:lists){
            feignBookConfig.updateBookQuantity(it.getBookId(), it.getQuantity());
        }
    }
}
