package com.codegym.casestudy.service.apartment;

import com.codegym.casestudy.model.apartment.Apartment;
import com.codegym.casestudy.model.comment.Comment;
import com.codegym.casestudy.repository.apartment.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApartmentServiceImpl implements IApartment {
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public Iterable<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    @Override
    public Optional<Apartment> findById(Long id) {
        return apartmentRepository.findById(id);
    }

    @Override
    public Apartment save(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Override
    public void delete(Long id) {
        apartmentRepository.deleteById(id);
    }

    @Override
    public Page<Apartment> findAll(Pageable pageable) {
        return apartmentRepository.findAll(pageable);
    }

    @Override
    public Iterable<Apartment> findAllByQuantityRoom(int room) {
        return apartmentRepository.findAllByQuantityRoom(room);
    }

    @Override
    public Iterable<Apartment> findAllByFloorIs(int floor) {
        return apartmentRepository.findAllByFloorIs(floor);
    }

    @Override
    public Iterable<Apartment> findAllByDistrict(String district) {
        return apartmentRepository.findAllByDistrictContaining(district);
    }

    @Override
    public Iterable<Apartment> findByAddress(String address) {
        return apartmentRepository.findAllByAddressContaining(address);
    }

    @Override
    public Iterable<Apartment> findByWard(String ward) {
        return apartmentRepository.findAllByWardContaining(ward);
    }

    @Override
    public Iterable<Apartment> findAllByPrice(int low, int high) {
        return apartmentRepository.findAllByPriceBetween(low, high);
    }

    @Override
    public Iterable<Apartment> findAllByUserId(Long userId) {
        return apartmentRepository.findAllByUserId(userId);
    }
}
