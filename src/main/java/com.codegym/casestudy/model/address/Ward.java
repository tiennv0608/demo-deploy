package com.codegym.casestudy.model.address;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private District district;
    private String wardName;

    public Ward(District district, String wardName) {
        this.district = district;
        this.wardName = wardName;
    }

    public Ward() {
    }
}
