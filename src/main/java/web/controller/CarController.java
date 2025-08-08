package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(required = false) Integer count, Model model) {
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}