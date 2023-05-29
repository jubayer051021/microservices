package com.bjit.orderapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ItemId;
    private Integer bookId;
    private Integer price;
    private Integer quantity;
}
