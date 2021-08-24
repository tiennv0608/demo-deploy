package com.codegym.casestudy.service.address;

import com.codegym.casestudy.model.address.District;
import com.codegym.casestudy.model.comment.Comment;
import com.codegym.casestudy.repository.address.DistrictRepository;
import com.codegym.casestudy.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictServiceImpl implements IGeneralService<District> {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Iterable<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public Optional<District> findById(Long id) {
        return districtRepository.findById(id);
    }

    @Override
    public District save(District district) {
        return districtRepository.save(district);
    }

    @Override
    public void delete(Long id) {
        districtRepository.deleteById(id);
    }
}
