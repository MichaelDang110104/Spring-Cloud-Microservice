package com.michael.product.controllers;

import com.michael.product.dtos.ProductDTO;
import com.michael.product.dtos.PurchaseProduct;
import com.michael.product.pojos.Product;
import com.michael.product.response.ResponseHandler;
import com.michael.product.services.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get-all-products")
    public ResponseEntity getAllProducts() {
        return ResponseHandler.responseBuilder("Get all products successfully !",
                HttpStatus.OK,
                iProductService.getAllProducts()
                        .stream()
                        .map(product -> new ModelMapper().map(product, ProductDTO.class))
                        .collect(Collectors.toList()));
    }

    @GetMapping("/get-product-by-id")
    public ResponseEntity getProductById(@RequestParam int id) {
        return ResponseHandler.responseBuilder("Get product by id successfully !", HttpStatus.OK, iProductService.getProductById(id));
    }

    @PostMapping("/purchase-products")
    public ResponseEntity purchaseProducts(@RequestBody List<PurchaseProduct> products) {
        for (PurchaseProduct purchaseProduct : products) {
            Product product = iProductService.getProductById(purchaseProduct.getProductId());
            if(purchaseProduct.getQuantity() > product.getAvailableQuantity()) throw new RuntimeException("The product is not enough to purchase!");
            product.setAvailableQuantity((Double)(product.getAvailableQuantity() - purchaseProduct.getQuantity()));
        }
        return ResponseHandler.responseBuilder("Purchase product successfully !",HttpStatus.OK, products);
    }

    @PutMapping("/update-product")
    public ResponseEntity updateProduct(@RequestBody ProductDTO productDTO , @RequestParam int id) {
        iProductService.updateProduct(productDTO ,id);
        return ResponseHandler.responseBuilder("Update product successfully !", HttpStatus.NO_CONTENT,productDTO);
    }

    @DeleteMapping("/delete-product")
    public ResponseEntity deleteProduct(@RequestParam int id) {
        Product product = iProductService.getProductById(id);
        iProductService.deleteProduct(id);
        return ResponseHandler.responseBuilder("Delete product successfully !",HttpStatus.NO_CONTENT,product);
    }

    @PostMapping("/create-product")
    public ResponseEntity createProduct(@RequestBody ProductDTO productDTO) {
        iProductService.addProduct(productDTO);
        return ResponseHandler.responseBuilder("Product successfully !",HttpStatus.CREATED,productDTO);
    }
}
