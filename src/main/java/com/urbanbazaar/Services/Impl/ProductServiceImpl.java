package com.urbanbazaar.Services.Impl;

import com.urbanbazaar.DTO.ProductDto;
import com.urbanbazaar.Entities.Product;
import com.urbanbazaar.Exceptions.CustomResourceNotFoundException;
import com.urbanbazaar.Repo.ProductRepo;
import com.urbanbazaar.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public ProductDto addItem(ProductDto productDto) {
        Product product = this.dtoToProduct(productDto);
        Product saveItem = this.productRepo.save(product);
        return this.productToDto(saveItem);
    }

    @Override
    public ProductDto updateItemDetails(ProductDto productDto, long productId) {
        Product existingProduct = productRepo.findById(productId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Product not found with id: " + productId));

        existingProduct.setType(productDto.getType());
        existingProduct.setTitle(productDto.getTitle());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setImage_url(productDto.getImage_url());

        Product updatedProduct = productRepo.save(existingProduct);
        return productToDto(updatedProduct);
    }

    @Override
    public List<ProductDto> getItemByCategory(String category) {
        List<Product> products = productRepo.findByCategory(category);
        return products.stream()
                .map(this::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllItems() {
        List<Product> products = productRepo.findAll();
        return products.stream()
                .map(this::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteItemById(long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Product not found with id: " + productId));
        productRepo.delete(product);
    }
    private Product dtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setType(productDto.getType());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImage_url(productDto.getImage_url());
        product.setTitle(productDto.getTitle());
        return product;
    }
    private ProductDto productToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setType(product.getType());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImage_url(product.getImage_url());
        productDto.setTitle(product.getTitle());
        return productDto;
    }
}
