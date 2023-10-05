package org.example;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "inventory")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    int id;
    @ManyToOne
    @JoinColumn(name = "film_id")
    Film film;
    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;
    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
