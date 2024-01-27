package com.urbanbazaar.Controller;

import com.urbanbazaar.DTO.ProductDto;
import com.urbanbazaar.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController{
    @Autowired
    private ProductService productService;

    // addItem
    @PostMapping("/add")
    public ResponseEntity<ProductDto> addItem(@RequestBody ProductDto productDto) {
         ProductDto addItem = productService.addItem(productDto);
         return new ResponseEntity<>(addItem, HttpStatus.CREATED);
    }
    // updateItem
    @PutMapping("/update/{productId}")
    public ProductDto updateItem(@RequestBody ProductDto productDto, @PathVariable long productId) {
        return productService.updateItemDetails(productDto, productId);
    }
    // getItemByCategory
    @GetMapping("/category/{category}")
    public List<ProductDto> getItemByCategory(@PathVariable String category) {
        return productService.getItemByCategory(category);
    }

    // getAllItems
    @GetMapping("/all")
    public List<ProductDto> getAllItems() {
        return productService.getAllItems();
    }
    // deleteItems
    @DeleteMapping("/delete/{productId}")
    public void deleteItems(@PathVariable long productId) {
        productService.deleteItemById(productId);
    }

}
