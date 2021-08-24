package com.codegym.casestudy.controller.address;

import com.codegym.casestudy.model.address.District;
import com.codegym.casestudy.model.address.Ward;
import com.codegym.casestudy.service.address.DistrictServiceImpl;
import com.codegym.casestudy.service.address.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin("*")
public class DistrictControllerAPI {
    @Autowired
    private DistrictServiceImpl districtService;

    @Autowired
    private IWardService wardService;

    @GetMapping("")
    public ResponseEntity<Iterable<District>> findAll() {
        Iterable<District> districts = districtService.findAll();
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Ward>> findAllByDistrictName(@PathVariable long id) {
        for(District district: districtService.findAll()) {
            if (district.getId() == id ) {
                Iterable<Ward> wards = wardService.findAllByDistrictId(district.getId());
                return new ResponseEntity<>(wards, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
