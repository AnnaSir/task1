package ru.anna.mytestpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.anna.mytestpr.exceptions.BusinessException;
import ru.anna.mytestpr.service.TourService;


@Controller
public class TourContoller {
    private TourService tourService;

    @ExceptionHandler(BusinessException.class)
    public ModelAndView handleBusinessException (BusinessException e) {
        ModelAndView modelAndView = new ModelAndView("noTourException");
        modelAndView.addObject("result", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleIOException (Exception e) {
        ModelAndView modelAndView = new ModelAndView("exceptions");
        modelAndView.addObject("result", e.getMessage());
        return modelAndView;
    }

    @Autowired
    public void setTourService(TourService tourService) {
        this.tourService = tourService;
    }

    @RequestMapping(value = "/getAllTours")
    public String allTours(Model model) {
        model.addAttribute("tours", tourService.getAllTours());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(((UserDetails) authentication.getPrincipal()).getUsername());
        return "allTourInfo";
    }
}
