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
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private String password;
    private String phone;
    @OneToOne
    @JoinColumn(name = "addresses_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "wishlist",
            joinColumns = { @JoinColumn(name = "customers_id") },
            inverseJoinColumns = { @JoinColumn(name = "products_id") }
    )
    private List<Product> products;
}
