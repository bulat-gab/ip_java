package ru.stc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.stc.model.Car;
import ru.stc.services.HomeService;

@Controller
public class HomeController {
    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("car", homeService.getSomeCar());
        return "home";
    }

    @GetMapping("/superhome")
    public String getSuperHome(Model model) {
        model.addAttribute("car", new Car(1, "GAZ", 15));
        return "home";
    }

    @PostMapping("/savehome")
    public ModelAndView postHome(@ModelAttribute Car car) {
//        SecurityContextHolder.getContext().getAuthentication().
        ModelAndView home = new ModelAndView("home");
        car.setAmount(car.getAmount() + 10);
        home.addObject("car", car);
        return home;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
