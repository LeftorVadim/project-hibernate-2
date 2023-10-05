package org.example;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Entity
@Table(schema = "movie", name = "film")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    Short id;
    @Column(name = "title")
    String title;
    @Column(name = "description", columnDefinition = "text")
    @Type(type = "text")
    String description;
    @Column(name = "release_year", columnDefinition = "year")
    @Convert(converter = YearAttributeConverter.class)
    Year release;
    @ManyToOne
    @JoinColumn(name = "language_id")
    Language language;
    @ManyToOne
    @JoinColumn(name = "original_language_id")
    Language originalLanguage;
    @Column(name = "rental_duration")
    byte rentalDuration;
    @Column(name = "rental_rate")
    BigDecimal rentalRate;
    @Column(name = "length")
    short length;
    @Column(name = "replacement_cost")
    BigDecimal replacementCost;
    @Column(name = "rating", columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    @Convert(converter = RatingConverter.class)
    Rating rating;
    @Column(name = "special_features", columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    String specialFeatures;

    public Set<SpecialFeatures> getSpecialFeatures() {
        if (isNull(specialFeatures) || specialFeatures.isEmpty()) {
            return null;
        }

        Set<SpecialFeatures> specialFeaturesSet = new HashSet<>();
        String[] features = specialFeatures.split(",");
        for (String f : features) {
            specialFeaturesSet.add(SpecialFeatures.getFeature(f));
        }
        specialFeaturesSet.remove(null);
        return specialFeaturesSet;
    }

    public void setSpecialFeatures(Set<SpecialFeatures> features) {
        if (isNull(specialFeatures)) {
        } else {
            specialFeatures = features.stream().map(SpecialFeatures::getValue).collect(Collectors.joining(","));
        }
    }

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;

    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    Set<Actor> actors;
}
