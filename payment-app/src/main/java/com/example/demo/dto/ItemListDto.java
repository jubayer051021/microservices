package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemListDto {
    private Integer ItemId;
    private Integer bookId;
    private Integer price;
    private Integer quantity;
}
