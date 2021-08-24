package com.codegym.casestudy.controller.rent;

import com.codegym.casestudy.model.rent.Rent;
import com.codegym.casestudy.model.user.User;
import com.codegym.casestudy.repository.user.IUserRepository;
import com.codegym.casestudy.service.User.IUserService;
import com.codegym.casestudy.service.rent.IRentService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RentControllerAPI {
    @Autowired
    private IRentService rentService;

    @Autowired
    private IUserService userService;

    @GetMapping("/rents")
    public ResponseEntity<Iterable<Rent>> findAll() {
        Iterable<Rent> rents = rentService.findAll();
        return new ResponseEntity<>(rents, HttpStatus.OK);
    }

    @GetMapping("/rents/{statusId}/{userId}")
    public ResponseEntity<Iterable<Rent>> listOrder(@PathVariable Long statusId, @PathVariable Long userId) {
        List<Rent> rents = (List<Rent>) rentService.findAllByStatusIdAndUserId(statusId, userId);
        if (rents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rents, HttpStatus.OK);
    }

    @GetMapping("rents/{id}/list")
    public ResponseEntity<Iterable<Rent>> findAllByOwner(@PathVariable long id) {
        List<Rent> personalRents = (List<Rent>) rentService.findAllByApartment_UserId(id);
        if (personalRents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personalRents, HttpStatus.OK);
    }

    @GetMapping("rents/{id}/{statusId}/list")
    public ResponseEntity<Iterable<Rent>> findAllByOwnerAndStatus(@PathVariable long id, @PathVariable Long statusId) {
        List<Rent> personalRents = (List<Rent>) rentService.findAllByApartment_UserIdAndStatusId(id, statusId);
        if (personalRents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personalRents, HttpStatus.OK);
    }

    @GetMapping("/{userID}/rentList")
    public ResponseEntity<Iterable<Rent>> findAllByUserId(@PathVariable long userID) {
        Iterable<Rent> personalRents = rentService.findAllByUserId(userID);
        return new ResponseEntity<>(personalRents, HttpStatus.OK);
    }

    @PostMapping("/{userID}/rents")
    public ResponseEntity<Rent> save(@RequestBody Rent rent, @PathVariable long userID) {
        Optional<User> user = userService.findById(userID);
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rentService.save(rent);
        return new ResponseEntity<>(rent, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userID}/rents/{rentId}")
    public ResponseEntity<Void> delete(@PathVariable long userID, @PathVariable long rentId) {
        rentService.delete(rentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/rents/{id}")
    public ResponseEntity<Rent> findOne(@PathVariable Long id) {
        Optional<Rent> rent = rentService.findById(id);
        if (!rent.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rent.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}/rents")
    public ResponseEntity<Rent> update(@PathVariable Long id, @RequestBody Rent rent) {
        Optional<Rent> rentOptional = rentService.findById(id);
        if (!rentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rent.setId(id);
        rentService.save(rent);
        return new ResponseEntity<>(rent, HttpStatus.OK);
    }
}
