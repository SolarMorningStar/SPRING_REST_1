package com.solarmaster.star.controller;

import com.solarmaster.star.dto.CategoryDTO;
import com.solarmaster.star.service.CategoryService;
import com.solarmaster.star.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @GetMapping("/all")
    public List<CategoryDTO> getAllCategories(
            @RequestParam(defaultValue = "" + Constants.DEFAULT_PAGE_NUMBER) Integer pageNumber,
            @RequestParam(defaultValue = "" + Constants.DEFAULT_PAGE_LIMIT) Integer pageLimit,
            @RequestParam(defaultValue = "categoryId") String sortBy,
            @RequestParam(defaultValue = "" + Constants.DEFAULT_SORT_ORDER) Boolean sortOrder) {
        return categoryService.getAllCategories(pageNumber, pageLimit, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable("id") Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable("id") Integer categoryId, @RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryId, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
