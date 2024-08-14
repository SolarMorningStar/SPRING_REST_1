package com.solarmaster.star.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeOptionDTO {
    private Integer optionId;
    private Integer attributeId;
    private String optionValue;
}
