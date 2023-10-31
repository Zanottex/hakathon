package com.example.demo.Controller;

import com.example.demo.Service.S_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Cadastro {
    @GetMapping("/cadastro")
    public String getCadstro(){
        return "Maquina/Cadastro";
    }

    @PostMapping("/cadastro")
    public String setCadastroMaquina(@RequestParam("nome") String nome,
                                     @RequestParam("modelo") String modelo,
                                     @RequestParam("numeroserie") String numeroserie,
                                     @RequestParam("setor") String setor){
        return S_Usuario.cadastroMaquina(nome, modelo, numeroserie, setor);
    }
}
