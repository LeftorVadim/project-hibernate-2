package org.example;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "country")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    Short id;
    @Column(name = "country")
    String country;
    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
