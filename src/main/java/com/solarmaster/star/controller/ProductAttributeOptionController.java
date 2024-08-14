package com.solarmaster.star.controller;

import com.solarmaster.star.dto.ProductAttributeOptionDTO;
import com.solarmaster.star.service.ProductAttributeOptionService;
import com.solarmaster.star.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-attribute-options")
public class ProductAttributeOptionController {

    @Autowired
    private ProductAttributeOptionService productAttributeOptionService;

    @PostMapping("/add")
    public ProductAttributeOptionDTO createProductAttributeOption(@RequestBody ProductAttributeOptionDTO productAttributeOptionDTO) {
        return productAttributeOptionService.createProductAttributeOption(productAttributeOptionDTO);
    }

    @GetMapping("/all")
    public List<ProductAttributeOptionDTO> getAllProductAttributeOptions(
            @RequestParam(defaultValue = "" + Constants.DEFAULT_PAGE_NUMBER) Integer pageNumber,
            @RequestParam(defaultValue = "" + Constants.DEFAULT_PAGE_LIMIT) Integer pageLimit,
            @RequestParam(defaultValue = "optionId") String sortBy,
            @RequestParam(defaultValue = "" + Constants.DEFAULT_SORT_ORDER) Boolean sortOrder) {
        return productAttributeOptionService.getAllProductAttributeOptions(pageNumber, pageLimit, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public ProductAttributeOptionDTO getProductAttributeOptionById(@PathVariable("id") Integer optionId) {
        return productAttributeOptionService.getProductAttributeOptionById(optionId);
    }

    @PutMapping("/{id}")
    public ProductAttributeOptionDTO updateProductAttributeOption(@PathVariable("id") Integer optionId, @RequestBody ProductAttributeOptionDTO productAttributeOptionDTO) {
        return productAttributeOptionService.updateProductAttributeOption(optionId, productAttributeOptionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProductAttributeOption(@PathVariable("id") Integer optionId) {
        productAttributeOptionService.deleteProductAttributeOption(optionId);
    }
}
