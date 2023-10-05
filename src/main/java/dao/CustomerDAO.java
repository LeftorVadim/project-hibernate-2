package dao;

import entity.Customer;
import org.hibernate.SessionFactory;

public class CustomerDAO extends movieDAO {
    public CustomerDAO(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}
