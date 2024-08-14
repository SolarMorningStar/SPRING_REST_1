package com.solarmaster.star.controller;

import com.solarmaster.star.dto.ProductDTO;
import com.solarmaster.star.service.ProductService;
import com.solarmaster.star.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createNewProduct(productDTO);
    }

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts(
            @RequestParam(defaultValue = "" + Constants.DEFAULT_PAGE_NUMBER) Integer pageNumber,
            @RequestParam(defaultValue = "" + Constants.DEFAULT_PAGE_LIMIT) Integer pageLimit,
            @RequestParam(defaultValue = "productId") String sortBy,
            @RequestParam(defaultValue = "" + Constants.DEFAULT_SORT_ORDER) Boolean sortOrder) {
        return productService.getAllProducts(pageNumber, pageLimit, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") Integer productId) {
        return productService.getProductById(productId);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable("id") Integer productId, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productId, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Integer productId) {
        productService.deleteProduct(productId);
    }
}