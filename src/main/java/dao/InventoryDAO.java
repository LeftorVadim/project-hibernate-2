package dao;

import entity.Inventory;
import org.hibernate.SessionFactory;

public class InventoryDAO extends movieDAO {
    public InventoryDAO(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}
