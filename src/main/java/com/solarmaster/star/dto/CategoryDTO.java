package com.solarmaster.star.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Integer categoryId;
    private Integer parentCategoryId;
    private String name;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
