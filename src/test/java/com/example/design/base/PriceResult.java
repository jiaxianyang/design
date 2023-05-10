package com.example.design.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceResult {
    private Integer realPrice;
    private Integer price;
    private Integer discountPrice;
}
