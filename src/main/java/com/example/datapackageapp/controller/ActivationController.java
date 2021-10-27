package com.example.datapackageapp.controller;

import com.example.datapackageapp.model.Activation;
import com.example.datapackageapp.repository.ActivationRepository;
import com.example.datapackageapp.repository.CustomerRepository;
import com.example.datapackageapp.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/activations")
public class ActivationController {
    @Autowired
    private ActivationRepository activationRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PackageRepository packageRepository;

    @GetMapping("")
    public String viewActivationsPage(Model model) {
        List<Activation> listActivations = this.getAllActivations();
        model.addAttribute("listActivations", listActivations);
        return "activations";
    }

    @GetMapping("/list")
    private List<Activation> getAllActivations() {
        return activationRepository.findAll();
    }

    @GetMapping("/add-form")
    public String viewAddActivationPage(Model model) {
        Activation activation = new Activation();
        model.addAttribute("activation", activation);
        model.addAttribute("listCustomers", customerRepository.findAll());
        model.addAttribute("listPackages", packageRepository.findAll());
        return "add_activation";
    }

    @GetMapping("/edit-form/{id}")
    public String showEditActivationPage(@PathVariable(name = "id") int id, Model model) {
        Activation activation = activationRepository.findActivationById(id);
        model.addAttribute("activation", activation);
        model.addAttribute("listPackages", packageRepository.findAll());
        return "edit_activation";
    }

    @GetMapping("/find/{id}")
    public Activation findActivationById(@PathVariable Integer id) {
        return activationRepository.findActivationById(id);
    }

    @PostMapping("/add")
    public String addActivation(@ModelAttribute("activation") Activation activation){
        activationRepository.save(activation);
        return "redirect:/activations";
    }

    @PutMapping("/edit")
    public String editActivation(@ModelAttribute("activation") Activation activation) {
        activationRepository.save(activation);
        return "redirect:/activations";
    }

    @DeleteMapping("/delete/{id}")
    private String deleteActivation(@PathVariable Integer id) {
        activationRepository.delete(this.findActivationById(id));
        return "redirect:/activations";
    }

}
