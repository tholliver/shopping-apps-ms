package leville.ville.services;

import leville.ville.domain.Product;

import java.util.List;

public interface ProductService {
   Product createProduct(Product product);

   List<Product> findAllProducts();

   List<Product> findByNameContainsIgnoreCase(String name);

   void delete(Long id);
}
