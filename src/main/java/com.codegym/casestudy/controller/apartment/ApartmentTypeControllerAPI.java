package com.codegym.casestudy.controller.apartment;

import com.codegym.casestudy.model.apartment.ApartmentType;
import com.codegym.casestudy.service.apartment.IApartmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apartment-types")
@CrossOrigin("*")
public class ApartmentTypeControllerAPI {
    @Autowired
    private IApartmentType apartmentTypeService;

    @GetMapping("")
    public ResponseEntity<Iterable<ApartmentType>> findAll() {
        Iterable<ApartmentType> apartmentTypes = apartmentTypeService.findAll();
        return new ResponseEntity<>(apartmentTypes, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Void> create(@RequestBody ApartmentType apartmentType) {
        apartmentTypeService.save(apartmentType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        apartmentTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
