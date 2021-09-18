package com.mesutgolcuk.sellcellphone.service;

import com.mesutgolcuk.sellcellphone.entity.ProductEntity;
import com.mesutgolcuk.sellcellphone.exception.NoContentFoundException;
import com.mesutgolcuk.sellcellphone.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductRepo productRepo;

    public List<ProductEntity> getAllProducts() throws Exception {
        List<ProductEntity> list = productRepo.findAll();
        if (list.isEmpty()) {
            throw new NoContentFoundException();
        }
        return list;
    }

    public void saveProduct(ProductEntity product) {
        productRepo.save(product);
    }
}
