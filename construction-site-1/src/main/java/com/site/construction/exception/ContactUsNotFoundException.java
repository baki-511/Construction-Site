package com.site.construction.exception;

public class ContactUsNotFoundException extends RuntimeException{
    public ContactUsNotFoundException(Integer contactId) {
        super("Contact NOT Found With ID : " + contactId);
    }
}
