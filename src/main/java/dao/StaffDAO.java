package dao;

import org.example.Staff;
import org.hibernate.SessionFactory;

public class StaffDAO extends movieDAO {
    public StaffDAO(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}
