package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
@Controller
public class MainController {

    @GetMapping(path = "/")
    public String getHomePage() {
        return "index";
    }
}
