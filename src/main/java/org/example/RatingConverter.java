package org.example;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public Rating convertToEntityAttribute(String s) {
        Rating[] ratings = Rating.values();
        for (Rating rating : ratings) {
            if (rating.getValue().equals(s)) {
                return rating;
            }
        }
        return null;
    }

    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getValue();
    }
}
