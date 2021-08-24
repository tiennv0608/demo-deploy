package com.codegym.casestudy.service.address;

import com.codegym.casestudy.model.address.Ward;
import com.codegym.casestudy.model.comment.Comment;
import com.codegym.casestudy.repository.address.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WardServiceImpl implements IWardService {
    @Autowired
    private WardRepository wardRepository;

    @Override
    public Iterable<Ward> findAll() {
        return wardRepository.findAll();
    }

    @Override
    public Optional<Ward> findById(Long id) {
        return wardRepository.findById(id);
    }

    @Override
    public Ward save(Ward ward) {
        return wardRepository.save(ward);
    }

    @Override
    public void delete(Long id) {
        wardRepository.deleteById(id);
    }

    @Override
    public Iterable<Ward> findAllByDistrictId(long id) {
        return wardRepository.findAllByDistrictId(id);
    }
}
