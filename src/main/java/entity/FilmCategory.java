package entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(schema = "movie", name = "film_category")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class FilmCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    Short id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
