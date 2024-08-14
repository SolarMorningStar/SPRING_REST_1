package com.solarmaster.star.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_variant_combination_attributes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantCombinationAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "combination_attribute_id")
    private Integer combinationAttributeId;

    @Column(name = "product_variant_id", nullable = false)
    private Integer productVariantId;

    @Column(name = "option_id", nullable = false)
    private Integer optionId;
}
