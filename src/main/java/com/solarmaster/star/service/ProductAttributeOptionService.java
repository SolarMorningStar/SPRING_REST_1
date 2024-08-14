package com.solarmaster.star.service;

import com.solarmaster.star.dto.ProductAttributeOptionDTO;
import com.solarmaster.star.model.ProductAttributeOption;
import com.solarmaster.star.repository.ProductAttributeOptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductAttributeOptionService {

    @Autowired
    private ProductAttributeOptionRepository productAttributeOptionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductAttributeOptionDTO createProductAttributeOption(ProductAttributeOptionDTO productAttributeOptionDTO) {
        ProductAttributeOption productAttributeOption = modelMapper.map(productAttributeOptionDTO, ProductAttributeOption.class);
        return modelMapper.map(productAttributeOptionRepository.save(productAttributeOption), ProductAttributeOptionDTO.class);
    }

    public List<ProductAttributeOptionDTO> getAllProductAttributeOptions(Integer pageNumber, Integer pageLimit, String sortBy, Boolean sortOrder) {
        Sort sort = sortOrder != null && sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageLimit, sort);
        return productAttributeOptionRepository.findAll(pageRequest).stream()
                .map(productAttributeOption -> modelMapper.map(productAttributeOption, ProductAttributeOptionDTO.class))
                .collect(Collectors.toList());
    }

    public ProductAttributeOptionDTO getProductAttributeOptionById(Integer optionId) {
        ProductAttributeOption productAttributeOption = productAttributeOptionRepository.findById(optionId).orElse(null);
        return productAttributeOption != null ? modelMapper.map(productAttributeOption, ProductAttributeOptionDTO.class) : null;
    }

    public ProductAttributeOptionDTO updateProductAttributeOption(Integer optionId, ProductAttributeOptionDTO productAttributeOptionDTO) {
        ProductAttributeOption productAttributeOption = productAttributeOptionRepository.findById(optionId).orElse(null);
        if (productAttributeOption != null) {
            modelMapper.map(productAttributeOptionDTO, productAttributeOption);
            return modelMapper.map(productAttributeOptionRepository.save(productAttributeOption), ProductAttributeOptionDTO.class);
        }
        return null;
    }

    public void deleteProductAttributeOption(Integer optionId) {
        productAttributeOptionRepository.deleteById(optionId);
    }
}
