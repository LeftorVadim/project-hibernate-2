package dao;

import entity.Category;
import org.hibernate.SessionFactory;

public class CategoryDAO extends movieDAO{
    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
