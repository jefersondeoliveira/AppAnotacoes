package com.example.jeferson.anotacoes.data;

import java.util.Date;

/**
 * Created by jeferson on 14/09/16.
 */
public class Anotacao {

    private String descricao;
    private Date data;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
