package com.urbanbazaar.Services;

import com.urbanbazaar.DTO.ProductDto;
import java.util.List;

public interface ProductService {
    ProductDto addItem(ProductDto productDto);
    ProductDto updateItemDetails(ProductDto productDto, long productId);
    List<ProductDto> getItemByCategory(String category);
    List<ProductDto> getAllItems();
    void deleteItemById(long productId);
}
