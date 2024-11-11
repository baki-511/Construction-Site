package com.site.construction.controller;

import com.site.construction.entity.ContactUs;
import com.site.construction.service.ContactUsService;
import com.site.construction.service.ProjectService;
import com.site.construction.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private ServicesService servicesService;
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private ContactUsService contactUsService;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("services", servicesService.getAllServices());
        return "index";
    }
    
    @GetMapping("/about")
    public String about() {
        return "/pages/about";
    }
    
    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("services", servicesService.getAllServices());
        return "/pages/services";
    }
    
    @GetMapping("/portfolio")
    public String portfolio(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "/pages/portfolio";
    }
    
    @GetMapping("/team")
    public String team() {
        return "/pages/team";
    }
    
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contact", new ContactUs());
        return "/pages/contact";
    }
    
    @PostMapping("/contact-us")
    public String saveContactUsMsg(@ModelAttribute ContactUs contactUs) {
        System.out.println("1");
        System.out.println(contactUs);
        contactUsService.addContactUs(contactUs);
        return "redirect:/contact";
    }
    
}
