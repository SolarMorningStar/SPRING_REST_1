package com.solarmaster.star.service;

import com.solarmaster.star.dto.ProductCreationDTO;
import com.solarmaster.star.dto.ProductDTO;
import com.solarmaster.star.model.File;
import com.solarmaster.star.model.Product;
import com.solarmaster.star.model.ProductFile;
import com.solarmaster.star.model.ProductVariantCombination;
import com.solarmaster.star.repository.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductVariantCombinationRepository productVariantCombinationRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private ProductFileRepository productFileRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public ProductDTO createNewProductWithDetails(ProductCreationDTO productCreationDTO) {

        Product product = new Product();
        product.setMerchantId(productCreationDTO.getMerchantId());
        product.setName(productCreationDTO.getName());
        product.setDescription(productCreationDTO.getDescription());
        product.setPrice(productCreationDTO.getPrice());
        product.setCategoryId(productCreationDTO.getCategoryId());

        // Save the product
        product = productRepository.save(product);

        // Save the variants
        if (productCreationDTO.getVariants() != null && !productCreationDTO.getVariants().isEmpty()) {
            Product finalProduct = product;
            List<ProductVariantCombination> variants = productCreationDTO.getVariants().stream().map(variantDTO -> {
                ProductVariantCombination variant = modelMapper.map(variantDTO, ProductVariantCombination.class);
                variant.setProductId(finalProduct.getProductId());
                return productVariantCombinationRepository.save(variant);
            }).collect(Collectors.toList());
        }

        // Save the images
        if (productCreationDTO.getImages() != null && !productCreationDTO.getImages().isEmpty()) {
            List<File> images = productCreationDTO.getImages().stream().map(fileDTO -> modelMapper.map(fileDTO, File.class)).collect(Collectors.toList());
            Product finalProduct = product;
            images.forEach(image -> {
                image = fileRepository.save(image);
                ProductFile productFile = new ProductFile();
                productFile.setProductId(finalProduct.getProductId());
                productFile.setFileId(image.getFileId());
                productFileRepository.save(productFile);
            });
        }

        return modelMapper.map(product, ProductDTO.class);
    }


    public ProductDTO createNewProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        return modelMapper.map(productRepository.save(product), ProductDTO.class);
    }

    public List<ProductDTO> getAllProducts(Integer pageNumber, Integer pageLimit, String sortBy, Boolean sortOrder) {
        Sort sort = sortOrder != null && sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageLimit, sort);
        return productRepository.findAll(pageRequest).stream().map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }

    public ProductDTO getProductById(Integer productId) {
        Product product = productRepository.findById(productId).orElse(null);
        return product != null ? modelMapper.map(product, ProductDTO.class) : null;
    }

    public ProductDTO updateProduct(Integer productId, ProductDTO productDTO) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            modelMapper.map(productDTO, product);
            return modelMapper.map(productRepository.save(product), ProductDTO.class);
        }
        return null;
    }

    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
