package org.example;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "rental")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    Integer id;
    @Column(name = "rental_date")
    LocalDateTime rentalDate;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    Inventory inventory;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    @Column(name = "return_date")
    LocalDateTime returnDate;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    Staff staff;
    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
