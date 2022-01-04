package com.mycompany.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Service
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/home")
    public String showUserList(Model model) {
        return "home";
    }
    @GetMapping("/login")
    public String gotologin(Model model) {
        return "login";
    }
    @GetMapping("/checkout")
    public String gotocheckout(Model model) {
        return "checkout";
    }
    @GetMapping("/finish")
    public String gotofinish(Model model) {
        return "finish";
    }
    @GetMapping("/history")
    public String gotohistory(Model model) {
        return "history";
    }
    @GetMapping("/profiledata")
    public String gotoprofiledata(Model model) {
        return "profiledata";
    }
    @GetMapping("/shopcart")
    public String gotoshopcart(Model model) {
        return "shopcart";
    }
    @GetMapping("/signal")
    public String gotosignal(Model model) {
        return "signal";
    }
    @GetMapping("/signal2")
    public String gotosignal2(Model model) {
        return "signal2";
    }
    @GetMapping("/profile")
    public String gotoprofile(Model model) {
        return "profile";
    }
    @GetMapping("/empty")
    public String gotoempty(Model model) {
        return "empty";
    }
    @GetMapping("/grammatical")
    public String gotogrammatical(Model model) {
        return "grammatical";
    }
    @GetMapping("/register")
    public String showNewFrom(Model model) {
        model.addAttribute("user", new User());
        return "user_from";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        if (user.getFirstName() == "" || user.getpassword() == "" || user.getaddress() == "") {
            return "empty";
        }else if(!user.checkEmail()){
            return "grammatical";
        }
        service.save(user);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/home";
    }
    public String saveUser(User user) {
        if (user.getFirstName() == "" || user.getpassword() == "" || user.getaddress() == "") {
            return "empty";
        }else if(!user.checkEmail()){
            return "grammatical";
        }
        return "redirect:/home";
    }
    /**
     * Immplementation of updated and delete
     */

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            User user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit Book (ID: " + id + ")");

            return "user_from";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The user id" + id + "has been deleted");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";

    }


}
