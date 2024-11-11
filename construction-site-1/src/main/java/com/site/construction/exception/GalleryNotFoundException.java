package com.site.construction.exception;

public class GalleryNotFoundException extends RuntimeException{
    public GalleryNotFoundException(Integer galleryId) {
        super("Gallery NOT Found With ID : " + galleryId);
    }
}
