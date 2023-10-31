package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "dados")
public class M_Arduino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double temperatura;
    private double oleo;
    private double pressao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getQuantidade() {
        return oleo;
    }

    public void setQuantidade(double oleo) {
        this.oleo = oleo;
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }
}
