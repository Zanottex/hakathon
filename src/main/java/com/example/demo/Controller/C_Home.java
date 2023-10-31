package com.example.demo.Controller;


import com.example.demo.Model.M_Arduino;
import com.example.demo.Service.S_Arduino;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Home {
    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("arduino",S_Arduino.dados());
        return "Home";
    }
}
