package com.bjit.orderapp.service.Imp;

import com.bjit.orderapp.Mapper.MappingModel;
import com.bjit.orderapp.dto.ItemListDto;
import com.bjit.orderapp.dto.OrderDto;
import com.bjit.orderapp.entity.ItemListEntity;
import com.bjit.orderapp.entity.OrderEntity;
import com.bjit.orderapp.repository.OrderRepository;
import com.bjit.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public ResponseEntity<Object> addOrder(OrderDto orderDto) {
        OrderEntity orderEntity = MappingModel.DtoToOrderEntity(orderDto);
        List<ItemListEntity> itemLists =orderEntity.getItemList();
        int sum=0;
        for (ItemListEntity il:itemLists){
            sum=sum+il.getPrice()*il.getQuantity();
        }
        orderEntity.setTotalPrice(sum);
        return new ResponseEntity<>(MappingModel.orderEntityToDto( orderRepository.save(orderEntity)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getAllOrder() {
        List<OrderEntity> OrderList = orderRepository.findAll();
        return new ResponseEntity<>(OrderList.stream().map(MappingModel::orderEntityToDto).toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> addItemList(Integer orderId, ItemListDto itemListDto) {
        OrderEntity orderEntity=orderRepository.findByOrderID(orderId);
       if(orderEntity!=null){
           ItemListEntity itemListEntity=MappingModel.DtoToItemListEntity(itemListDto);
           List<ItemListEntity> existingList= orderEntity.getItemList();
           existingList.add(itemListEntity);
           int totalPrice=orderEntity.getTotalPrice()+(itemListEntity.getPrice()*itemListEntity.getQuantity());
           orderEntity.setTotalPrice(totalPrice);
           orderRepository.save(orderEntity);
           return new ResponseEntity<>(orderEntity,HttpStatus.ACCEPTED);
       }
        return new ResponseEntity<>("Not Inserted",HttpStatus.NOT_FOUND);
    }

    @Override
    public OrderDto orderDetails(Integer orderId) {
        OrderEntity orderEntity=orderRepository.findByOrderID(orderId);
        return MappingModel.orderEntityToDto(orderEntity);
    }

    @Override
    public List<ItemListDto> orderItemListByOrderId(Integer orderId) {
        List<ItemListEntity> orderEntity=orderRepository.findByOrderID(orderId).getItemList();
       return orderEntity.stream().map(MappingModel::ItemListEntityToDto).toList();
    }
}
