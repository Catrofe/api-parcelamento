package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;

public abstract class MotorCalculoFactory {

    public ParcelamentoCalculado verificaCorrecaoPrimeiraParcela(double valorTotal, double valorParcelaArredondado, int quantidadeParcelas) {
        if (valorParcelaArredondado * quantidadeParcelas != valorTotal) {
            Double primeiraParcela = this.truncaValor(valorParcelaArredondado + (valorTotal - (valorParcelaArredondado * quantidadeParcelas)));
            return new ParcelamentoCalculado(valorTotal, primeiraParcela, valorParcelaArredondado, quantidadeParcelas);
        }
        return new ParcelamentoCalculado(valorTotal, valorParcelaArredondado, valorParcelaArredondado, quantidadeParcelas);
    }

    public Double truncaValor(Double valor) {
        return Math.round(valor * 100.0)/100.0;
    }

    public abstract ParcelamentoCalculado realizaCalculoIndividual(double valorTotal, int quantidadeParcelas, double juros);

    public abstract ParcelamentoCalculado realizaCalculoIndividualPersonalizado(double valorTotal, int quantidadeParcelas, double juros, int personalizarAposQuantidadeParcelas, Boolean divisaoSimples);
}
