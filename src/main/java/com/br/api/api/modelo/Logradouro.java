package com.br.api.api.modelo;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Logradouro {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
}
