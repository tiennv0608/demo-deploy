package com.codegym.casestudy.model.apartment;

import com.codegym.casestudy.model.apartment.Apartment;
import com.codegym.casestudy.model.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private User user;
    @ManyToOne
    private Apartment apartment;

    private int clickCount;

    public Rate(User user, Apartment apartment, int clickCount) {
        this.user = user;
        this.apartment = apartment;
        this.clickCount = clickCount;
    }

    public Rate() {
    }
}
