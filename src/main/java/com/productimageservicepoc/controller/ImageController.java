package com.productimageservicepoc.controller;

import com.productimageservicepoc.entity.ImageTest;
import com.productimageservicepoc.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/")
    public void saveImage(@RequestBody ImageTest image) {
        imageRepository.save(image);
    }

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable(name = "id") Long id) {
        return imageRepository.findById(id).get().getImage();
    }

    @GetMapping("/id")
    public List<Long> getIds() {
        return imageRepository.findAll().stream().map((item) -> item.getId()).collect(Collectors.toList());
    }


}

