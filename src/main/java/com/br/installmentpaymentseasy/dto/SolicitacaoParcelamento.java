package com.br.installmentpaymentseasy.dto;


import jakarta.validation.constraints.NotNull;


public record SolicitacaoParcelamento(
        @NotNull Double valor,
        @NotNull Integer maxParcelas,
        @NotNull String tipoSolicitacaoParcelamento,
        @NotNull Double juros

) {

}
