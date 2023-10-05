package entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

@Entity
@Table(schema = "movie", name = "film_text")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class FilmText {
    @Id
    @Column(name = "film_id")
    short id;

    @OneToOne
    @JoinColumn(name = "film_id")
    Film film;

    @Column(name = "title")
    String title;
    @Column(name = "description", columnDefinition = "text")
    @Type(type = "text")
    String description;
}
