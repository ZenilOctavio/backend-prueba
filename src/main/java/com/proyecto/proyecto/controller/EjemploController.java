
package com.proyecto.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/isi")
public class EjemploController {
    
    @GetMapping
    public String index(){
        return "index";
    }
    
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    
}
