package com.codegym.casestudy.repository.rent;

import com.codegym.casestudy.model.rent.Rent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends PagingAndSortingRepository<Rent, Long> {

    @Query("select rent from Rent rent where rent.user.id =?1 ")
    Iterable<Rent> findAllByUserId(long id);

    Iterable<Rent> findAllByStatusIdAndUserId(Long statusId, Long userId);

    Iterable<Rent> findAllByApartment_UserId(Long id);

    Iterable<Rent> findAllByApartment_UserIdAndStatusId(Long id, Long statusId);
}
