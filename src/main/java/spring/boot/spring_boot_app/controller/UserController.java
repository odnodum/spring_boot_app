package spring.boot.spring_boot_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.boot.spring_boot_app.model.User;
import spring.boot.spring_boot_app.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUsers(Model model) {
        model.addAttribute("usersList", userService.findAll());
        return "/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "editPage";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user, BindingResult bindingResult,
                           @PathVariable("id") int id) {
        if(bindingResult.hasErrors()){
            return "/edit";
        }
        userService.update(id, user);
        return "redirect:/";
    }

    @GetMapping(value = "/add")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user,
                          BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/add";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
