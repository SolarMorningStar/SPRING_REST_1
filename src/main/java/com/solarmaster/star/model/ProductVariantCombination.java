package com.solarmaster.star.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product_variant_combinations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantCombination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_variant_id")
    private Integer productVariantId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "price_adjustment", precision = 10, scale = 2)
    private BigDecimal priceAdjustment;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "sku", length = 255)
    private String sku;

    @Column(name = "attribute_combination", columnDefinition = "json")
    private String attributeCombination;
}
