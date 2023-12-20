package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;

public class MotorCalculoParcelaJurosSimples implements MotorCalculoService{

    @Override
    public ParcelamentoCalculado realizaCalculoIndividual(double valorTotal, int quantidadeParcelas, double juros) {
        double valorTotalComJuros = this.truncaValor(valorTotal + (valorTotal * (juros / 100)));
        Double valorParcelaArredondado = this.truncaValor(valorTotalComJuros / quantidadeParcelas);
        if (valorParcelaArredondado * quantidadeParcelas != valorTotalComJuros) {
            Double primeiraParcela = this.truncaValor(valorParcelaArredondado + (valorTotalComJuros - (valorParcelaArredondado * quantidadeParcelas)));
            return new ParcelamentoCalculado(valorTotalComJuros, primeiraParcela, valorParcelaArredondado, quantidadeParcelas);
        }
        return new ParcelamentoCalculado(valorTotalComJuros, valorParcelaArredondado, valorParcelaArredondado, quantidadeParcelas);
    }

    @Override
    public Double truncaValor(Double valor) {
        return Math.round(valor * 100.0)/100.0;
    }
}
