package com.example.dorywcza.controller;

import com.example.dorywcza.service.ImageService.ImageService;
import com.example.dorywcza.util.Image;
import com.example.dorywcza.util.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ImageController {
    @Autowired
    ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("image") MultipartFile image,
                              @RequestParam("userId") Long userId,
                              @RequestParam("avatar") Boolean isAvatar) throws Exception {

        try {
            Image uploadedImage = imageService.store(image, userId, isAvatar);
            return "File " + uploadedImage.getImageName() + " uploaded";
        } catch (Exception e) {
            e.printStackTrace();
            return "File " + image.getOriginalFilename() + " could not be uploaded";

        }

    }

    @GetMapping("/images/{id}")
    public ImageDTO getImage(@PathVariable Long id){
        return imageService.findImage(id);
    }

    @GetMapping("/images")
    public List<ImageDTO> getAllImages(){
        return imageService.getAllImages();
    }

    @GetMapping(value="/resources/{id}", produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE})
        public @ResponseBody byte[] getRealImage(@PathVariable Long id){
            return imageService.findRealImage(id);
        }

}
