package com.mesutgolcuk.sellcellphone.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="orders")
@Setter
@Getter
@ToString
public class OrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Customer id cannot be null")
    private Long customerId;
    @NotNull(message = "Product id cannot be null")
    private Long productId;

    @CreationTimestamp
    @Column(name="created_at", nullable=false, updatable=false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;
}
