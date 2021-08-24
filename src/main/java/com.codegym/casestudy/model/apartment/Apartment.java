package com.codegym.casestudy.model.apartment;

import com.codegym.casestudy.model.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter @Setter
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String image;
    private double square;
    private int quantityRoom;
    private int floor;
    private String description;
    private String address;
    private String ward;
    private String district;
    private int price;
    @ManyToOne
    private ApartmentType type;
    @ManyToOne
    private User user;
    private String postTitle;
    private String createdTime;

    public Apartment(String image, double square, int quantityRoom, int floor, String description, String address, String ward, String district, int price, ApartmentType type, User user, String postTitle) {
        this.image = image;
        this.square = square;
        this.quantityRoom = quantityRoom;
        this.floor = floor;
        this.description = description;
        this.address = address;
        this.ward = ward;
        this.district = district;
        this.price = price;
        this.type = type;
        this.user = user;
        this.postTitle = postTitle;
        this.createdTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm;ss"));
    }

    public Apartment() {
    }
}
