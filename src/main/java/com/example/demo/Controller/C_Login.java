package com.example.demo.Controller;

import com.example.demo.Model.M_Usuario;
import com.example.demo.Service.S_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Login {
    @GetMapping("/login")
    public String getLogin(){
        return "Login/Login";
    }

    @PostMapping("/login")
    public M_Usuario setLogin(@RequestParam("usuario") String usuario,
                              @RequestParam("senha") String senha){
        return S_Usuario.login(usuario, senha);
    }
}
