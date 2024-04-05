package leville.ville.services.impl;

import leville.ville.domain.Product;
import leville.ville.repositories.ProductRepository;
import leville.ville.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllProducts(){
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public List<Product> findByNameContainsIgnoreCase(String name) {
        return StreamSupport.stream(productRepository.findByNameContainsIgnoreCase(name).spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
