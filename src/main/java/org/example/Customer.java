package org.example;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Short id;
    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "email")
    String email;
    @OneToOne
    @JoinColumn(name = "address_id")
    Address address;
    @Column(name = "active", columnDefinition = "BIT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    Boolean isActive;
    @Column(name = "create_date")
    @CreationTimestamp
    LocalDateTime createDate;
    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
