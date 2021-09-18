package com.mesutgolcuk.sellcellphone.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="customers")
@Setter
@Getter
@ToString
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Surname cannot be null")
    private String surname;
    @NotNull(message = "TCKN cannot be null")
    @Size(min = 11, max = 11, message = "TCKN must be 11 characters")
    private String identifier;
    @NotNull(message = "Phone cannot be null")
    @Size(min = 10, max = 10, message = "Phone must contain 10 numbers")
    private String phoneNumber;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @CreationTimestamp
    @Column(name="created_at", nullable=false, updatable=false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;
}
