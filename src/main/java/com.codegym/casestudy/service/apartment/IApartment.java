package com.codegym.casestudy.service.apartment;

import com.codegym.casestudy.model.apartment.Apartment;
import com.codegym.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IApartment extends IGeneralService<Apartment> {
    Page<Apartment> findAll(Pageable pageable);

    Iterable<Apartment> findAllByQuantityRoom(int room);

    Iterable<Apartment> findAllByFloorIs(int floor);

    Iterable<Apartment> findAllByDistrict(String district);

    Iterable<Apartment> findByAddress(String address);

    Iterable<Apartment> findByWard(String ward);

    Iterable<Apartment> findAllByPrice(int low, int high);

    Iterable<Apartment> findAllByUserId(Long userId);
}
