package org.example;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "staff")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    Byte id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;
    @Lob
    @Column(name = "picture", columnDefinition = "blob")
    byte[] picture;
    @Column(name = "email")
    String email;
    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;
    @Column(name = "active", columnDefinition = "BIT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    Boolean isActive;
    @Column(name = "username")
    String userName;
    @Column(name = "password")
    String password;
    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
