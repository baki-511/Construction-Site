package com.site.construction.exception;

public class ServiceNotFoundException extends RuntimeException{
    public ServiceNotFoundException(Integer id) {
        super("Service NOT Found With ID : " + id);
    }
}
