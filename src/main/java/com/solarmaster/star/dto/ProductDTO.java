package com.solarmaster.star.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer productId;
    private Integer merchantId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer categoryId;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
