package com.codegym.casestudy.service.rent;


import com.codegym.casestudy.model.rent.Rent;
import com.codegym.casestudy.service.IGeneralService;

public interface IRentService  extends IGeneralService<Rent> {
    Iterable<Rent> findAllByUserId(long id);

    Iterable<Rent> findAllByStatusIdAndUserId(Long statusId, Long userId);

    Iterable<Rent> findAllByApartment_UserId(Long id);

    Iterable<Rent> findAllByApartment_UserIdAndStatusId(Long id, Long statusId);
}
