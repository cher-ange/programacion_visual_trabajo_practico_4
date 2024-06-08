package ar.edu.unju.fi.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CareerManager;
import ar.edu.unju.fi.model.Career;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
@Controller
@RequestMapping(path = "/career")
public class CareerController {
    
    private final Career career;

    public CareerController(Career career) {
        this.career = career;
    }

    @GetMapping(path = "/list")
    public ModelAndView getListOfCareersPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("career/careers");
        modelAndView.addObject("listOfCareers", CareerManager.getAll());

        return modelAndView;
    }

    @GetMapping(path = "/add")
    public ModelAndView getCareerFormPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("career/career-form");
        modelAndView.addObject("careerSubmitted", career);
        modelAndView.addObject("allowEditing", false);

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView postCareerFormPage(@ModelAttribute(name = "careerSubmitted") Career career) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/career/list");
        CareerManager.add(career);

        return modelAndView;
    }

    @GetMapping(path = "/modify/{identification}")
    public ModelAndView getModifyCareerFormPage(@PathVariable(value = "identification") String careerIdentification) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Career> optionalCareer;
        
        modelAndView.setViewName("career/career-form");
        optionalCareer = CareerManager.search(careerIdentification);

        if (optionalCareer.isPresent()) {
            modelAndView.addObject("careerSubmitted", optionalCareer); 
            modelAndView.addObject("allowEditing", true);
        }
                
        return modelAndView;
    }

    @PostMapping(path = "/modify")
    public ModelAndView postModifyCareerFormPage(@ModelAttribute(value = "careerSubmitted") Career career) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/career/list");
        CareerManager.modify(career);

        return modelAndView;
    }

    @GetMapping(path = "/delete/{careerIdentification}")
    public ModelAndView getDeleteCareerPage(@PathVariable(value = "careerIdentification") String careerIdentification) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/career/list");
        CareerManager.delete(careerIdentification);

        return modelAndView;
    }
}
