package com.michael.product.services;

import com.michael.product.dtos.ProductDTO;
import com.michael.product.pojos.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public void addProduct(ProductDTO productDTO);
    public void updateProduct(ProductDTO productDTO, int id);
    public void deleteProduct(int id);
}
