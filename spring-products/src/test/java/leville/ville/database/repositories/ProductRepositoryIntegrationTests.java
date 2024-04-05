package leville.ville.database.repositories;

import leville.ville.database.TestDataUtil;
import leville.ville.domain.Product;
import leville.ville.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@AutoConfigureMockMvc
public class ProductRepositoryIntegrationTests {
    private ProductRepository underTest;

    @Autowired
    public ProductRepositoryIntegrationTests(ProductRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatProductCanBeCreatedAndRecalled(){
        System.out.println("Starting test");
        Product product = TestDataUtil.createProductA();
        underTest.save(product);
        Optional<Product> result = underTest.findById(product.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(product);
        System.out.println("Result retrieved: "+result.get());
        System.out.println("Product created: "+product.toString());
    }
}
