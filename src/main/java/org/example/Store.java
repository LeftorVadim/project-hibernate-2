package org.example;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "store")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    Byte id;

    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    Staff staff;

    @OneToOne
    @JoinColumn(name = "address_id")
    Address address;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
