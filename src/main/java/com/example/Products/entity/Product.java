package com.example.Products.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Short amount;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
