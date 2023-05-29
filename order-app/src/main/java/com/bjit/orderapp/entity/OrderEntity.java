package com.bjit.orderapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderID;
    private Integer userID;
    private String orderDate;
    private String shipping_Address;
    private String order_Status;
    private Integer totalPrice;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Item_id")
    private List<ItemListEntity> itemList;
}
