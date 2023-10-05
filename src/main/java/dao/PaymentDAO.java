package dao;

import org.example.Payment;
import org.hibernate.SessionFactory;

public class PaymentDAO extends movieDAO {
    public PaymentDAO(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}
