package com.example.datapackageapp.controller;

import com.example.datapackageapp.model.Package;
import com.example.datapackageapp.repository.PackageRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import java.util.List;

@Controller
@RequestMapping("/packages")
public class PackageController {
    @Autowired
    private PackageRepository packageRepository;

    @GetMapping("")
    public String viewPackagesPage(Model model) {
        List<Package> listPackages = this.getAllPackages();
        model.addAttribute("listPackages", listPackages);
        return "packages";
    }

    @GetMapping("/add-form")
    public String viewAddPackagePage(Model model) {
        Package p = new Package();
        model.addAttribute("package", p);
        return "add_package";
    }

    @GetMapping("/edit-form/{id}")
    public String showEditPackagePage(@PathVariable(name = "id") int id, Model model) {
        Package p = packageRepository.findPackageById(id);
        model.addAttribute("p", p);
        return "edit_package";
    }


    @GetMapping("/list")
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Package findPackageById(@PathVariable Integer id) {
        return packageRepository.findPackageById(id);
    }

    @PostMapping("/add")
    public String addPackage(@ModelAttribute("p") Package p) {
        packageRepository.save(p);
        return "redirect:/packages";
    }

    @PutMapping("/edit")
    public String editPackage(@ModelAttribute(value = "p") Package p) {
        packageRepository.save(p);
        return "redirect:/packages";
    }

    @DeleteMapping("/delete/{id}")
    private String deletePackage(@PathVariable Integer id) {
        packageRepository.delete(this.findPackageById(id));
        return "redirect:/packages";
    }
}
