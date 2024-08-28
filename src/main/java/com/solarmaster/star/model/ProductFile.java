package com.solarmaster.star.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_file_id")
    private Integer productFileId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "product_variant_id", nullable = false)
    private Integer productVariantId;

    @Column(name = "file_id", nullable = false)
    private Integer fileId;
}
