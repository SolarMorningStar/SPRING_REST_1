package com.solarmaster.star.service;

import com.solarmaster.star.dto.ProductAttributeDTO;
import com.solarmaster.star.model.ProductAttribute;
import com.solarmaster.star.repository.ProductAttributeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductAttributeService {

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductAttributeDTO createProductAttribute(ProductAttributeDTO productAttributeDTO) {
        ProductAttribute productAttribute = modelMapper.map(productAttributeDTO, ProductAttribute.class);
        return modelMapper.map(productAttributeRepository.save(productAttribute), ProductAttributeDTO.class);
    }

    public List<ProductAttributeDTO> getAllProductAttributes(Integer pageNumber, Integer pageLimit, String sortBy, Boolean sortOrder) {
        Sort sort = sortOrder != null && sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageLimit, sort);
        return productAttributeRepository.findAll(pageRequest).stream()
                .map(productAttribute -> modelMapper.map(productAttribute, ProductAttributeDTO.class))
                .collect(Collectors.toList());
    }

    public ProductAttributeDTO getProductAttributeById(Integer attributeId) {
        ProductAttribute productAttribute = productAttributeRepository.findById(attributeId).orElse(null);
        return productAttribute != null ? modelMapper.map(productAttribute, ProductAttributeDTO.class) : null;
    }

    public ProductAttributeDTO updateProductAttribute(Integer attributeId, ProductAttributeDTO productAttributeDTO) {
        ProductAttribute productAttribute = productAttributeRepository.findById(attributeId).orElse(null);
        if (productAttribute != null) {
            modelMapper.map(productAttributeDTO, productAttribute);
            return modelMapper.map(productAttributeRepository.save(productAttribute), ProductAttributeDTO.class);
        }
        return null;
    }

    public void deleteProductAttribute(Integer attributeId) {
        productAttributeRepository.deleteById(attributeId);
    }
}