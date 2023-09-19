package com.br.var.solutions.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InformacoesImc {

    private String imc;
    private String classificacao;
}