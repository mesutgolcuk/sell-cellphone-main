package com.mesutgolcuk.sellcellphone.controller;

import com.mesutgolcuk.sellcellphone.entity.ProductEntity;
import com.mesutgolcuk.sellcellphone.model.*;
import com.mesutgolcuk.sellcellphone.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProductController {

    private static Logger LOGGER = LogManager.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @PostMapping("/api/product")
    public ResponseEntity<?> saveProduct(@RequestBody ProductEntity product) {
        RegisterProductResponse response = new RegisterProductResponse();
        productService.saveProduct(product);
        LOGGER.info("New product created");
        response.setSuccess(true);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/products")
    public ResponseEntity<ProductsResponse> getAllProducts() throws Exception {
        ProductsResponse response = new ProductsResponse();
        List<ProductEntity> productList = productService.getAllProducts();
        response.setProductList(productList);
        response.setSuccess(true);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
