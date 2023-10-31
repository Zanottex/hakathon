package com.example.demo.Service;

import com.example.demo.Model.M_Arduino;
import com.example.demo.Repository.R_Arduino;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Arduino {
    private static R_Arduino r_arduino;

    public S_Arduino(R_Arduino r_arduino){
        this.r_arduino = r_arduino;
    }

    public static String infoArduino(String temperatura, String pressao, String oleo){
        boolean podeSalvar = true;
        String mensagem = "";
        if (S_Generico.textoEstaVazio(temperatura)) {
            podeSalvar = false;
        }
        if (S_Generico.textoEstaVazio(pressao)) {
            podeSalvar = false;
        }
        if (S_Generico.textoEstaVazio(oleo)) {
            podeSalvar = false;
        }
        if (podeSalvar) {
            M_Arduino m_arduino = new M_Arduino();
            m_arduino.setTemperatura((int) Long.parseLong(temperatura));
            m_arduino.setPressao(Long.parseLong(pressao));
            m_arduino.setOleo(Long.parseLong(oleo));
            try {
                r_arduino.save(m_arduino);
                mensagem += "Deu bom";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Deu n";
            }
        }
        return mensagem;
    }
    public static M_Arduino dados(){
        return r_arduino.findLastReg();
    }
}
