package org.example;

import dao.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    private SessionFactory sessionFactory;
    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private static CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final InventoryDAO inventoryDAO;
    private final LanguageDAO languageDAO;
    private final PaymentDAO paymentDAO;
    private final RatingDAO ratingDAO;
    private final RentalDAO rentalDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;

    public App() {
        sessionFactory = new SessionFactoryImpl().createSessionFactory();
        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        ratingDAO = new RatingDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }

    public static void main(String[] args) {
        App app = new App();
        Customer customer = app.createCustomer();
        app.returnRental();
        app.rentInventory(customer);
        app.newFilmForRent();
    }

    private void newFilmForRent() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Language language = (Language) languageDAO.getItems(0, 10).get(5);
            List<Category> categoryDAOItems = categoryDAO.getItems(0, 10);
            List<Actor> actorDAOItems = actorDAO.getItems(0, 10);
            Film film = new Film();

            film.setLanguage(language);
            film.setActors(new HashSet<>(actorDAOItems));
            film.setRating(Rating.PG);
            film.setDescription("description");
            film.setLength((short) 120);
            film.setSpecialFeatures(Set.of(SpecialFeatures.DELETED_SCENES, SpecialFeatures.TRAILERS));
            film.setReplacementCost(BigDecimal.ONE);
            film.setOriginalLanguage(language);
            film.setRentalRate(BigDecimal.ZERO);
            film.setTitle("title");
            film.setRelease(Year.now());
            film.setRentalDuration((byte) 20);
            filmDAO.create(film);

            FilmText filmText = new FilmText();
            filmText.setId(film.getId());
            filmText.setFilm(film);
            filmText.setTitle("title");
            filmText.setDescription("description");
            filmTextDAO.create(filmText);
            session.getTransaction().commit();

        }
    }

    private void rentInventory(Customer customer) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Film film = filmDAO.getAvailableFilm();
            Store store = (Store) storeDAO.getItems(0, 1).get(0);
            Inventory inventory = new Inventory();
            inventory.setStore(store);
            inventory.setFilm(film);
            inventoryDAO.create(inventory);
            Staff staff = store.getStaff();
            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setCustomer(customer);
            rental.setStaff(staff);
            rentalDAO.create(rental);
            Payment payment = new Payment();
            payment.setStaff(staff);
            payment.setCustomer(customer);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setRental(rental);
            payment.setAmount(BigDecimal.valueOf(35.32));
            paymentDAO.create(payment);
            session.getTransaction().commit();
        }
    }

    private void returnRental() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Rental rental = rentalDAO.getUnreturnedRental();
            rental.setReturnDate(LocalDateTime.now());
            rentalDAO.create(rental);
            session.getTransaction().commit();
        }
    }

    private Customer createCustomer() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Store store = (Store) storeDAO.getItems(0, 1).get(0);
            City city = cityDAO.getByName("Faaa");
            Address address = new Address();
            address.setAddress("Address");
            address.setPhone("35435431");
            address.setCity(city);
            address.setDistrict("district");
            addressDAO.create(address);
            Customer customer = new Customer();
            customer.setStore(store);
            customer.setAddress(address);
            customer.setEmail("email");
            customer.setFirstName("Name");
            customer.setLastName("LastName");
            customer.setIsActive(true);
            customerDAO.create(customer);
            session.getTransaction().commit();
            return customer;
        }
    }
}
