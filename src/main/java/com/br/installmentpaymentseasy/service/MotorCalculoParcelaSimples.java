package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;

public class MotorCalculoParcelaSimples extends MotorCalculoFactory{

    public ParcelamentoCalculado realizaCalculoIndividual(double valorTotal, int quantidadeParcelas, double juros) {
        Double valorParcelaArredondado = this.truncaValor(valorTotal / quantidadeParcelas);
        return verificaCorrecaoPrimeiraParcela(valorTotal, valorParcelaArredondado, quantidadeParcelas);
    }

    public ParcelamentoCalculado realizaCalculoIndividualPersonalizado(double valorTotal, int quantidadeParcelas, double juros, int personalizarAposQuantidadeParcelas, Boolean divisaoSimples) {
        if (!divisaoSimples) {
            return this.realizaCalculoIndividual(valorTotal, quantidadeParcelas, juros);
        }
        Double valorParcelaArredondado = this.truncaValor(valorTotal / quantidadeParcelas);
        return new ParcelamentoCalculado(valorTotal, valorParcelaArredondado, valorParcelaArredondado, quantidadeParcelas);
    }
}
