package dao;

import entity.Rating;
import org.hibernate.SessionFactory;

public class RatingDAO extends movieDAO {
    public RatingDAO(SessionFactory sessionFactory) {
        super(Rating.class, sessionFactory);
    }
}
