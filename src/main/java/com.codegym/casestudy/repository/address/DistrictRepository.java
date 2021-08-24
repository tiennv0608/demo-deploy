package com.codegym.casestudy.repository.address;

import com.codegym.casestudy.model.address.District;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends PagingAndSortingRepository<District,Long> {
}
