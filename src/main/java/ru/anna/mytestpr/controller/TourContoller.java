package ru.anna.mytestpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.anna.mytestpr.service.TourService;


@Controller
public class TourContoller {
    private TourService tourService;

    @Autowired
    public void setTourService(TourService tourService) {
        this.tourService = tourService;
    }


    @RequestMapping( value="/getTour")
    public String tour(Model model, @RequestParam(required = false) Long tourId){
        try{
        if (tourId!=null){
        model.addAttribute("tour", tourService.getTourById(tourId));}
        return "tourInfo";}
        catch (EmptyResultDataAccessException e){
            return "noTourException";
        }
    }

    @RequestMapping(value="/getAllTours")

    public String AllTours(Model model){
        model.addAttribute("tours", tourService.getAllTours());
        return "allTourInfo";
    }
}
