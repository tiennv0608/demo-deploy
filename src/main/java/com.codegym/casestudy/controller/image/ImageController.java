package com.codegym.casestudy.controller.image;

import com.codegym.casestudy.model.image.Image;
import com.codegym.casestudy.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/images")
@CrossOrigin("*")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @GetMapping
    public ResponseEntity<Iterable<Image>> findAll() {
        List<Image> images = (List<Image>) imageService.findAll();
        if (images.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Image> create(@RequestBody Image image) {
        return new ResponseEntity<>(imageService.save(image), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> update(@PathVariable Long id, @RequestBody Image image) {
        Optional<Image> currentImage = imageService.findById(id);
        if (!currentImage.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (image.getPathName().equals("")) {
            image.setPathName(currentImage.get().getPathName());
        }
        image.setId(id);
        return new ResponseEntity<>(imageService.save(image), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Image> image = imageService.findById(id);
        if (!image.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        imageService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
