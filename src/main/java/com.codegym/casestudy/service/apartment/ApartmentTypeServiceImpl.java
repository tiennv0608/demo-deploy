package com.codegym.casestudy.service.apartment;

import com.codegym.casestudy.model.apartment.ApartmentType;
import com.codegym.casestudy.model.comment.Comment;
import com.codegym.casestudy.repository.apartment.ApartmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApartmentTypeServiceImpl implements IApartmentType{
    @Autowired
    private ApartmentTypeRepository apartmentTypeRepository;

    @Override
    public Iterable<ApartmentType> findAll() {
        return apartmentTypeRepository.findAll();
    }

    @Override
    public Optional<ApartmentType> findById(Long id) {
        return apartmentTypeRepository.findById(id);
    }

    @Override
    public ApartmentType save(ApartmentType apartmentType) {
        return apartmentTypeRepository.save(apartmentType);
    }

    @Override
    public void delete(Long id) {
        apartmentTypeRepository.deleteById(id);
    }
}
