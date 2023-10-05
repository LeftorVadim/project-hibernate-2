package dao;

import org.example.Language;
import org.hibernate.SessionFactory;

public class LanguageDAO extends movieDAO {
    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
