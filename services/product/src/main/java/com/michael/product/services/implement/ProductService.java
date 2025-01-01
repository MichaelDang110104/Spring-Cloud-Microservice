package com.michael.product.services.implement;

import com.michael.product.dtos.ProductDTO;
import com.michael.product.pojos.Product;
import com.michael.product.repositories.IProductRepo;
import com.michael.product.services.IProductService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo iProductRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Product> getAllProducts() {
        return iProductRepo.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return iProductRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Product not found"));
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        iProductRepo.save(product);
    }

    @Override
    public void updateProduct(ProductDTO productDTO, int id) {
        Product product = getProductById(id);
        modelMapper.map(productDTO, product);
        iProductRepo.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        iProductRepo.deleteById(id);
    }
}
