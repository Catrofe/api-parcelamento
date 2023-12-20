package com.br.installmentpaymentseasy.domain;

import com.br.installmentpaymentseasy.service.MotorCalculoParcelaSimples;

public enum TipoSolicitacaoParcelamento {
    PARCELAMENTO_SEM_JUROS("SEM_JUROS"),
    PARCELAMENTO_COM_JUROS("COM_JUROS");

    private final String tipoSolicitacaoParcelamento;

    TipoSolicitacaoParcelamento(String tipoSolicitacaoParcelamento) {
        this.tipoSolicitacaoParcelamento = tipoSolicitacaoParcelamento;
    }

    public static MotorCalculoParcelaSimples getMotorCalculo(String tipoCalculo) {
        if (tipoCalculo.equals("SEM_JUROS")) {
            return new MotorCalculoParcelaSimples();
        }
        return null;
    }

}
