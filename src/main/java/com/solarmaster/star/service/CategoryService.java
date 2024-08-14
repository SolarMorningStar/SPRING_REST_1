package com.solarmaster.star.service;

import com.solarmaster.star.dto.CategoryDTO;
import com.solarmaster.star.model.Category;
import com.solarmaster.star.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        return modelMapper.map(categoryRepository.save(category), CategoryDTO.class);
    }

    public List<CategoryDTO> getAllCategories(Integer pageNumber, Integer pageLimit, String sortBy, Boolean sortOrder) {
        Sort sort = sortOrder != null && sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageLimit, sort);
        return categoryRepository.findAll(pageRequest).stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        return category != null ? modelMapper.map(category, CategoryDTO.class) : null;
    }

    public CategoryDTO updateCategory(Integer categoryId, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            modelMapper.map(categoryDTO, category);
            return modelMapper.map(categoryRepository.save(category), CategoryDTO.class);
        }
        return null;
    }

    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
