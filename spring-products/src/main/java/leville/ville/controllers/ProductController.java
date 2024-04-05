package leville.ville.controllers;

import leville.ville.domain.Product;
import leville.ville.domain.dto.ProductDTO;
import leville.ville.mappers.Mapper;
import leville.ville.repositories.ProductRepository;
import leville.ville.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log
public class ProductController {

    private ProductService productService;
    private Mapper<Product, ProductDTO> productMapper;

    public ProductController(ProductService productService, Mapper<Product, ProductDTO> productMapper){
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping(path = "/products")
    public List<ProductDTO> retrieveProduct(){
        List<Product> products = productService.findAllProducts();
        return products.stream().map(productMapper::mapTo).collect(Collectors.toList());

    }

    @GetMapping(path = "/products/{name}")
    public List<ProductDTO> retrieveMatchingProducts(@PathVariable("name") String name){
        List<Product> products = productService.findByNameContainsIgnoreCase(name);
        return products.stream().map(productMapper::mapTo).collect(Collectors.toList());
    }

    @PostMapping(path = "/products")
    public ProductDTO createProduct(@RequestBody ProductDTO product){
        Product productEntity = productMapper.mapFrom(product);
        Product savedProductEntity = productService.createProduct(productEntity);
        return productMapper.mapTo(savedProductEntity);

    }

    @DeleteMapping(path = "/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Long id){
        productService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
