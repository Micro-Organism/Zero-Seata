package com.zero.seata.product.domain.dto;

import lombok.Data;

@Data
public class ProductReduceStockDTO {
 

    private Long productId;

    private Integer amount;
    

}