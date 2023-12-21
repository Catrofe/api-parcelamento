package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;


public class MotorCalculoParcelaJurosComposto implements MotorCalculoService{


    @Override
    public ParcelamentoCalculado realizaCalculoIndividual(double valorTotal, int quantidadeParcelas, double juros) {
        double valorTotalComJuros = this.calculaJurosComposto(valorTotal, quantidadeParcelas, juros);
        Double valorParcelaArredondado = this.truncaValor(valorTotalComJuros / quantidadeParcelas);
        if (valorParcelaArredondado * quantidadeParcelas != valorTotalComJuros) {
            Double primeiraParcela = this.truncaValor(valorParcelaArredondado + (valorTotalComJuros - (valorParcelaArredondado * quantidadeParcelas)));
            return new ParcelamentoCalculado(valorTotalComJuros, primeiraParcela, valorParcelaArredondado, quantidadeParcelas);
        }
        return new ParcelamentoCalculado(valorTotalComJuros, valorParcelaArredondado, valorParcelaArredondado, quantidadeParcelas);
    }

    private double calculaJurosComposto(double valorTotal, int quantidadeParcelas, double juros) {
        return this.truncaValor(valorTotal * Math.pow((1 + (juros / 100)), quantidadeParcelas));
    }

    @Override
    public Double truncaValor(Double valor) {
        return Math.round(valor * 100.0)/100.0;
    }
}
