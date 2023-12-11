package web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import web.models.User;

@Controller
public class UsersController {

    private final UserDAO userDao;

    public UsersController(UserDAO personDAO) {
        this.userDao = personDAO;
    }
    //-------READ-------
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDao.getUsers());
        return "people/index";
    }
    //-----CREATE------
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userDao.save(user);
        return "redirect:/";

    }
    //----UPDATE---
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model){
        model.addAttribute("user",userDao.show(id));
        return "people/edit";
    }

    @PatchMapping("/")
    public String update(@ModelAttribute("user") User user, @RequestParam int id ){
        userDao.update(id,user);
        return "redirect:/";
    }
    //----DELETE----
    @DeleteMapping
    public String delete(@RequestParam int id){
        userDao.delete(id);
        return "redirect:/";
    }

}