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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private String type;
    private int unit;
    private double price;
    private boolean available;
    private String supplier;
//    @ManyToMany(mappedBy = "products")
//    private List<Order> orders;
//    @ManyToMany(mappedBy = "products")
//    private List<Customer> customers;
}
