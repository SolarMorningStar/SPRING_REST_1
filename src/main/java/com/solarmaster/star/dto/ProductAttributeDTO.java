package com.solarmaster.star.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeDTO {
    private Integer attributeId;
    private String attributeName;
    private Integer categoryId;
}
