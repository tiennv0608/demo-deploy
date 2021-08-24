package com.codegym.casestudy.service.address;

import com.codegym.casestudy.model.address.Ward;
import com.codegym.casestudy.service.IGeneralService;

public interface IWardService extends IGeneralService<Ward> {
    Iterable<Ward> findAllByDistrictId(long id);
}
