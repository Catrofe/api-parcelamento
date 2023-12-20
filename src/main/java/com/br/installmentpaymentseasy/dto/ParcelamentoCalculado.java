package com.br.installmentpaymentseasy.dto;

public record ParcelamentoCalculado(
        Double valorTotal,
        Double valorPrimeiraParcela,
        Double valorDemaisParcela,
        Integer quantidadeParcelas
) {
}
