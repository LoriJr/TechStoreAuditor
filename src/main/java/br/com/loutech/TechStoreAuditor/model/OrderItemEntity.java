package br.com.loutech.TechStoreAuditor.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name= "order_item_tb")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity product;

    private Integer quantity;
    private BigDecimal price;

}
