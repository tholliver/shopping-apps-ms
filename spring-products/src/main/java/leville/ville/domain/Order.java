package leville.ville.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String status;
    private double total;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "orders_products",
            joinColumns = { @JoinColumn(name = "orders_id") },
            inverseJoinColumns = { @JoinColumn(name = "products_id") }
    )
    List<Product> products;
}
