package com.br.installmentpaymentseasy.domain;

import org.apache.coyote.BadRequestException;

import java.util.Optional;

public enum TipoSolicitacaoParcelamento {
    PARCELAMENTO_SEM_JUROS("SEM_JUROS"),
    PARCELAMENTO_COM_JUROS_SIMPLES("COM_JUROS_SIMPLES"),
    PARCELAMENTO_COM_JUROS_COMPOSTO("COM_JUROS_COMPOSTO");

    private final String tipoSolicitacaoParcelamento;

    TipoSolicitacaoParcelamento(String tipoSolicitacaoParcelamento) {
        this.tipoSolicitacaoParcelamento = tipoSolicitacaoParcelamento;
    }

    public static TipoSolicitacaoParcelamento getTipoSolicitacaoParcelamento(String tipoSolicitacaoParcelamento) throws BadRequestException {
        Optional<TipoSolicitacaoParcelamento> tipoSolicitacaoParcelamentoOptional = Optional.ofNullable(null);
        for (TipoSolicitacaoParcelamento tipoSolicitacaoParcelamentoEnum : TipoSolicitacaoParcelamento.values()) {
            if (tipoSolicitacaoParcelamentoEnum.tipoSolicitacaoParcelamento.equals(tipoSolicitacaoParcelamento)) {
                tipoSolicitacaoParcelamentoOptional = Optional.of(tipoSolicitacaoParcelamentoEnum);
            }
        }
        return tipoSolicitacaoParcelamentoOptional.orElseThrow(() -> new BadRequestException("Tipo de solicitação de parcelamento não encontrado"));
    }

}
