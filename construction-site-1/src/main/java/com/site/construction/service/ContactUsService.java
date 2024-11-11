package com.site.construction.service;

import com.site.construction.entity.ContactUs;
import com.site.construction.exception.ContactUsNotFoundException;
import com.site.construction.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsService {
    @Autowired
    private ContactUsRepository contactUsRepository;
    
    public ContactUs addContactUs(ContactUs contactUs) {
        return contactUsRepository.save(contactUs);
    }
    
    public List<ContactUs> getAllContactUs() {
        return contactUsRepository.findAll();
    }
    
    public ContactUs getContactById(Integer contactId) {
        return contactUsRepository.findById(contactId)
                .orElseThrow(() -> new ContactUsNotFoundException(contactId));
    }
}
