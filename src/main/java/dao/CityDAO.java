package dao;

import org.example.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CityDAO extends movieDAO {
    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getByName(String name) {
        Query<City> query = getCurrentSession().createQuery(" SELECT c FROM City c WHERE c.city = :name", City.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
