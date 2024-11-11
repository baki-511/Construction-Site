package com.site.construction.service;

import com.site.construction.entity.Services;
import com.site.construction.exception.ServiceNotFoundException;
import com.site.construction.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;
    
    public Services addServices(Services services, MultipartFile file) {
        String image = "";
        try {
            image = Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        services.setImage(image);
        return servicesRepository.save(services);
    }
    
    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }
    
    public Services getServiceById(Integer serviceId) {
        return servicesRepository.findById(serviceId)
                .orElseThrow(() -> new ServiceNotFoundException(serviceId));
    }
    
    public String deleteService(Integer serviceId) {
        Services service = getServiceById(serviceId);
        servicesRepository.delete(service);
        return "Service Deleted Successfully!";
    }
    
    public Services updateService(Services services, MultipartFile file) {
        Services serviceById = getServiceById(services.getServiceId());
        if (file.isEmpty()) {
            services.setImage(serviceById.getImage());
        } else {
            String image = "";
            try {
                image = Base64.getEncoder().encodeToString(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            services.setImage(image);
        }
        return servicesRepository.save(services);
    }
}
