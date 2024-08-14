package com.solarmaster.star.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_attributes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id")
    private Integer attributeId;

    @Column(name = "attribute_name", nullable = false, length = 255)
    private String attributeName;

    @Column(name = "category_id")
    private Integer categoryId;
}
