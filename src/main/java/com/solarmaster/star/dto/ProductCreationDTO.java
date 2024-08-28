package com.solarmaster.star.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreationDTO {
    private Integer merchantId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer categoryId;
    private List<ProductVariantCombinationDTO> variants;
    private List<FileDTO> images;
}
