package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String displayHome() {
        return "index";
    }


    @GetMapping("/addmovie")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "addmovie";
    }

    @PostMapping("/process")
    public String processForm(@Valid Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return "addmovie";
        }
        movieRepository.save(movie);
        return "redirect:/showmovies";
    }

    @RequestMapping("/showmovies")
    public String showMovies(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "listmovies";
    }

    @RequestMapping("/detail/{id}")
    public String movieDetails(@PathVariable("id") long id, Model model) {
        model.addAttribute("movie", movieRepository.findById(id).get());
        return "showmovie";
    }
    @RequestMapping("/update/{id}")
    public String updateMovie( @PathVariable("id") long id, Model model){
        model.addAttribute("movie", movieRepository.findById(id).get());
        return "addmovie";
    }

    @RequestMapping("/delete/{id}")
    public  String deleteMovie(@PathVariable("id") long id){
        movieRepository.deleteById(id);
        return "listmovies";
    }

    @RequestMapping("/search")
    public String showSearchResults(HttpServletRequest request, Model model)
    {
        //Get the search string from the result form
        String searchString = request.getParameter("search");
        model.addAttribute("search", searchString);
        model.addAttribute("movies",
                movieRepository.findAllByTitleContainingIgnoreCase(searchString));
        return "listmovies";
    }
}