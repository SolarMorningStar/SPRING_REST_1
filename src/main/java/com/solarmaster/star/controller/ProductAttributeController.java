package com.solarmaster.star.controller;

import com.solarmaster.star.dto.ProductAttributeDTO;
import com.solarmaster.star.service.ProductAttributeService;
import com.solarmaster.star.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-attributes")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @PostMapping("/add")
    public ProductAttributeDTO createProductAttribute(@RequestBody ProductAttributeDTO productAttributeDTO) {
        return productAttributeService.createProductAttribute(productAttributeDTO);
    }

    @GetMapping("/all")
    public List<ProductAttributeDTO> getAllProductAttributes(
            @RequestParam(defaultValue = "" + Constants.DEFAULT_PAGE_NUMBER) Integer pageNumber,
            @RequestParam(defaultValue = "" + Constants.DEFAULT_PAGE_LIMIT) Integer pageLimit,
            @RequestParam(defaultValue = "attributeId") String sortBy,
            @RequestParam(defaultValue = "" + Constants.DEFAULT_SORT_ORDER) Boolean sortOrder) {
        return productAttributeService.getAllProductAttributes(pageNumber, pageLimit, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public ProductAttributeDTO getProductAttributeById(@PathVariable("id") Integer attributeId) {
        return productAttributeService.getProductAttributeById(attributeId);
    }

    @PutMapping("/{id}")
    public ProductAttributeDTO updateProductAttribute(@PathVariable("id") Integer attributeId, @RequestBody ProductAttributeDTO productAttributeDTO) {
        return productAttributeService.updateProductAttribute(attributeId, productAttributeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProductAttribute(@PathVariable("id") Integer attributeId) {
        productAttributeService.deleteProductAttribute(attributeId);
    }
}