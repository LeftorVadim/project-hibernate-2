package dao;

import org.example.Category;
import org.hibernate.SessionFactory;

import java.util.Locale;

public class CategoryDAO extends movieDAO{
    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
