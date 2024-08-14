package com.solarmaster.star.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantCombinationAttributeDTO {
    private Integer combinationAttributeId;
    private Integer productVariantId;
    private Integer optionId;
}
