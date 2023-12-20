package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;

public class MotorCalculoParcelaSimples implements MotorCalculoService{
    @Override
    public ParcelamentoCalculado realizaCalculoIndividual(double valorTotal, int quantidadeParcelas, double juros) {
        Double valorParcelaArredondado = this.truncaValor(valorTotal / quantidadeParcelas);
        if (valorParcelaArredondado * quantidadeParcelas != valorTotal) {
            Double primeiraParcela = this.truncaValor(valorParcelaArredondado + (valorTotal - (valorParcelaArredondado * quantidadeParcelas)));
            return new ParcelamentoCalculado(valorTotal, primeiraParcela, valorParcelaArredondado, quantidadeParcelas);
        }
        return new ParcelamentoCalculado(valorTotal, valorParcelaArredondado, valorParcelaArredondado, quantidadeParcelas);
    }

    @Override
    public Double truncaValor(Double valor) {
        return Math.round(valor * 100.0)/100.0;
    }
}
