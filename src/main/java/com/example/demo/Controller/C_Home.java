package com.example.demo.Controller;


import com.example.demo.Model.M_Arduino;
import com.example.demo.Service.S_Arduino;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Home {
    @GetMapping("/")
    public String getHome(){
        return "Home";
    }

    @GetMapping("/otocaminho")
    @ResponseBody
    public M_Arduino getDados(){
        return S_Arduino.dados();
    }
}
