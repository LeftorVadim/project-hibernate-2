package dao;

import entity.Store;
import org.hibernate.SessionFactory;

public class StoreDAO extends movieDAO {
    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}
