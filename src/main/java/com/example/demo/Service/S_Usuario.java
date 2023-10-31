package com.example.demo.Service;

import com.example.demo.Model.M_Maquina;
import com.example.demo.Model.M_Usuario;
import com.example.demo.Repository.R_Maquina;
import com.example.demo.Repository.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Usuario {
    private static R_Usuario r_usuario;

    private static R_Maquina r_maquina;
    public static M_Usuario login(String usuario, String senha){
        if(S_Generico.textoEstaVazio(usuario)){
            return null;
        }
        if(S_Generico.textoEstaVazio(senha)){
            return null;
        }
       return r_usuario.BuscarPorNomeSenha(usuario, senha);
    }

    public static String cadastroMaquina(String nome, String modelo, String numeroserie, String setor){
        boolean podeCadastrar = true;
        String mensagem = "";

        if(S_Generico.textoEstaVazio(nome)){
            podeCadastrar = false;
            mensagem += "Infome o nome da maquina!";
        }
        if(S_Generico.textoEstaVazio(modelo)){
            podeCadastrar = false;
            mensagem += "Infome o modelo da maquina!";
        }
        if(S_Generico.textoEstaVazio(numeroserie)){
            podeCadastrar = false;
            mensagem += "Informe um numero de serie!";
        }
        if(S_Generico.textoEstaVazio(setor)){
            podeCadastrar = false;
            mensagem += "Informe o setor em que essa maquina irá atuar ou está atuando!";
        }
        if(podeCadastrar){
            M_Maquina m_maquina = new M_Maquina();
            m_maquina.setNome(nome);
            m_maquina.setModelo(modelo);
            m_maquina.setNumeroserie(numeroserie);
            m_maquina.setSetor(setor);
            try{
                r_maquina.save(m_maquina);
                mensagem += "Cadastro efetuado com sucesso!!";
            }catch (DataIntegrityViolationException e) {
                mensagem += "Erro ao Cadastrar";
            }
        }
        return mensagem;
    }
}
