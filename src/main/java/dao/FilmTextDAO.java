package dao;

import org.example.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDAO extends movieDAO {
    public FilmTextDAO(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
