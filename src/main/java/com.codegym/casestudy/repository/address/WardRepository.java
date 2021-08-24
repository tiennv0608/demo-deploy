package com.codegym.casestudy.repository.address;

import com.codegym.casestudy.model.address.Ward;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends PagingAndSortingRepository<Ward,Long> {

    @Query("select ward from Ward ward where ward.district.id =?1 ")
    Iterable<Ward> findAllByDistrictId(long id);

}
