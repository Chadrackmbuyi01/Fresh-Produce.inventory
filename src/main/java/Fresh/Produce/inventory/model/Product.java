package Fresh.Produce.inventory.model;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "is_organic")
    private Boolean isOrganic;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDate.now();
    }
}
