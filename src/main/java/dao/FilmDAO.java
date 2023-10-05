package dao;

import entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FilmDAO extends movieDAO {
    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    public Film getAvailableFilm() {
        Query<Film> filmQuery = getCurrentSession().createQuery("SELECT f FROM Film f WHERE f.id not in (SELECT film.id FROM Inventory)", Film.class);
        filmQuery.setMaxResults(1);
        return filmQuery.getSingleResult();
    }
}
