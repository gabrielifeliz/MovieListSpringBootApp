package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/addmovie")
    public String loadFormPage(Model model)
    {
        model.addAttribute("movie", new Movie());
        return "movieform";
    }

    @PostMapping("/addmovie")
    public String saveForm(@ModelAttribute("movie") Movie movie, Model model)
    {
        model.addAttribute("movie", movie);
        return "confirmmovie";
    }

}