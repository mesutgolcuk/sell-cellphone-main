package com.mesutgolcuk.sellcellphone.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="products")
@Setter
@Getter
@ToString
public class ProductEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Make cannot be null")
    private String make;
    @NotNull(message = "Model cannot be null")
    private String model;

    @CreationTimestamp
    @Column(name="created_at", nullable=false, updatable=false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;
}
