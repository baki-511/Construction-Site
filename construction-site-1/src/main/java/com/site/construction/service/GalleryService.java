package com.site.construction.service;


import com.site.construction.entity.Gallery;
import com.site.construction.exception.GalleryNotFoundException;
import com.site.construction.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;
    
    public Gallery saveGallery(Gallery gallery, MultipartFile file) {
        String image = "";
        try {
            image = Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        gallery.setImage(image);
        return galleryRepository.save(gallery);
    }
    
    public List<Gallery> getAllGallery() {
        return galleryRepository.findAll();
    }
    
    public Gallery getGalleryById(Integer galleryId) {
        return galleryRepository.findById(galleryId)
                .orElseThrow(() -> new GalleryNotFoundException(galleryId));
    }
    
    public String deleteGallery(Integer galleryId) {
        Gallery galleryById = getGalleryById(galleryId);
        galleryRepository.delete(galleryById);
        return "Gallery Deleted Successfully!";
    }
}
