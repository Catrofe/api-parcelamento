package com.br.installmentpaymentseasy.dto;

import jakarta.validation.constraints.NotNull;

public record SolicitacaoParcelamentoPersonalizado(
        @NotNull Double valor,
        @NotNull Integer maxParcelas,
        @NotNull String tipoSolicitacaoParcelamento,
        @NotNull Double juros,
        @NotNull Integer personalizarAposQuantidadeParcelas,
        @NotNull Boolean divisaoSimples
) {

}
