package ru.igorelesin.springbootapp.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.igorelesin.springbootapp.model.User;
import ru.igorelesin.springbootapp.service.UserService;

import java.util.List;


@Controller
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/users")
    public String allUser(Model map) {
        List<User> allUsers = service.getAllUsers();
        map.addAttribute("users", allUsers);
        return "user";
    }

    @GetMapping("/new")
    public String createPages(ModelMap map) {
        User user = new User();
        map.addAttribute("user", user);
        return "createUser";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) return "createUser";
        service.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") Long id, ModelMap map) {
        map.addAttribute("user", service.findUser(id));
        return "editUser";
    }

    @PostMapping("/update")
    public String edit(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) return "editUser";
        service.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        service.deleteUser(id);
        return "redirect:/users";
    }
}
