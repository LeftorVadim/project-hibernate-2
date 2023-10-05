package dao;

import org.example.Actor;
import org.hibernate.SessionFactory;

public class ActorDAO extends movieDAO<Actor> {
    public ActorDAO(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }
}
