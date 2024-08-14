package com.solarmaster.star.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProductCreationDTO {
    private Integer merchantId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer categoryId;
    private List<ProductVariantCombinationDTO> variants;
    private List<FileDTO> images;

    // Getters and Setters
    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<ProductVariantCombinationDTO> getVariants() {
        return variants;
    }

    public void setVariants(List<ProductVariantCombinationDTO> variants) {
        this.variants = variants;
    }

    public List<FileDTO> getImages() {
        return images;
    }

    public void setImages(List<FileDTO> images) {
        this.images = images;
    }
}
