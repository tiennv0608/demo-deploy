package com.codegym.casestudy.repository.apartment;

import com.codegym.casestudy.model.apartment.Apartment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends PagingAndSortingRepository<Apartment,Long> {

    @Query("select apartment from Apartment apartment where apartment.quantityRoom >= ?1 ")
    Iterable<Apartment> findAllByQuantityRoom(int room);

    @Query("select apartment from Apartment  apartment where  apartment.floor >=?1 ")
    Iterable<Apartment> findAllByFloorIs(int floor);

    Iterable<Apartment> findAllByAddressContaining(String address);

    Iterable<Apartment> findAllByWardContaining(String ward);

    Iterable<Apartment> findAllByDistrictContaining(String district);

    Iterable<Apartment> findAllByPriceBetween(int low, int high);

    Iterable<Apartment> findAllByUserId(Long userId);

}
