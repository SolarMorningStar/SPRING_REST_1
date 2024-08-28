package com.solarmaster.star.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantCombinationDTO {
    private Integer productVariantId;
    private Integer productId;
    private BigDecimal priceAdjustment;
    private Integer stock;
    private Integer maxOrder;
    private Integer minOrder;
    private String sku;
    private String attributeCombination; // JSON representation of the combination
}
