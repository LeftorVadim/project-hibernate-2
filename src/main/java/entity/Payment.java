package entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "payment")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    Short id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    Staff staff;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    Rental rental;
    @Column(name = "amount")
    BigDecimal amount;
    @Column(name = "payment_date")
    @CreationTimestamp
    LocalDateTime paymentDate;
}
