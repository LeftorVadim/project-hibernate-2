package entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "address")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    Short id;
    @Column(name = "address")
    String address;
    @Column(name = "address2")
    String address2;
    @Column(name = "district")
    String district;
    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;
    @Column(name = "postal_code")
    String postalCode;
    @Column(name = "phone")
    String phone;
    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
