package org.example;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "film_actor")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class FilmActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    Short id;
    @ManyToOne
    @JoinColumn(name = "film_id")
    Film film;
    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;

}
