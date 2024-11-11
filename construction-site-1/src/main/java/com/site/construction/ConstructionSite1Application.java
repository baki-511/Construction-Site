package com.site.construction;

import com.site.construction.entity.AdminUser;
import com.site.construction.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ConstructionSite1Application implements CommandLineRunner {
    @Autowired
    private AdminUserRepository adminUserRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public static void main(String[] args) {
        SpringApplication.run(ConstructionSite1Application.class, args);
        System.out.println("Application is Running...");
    }
    
    @Override
    public void run(String... args) throws Exception {
//        AdminUser adminUser = new AdminUser();
//        adminUser.setUsername("navin@gmail.com");
//        adminUser.setFullName("Navin Sharma");
//        adminUser.setPassword(passwordEncoder.encode("admin"));
//        adminUser.setRole("ADMIN");
//        adminUserRepository.save(adminUser);
    }
}
