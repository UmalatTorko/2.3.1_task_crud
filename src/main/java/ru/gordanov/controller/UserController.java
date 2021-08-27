package ru.gordanov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gordanov.model.User;
import ru.gordanov.service.UserService;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user ) {
        return "newUser";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "updateUser";
    }

    @PatchMapping()
    public String update(@ModelAttribute("user") User user) {
        service.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        service.delete(id);
        return "redirect:/";
    }
}
