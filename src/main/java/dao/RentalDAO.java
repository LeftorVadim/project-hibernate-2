package dao;

import org.example.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RentalDAO extends movieDAO {
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getUnreturnedRental() {
        Query<Rental> rentalQuery = getCurrentSession().createQuery("SELECT r FROM Rental r where r.returnDate = null", Rental.class);
        rentalQuery.setMaxResults(1);
        return rentalQuery.getSingleResult();
    }
}
