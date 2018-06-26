package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String homePage() {
        return "index";
    }
    
    @GetMapping("/add")
    public String courseForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movieform";
    }
    
    @PostMapping("/process")
    public String processForm(@Valid Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return "movieform";
        }
        movieRepository.save(movie);
        return "redirect:/";
    }

    @GetMapping("/movielist")
    public String movieList(Model model){
        model.addAttribute("movies", movieRepository.findAll());
        return "movielist";
    }

    @RequestMapping("/detail/{id}")
    public String showMovie(@PathVariable("id") long id, Model model) {
        model.addAttribute("movie", movieRepository.findById(id).get());
        return "showmovie";
    }
    @RequestMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") long id, Model model) {
        model.addAttribute("movie", movieRepository.findById(id));
        return "movieform";
    }
    @RequestMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") long id) {
        movieRepository.deleteById(id);
        return "redirect:/";
    }
}
