package com.br.var.solutions.application.services.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InformacoesImc {

    private double imc;
    private String classificacao;
}