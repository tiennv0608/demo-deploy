package com.codegym.casestudy.controller.apartment;

import com.codegym.casestudy.model.apartment.Apartment;
import com.codegym.casestudy.service.apartment.IApartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apartments")
@CrossOrigin("*")
public class ApartmentControllerAPI {
    @Autowired
    private IApartment apartmentService;

    @GetMapping("")
    public ResponseEntity<Iterable<Apartment>> findAll() {
        Iterable<Apartment> apartmentList = apartmentService.findAll();
        return new ResponseEntity<>(apartmentList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> create(@RequestBody Apartment apartment) {
        apartmentService.save(apartment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<Iterable<Apartment>> findAllByUser(@PathVariable Long userId){
        List<Apartment> apartments = (List<Apartment>) apartmentService.findAllByUserId(userId);
        if (apartments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apartments, HttpStatus.OK);
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity<Apartment> detail(@PathVariable long id) {
        Optional<Apartment> selectedApartment = apartmentService.findById(id);
        if (selectedApartment.isPresent()) {
            return new ResponseEntity<>(selectedApartment.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> edit(@PathVariable long id, @RequestBody Apartment apartment) {
        Optional<Apartment> selectedApartment = apartmentService.findById(id);
        if (selectedApartment.isPresent()) {
            apartment.setId(id);
            apartmentService.save(apartment);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Apartment> delete(@PathVariable long id) {
        Optional<Apartment> selectedApartment = apartmentService.findById(id);
        if (selectedApartment.isPresent()) {
            apartmentService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findByRoom/{room}")
    public ResponseEntity<Iterable<Apartment>> findAllByRoom(@PathVariable int room) {
        Iterable<Apartment> foundList = apartmentService.findAllByQuantityRoom(room);
        return new ResponseEntity<>(foundList, HttpStatus.OK);
    }

    @GetMapping("/findByFloor/{floor}")
    public ResponseEntity<Iterable<Apartment>> findAllByFloor(@PathVariable int floor) {
        Iterable<Apartment> foundList = apartmentService.findAllByFloorIs(floor);
        return new ResponseEntity<>(foundList, HttpStatus.OK);
    }

    @GetMapping("/findByAddress/{address}")
    public ResponseEntity<Iterable<Apartment>> findByAddress(@PathVariable String address) {
        Iterable<Apartment> foundList = apartmentService.findByAddress(address);
        return new ResponseEntity<>(foundList, HttpStatus.OK);
    }

    @GetMapping("/findByDistrict/{district}")
    public ResponseEntity<Iterable<Apartment>> findAllByDistrict(@PathVariable String district) {
        Iterable<Apartment> foundList = apartmentService.findAllByDistrict(district);
        return new ResponseEntity<>(foundList, HttpStatus.OK);
    }

    @GetMapping("/findByWard/{ward}")
    public ResponseEntity<Iterable<Apartment>> findByWard(@PathVariable String ward) {
        Iterable<Apartment> foundList = apartmentService.findByWard(ward);
        return new ResponseEntity<>(foundList, HttpStatus.OK);
    }

    @GetMapping("/findByPrice/{low}-{high}")
    public ResponseEntity<Iterable<Apartment>> findAllByPrice(@PathVariable int low, @PathVariable int high) {
        Iterable<Apartment> foundList = apartmentService.findAllByPrice(low, high);
        return new ResponseEntity<>(foundList, HttpStatus.OK);
    }

}
