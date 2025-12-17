package br.com.grafana.sma.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private UUID code;

    @Column(nullable = false, length = 70)
    private String name;

    @Column(nullable = true, length = 200)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean active;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UUID getCode() {
        return code;
    }

    public void setCode(UUID code) {
        this.code = code;
    }
}
