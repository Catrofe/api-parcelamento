package com.br.installmentpaymentseasy.domain;

import com.br.installmentpaymentseasy.service.MotorCalculoParcelaJurosSimples;
import com.br.installmentpaymentseasy.service.MotorCalculoParcelaSimples;
import com.br.installmentpaymentseasy.service.MotorCalculoService;

import java.util.Optional;

public enum TipoSolicitacaoParcelamento {
    PARCELAMENTO_SEM_JUROS("SEM_JUROS"),
    PARCELAMENTO_COM_JUROS_SIMPLES("COM_JUROS_SIMPLES");

    private final String tipoSolicitacaoParcelamento;

    TipoSolicitacaoParcelamento(String tipoSolicitacaoParcelamento) {
        this.tipoSolicitacaoParcelamento = tipoSolicitacaoParcelamento;
    }

    public static TipoSolicitacaoParcelamento getTipoSolicitacaoParcelamento(String tipoSolicitacaoParcelamento) {
        Optional<TipoSolicitacaoParcelamento> tipoSolicitacaoParcelamentoOptional = Optional.ofNullable(null);
        for (TipoSolicitacaoParcelamento tipoSolicitacaoParcelamentoEnum : TipoSolicitacaoParcelamento.values()) {
            if (tipoSolicitacaoParcelamentoEnum.tipoSolicitacaoParcelamento.equals(tipoSolicitacaoParcelamento)) {
                tipoSolicitacaoParcelamentoOptional = Optional.of(tipoSolicitacaoParcelamentoEnum);
            }
        }
        return tipoSolicitacaoParcelamentoOptional.orElseThrow(() -> new IllegalArgumentException("Tipo de solicitação de parcelamento não encontrado"));
    }

}
