package leville.ville.repositories;

import leville.ville.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
Iterable<Product> findByNameContainsIgnoreCase(String name);
}
