package com.solarmaster.star.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_attribute_options")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Integer optionId;

    @Column(name = "attribute_id", nullable = false)
    private Integer attributeId;

    @Column(name = "option_value", nullable = false, length = 255)
    private String optionValue;
}
