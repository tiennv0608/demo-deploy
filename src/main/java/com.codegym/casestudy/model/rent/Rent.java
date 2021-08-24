package com.codegym.casestudy.model.rent;

import com.codegym.casestudy.model.apartment.Apartment;
import com.codegym.casestudy.model.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Apartment apartment;
    private String createDate;
    private String startDate;
    private String endDate;
    @ManyToOne
    private Status status;

    public Rent(User user, Apartment apartment, Status status) {
        this.user = user;
        this.apartment = apartment;
        this.status = status;
    }

    public Rent(User user, Apartment apartment, String startDate, Status status) {
        this.user = user;
        this.apartment = apartment;
        this.startDate = startDate;
        this.status = status;
    }

    public Rent() {
    }
}
