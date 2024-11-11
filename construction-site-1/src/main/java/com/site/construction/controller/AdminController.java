package com.site.construction.controller;

import com.site.construction.entity.Project;
import com.site.construction.entity.Services;
import com.site.construction.service.ContactUsService;
import com.site.construction.service.ProjectService;
import com.site.construction.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ServicesService servicesService;
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private ContactUsService contactUsService;
    
    @GetMapping("/")
    public String adminHome() {
        return "admin/admin-index";
    }
    
    @GetMapping("/add-service")
    public String addService(Model model) {
        model.addAttribute("service", new Services());
        return "admin/pages/add-service";
    }
    
    @PostMapping("/service/add")
    public String addServices(@ModelAttribute Services services,
                              @RequestParam("imageFile") MultipartFile imageFile, Model model)
            throws IOException {
        servicesService.addServices(services, imageFile);
        return "redirect:/admin/add-service";
    }
    
    @GetMapping("/all-service")
    public String allServices(Model model) {
        model.addAttribute("services", servicesService.getAllServices());
        return "/admin/pages/all-services";
    }
    
    @GetMapping("/service/edit/{serviceId}")
    public String editService(Model model, @PathVariable Integer serviceId) {
        Services serviceById = servicesService.getServiceById(serviceId);
        model.addAttribute("service", serviceById);
        return "/admin/pages/edit-service";
    }
    
    @PostMapping("/service/edit")
    public String editService(@ModelAttribute Services services,
                              @RequestParam("imageFile") MultipartFile file,
                              Model model) {
        servicesService.updateService(services, file);
        return "redirect:/admin/all-service";
    }
    
    @GetMapping("/service/delete/{id}")
    public String deleteService(@PathVariable Integer id) {
        servicesService.deleteService(id);
        return "redirect:/admin/all-service";
    }
    
    @GetMapping("/all-project")
    public String allProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "/admin/pages/all-projects";
    }
    
    @GetMapping("/add-project")
    public String addProject(Model model) {
        model.addAttribute("project", new Project());
        return "admin/pages/add-project";
    }
    
    @PostMapping("/project/add")
    public String addProject(@ModelAttribute Project projects,
                              @RequestParam("imageFile") MultipartFile imageFile, Model model)
            throws IOException {
        projectService.addProject(projects, imageFile);
        return "redirect:/admin/add-project";
    }
    
    
    @GetMapping("/project/edit/{projectId}")
    public String editProject(Model model, @PathVariable Integer projectId) {
        Project projectById = projectService.getProjectById(projectId);
        model.addAttribute("project", projectById);
        return "/admin/pages/edit-project";
    }
    
    @PostMapping("/project/edit")
    public String editProject(@ModelAttribute Project projects,
                              @RequestParam("imageFile") MultipartFile file,
                              Model model) {
        projectService.updateProject(projects, file);
        return "redirect:/admin/all-project";
    }
    
    @GetMapping("/project/delete/{id}")
    public String deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
        return "redirect:/admin/all-project";
    }
    
    @GetMapping("/contacts")
    public String getAllContacts(Model model) {
        model.addAttribute("contacts", contactUsService.getAllContactUs());
        return "/admin/pages/all-contacts";
    }
}
