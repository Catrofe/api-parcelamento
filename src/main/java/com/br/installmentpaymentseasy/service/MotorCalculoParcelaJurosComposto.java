package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;


public class MotorCalculoParcelaJurosComposto extends MotorCalculoFactory{


    public ParcelamentoCalculado realizaCalculoIndividual(double valorTotal, int quantidadeParcelas, double juros) {
        double valorTotalComJuros = this.calculaJurosComposto(valorTotal, quantidadeParcelas, juros);
        Double valorParcelaArredondado = this.truncaValor(valorTotalComJuros / quantidadeParcelas);
        return verificaCorrecaoPrimeiraParcela(valorTotalComJuros, valorParcelaArredondado, quantidadeParcelas);
    }

    private double calculaJurosComposto(double valorTotal, int quantidadeParcelas, double juros) {
        return this.truncaValor(valorTotal * Math.pow((1 + (juros / 100)), quantidadeParcelas));
    }

    public ParcelamentoCalculado realizaCalculoIndividualPersonalizado(double valorTotal, int quantidadeParcelas, double juros, int personalizarAposQuantidadeParcelas, Boolean divisaoSimples) {
        if (quantidadeParcelas < personalizarAposQuantidadeParcelas && !divisaoSimples) {
            Double valorParcelaArredondado = this.truncaValor(valorTotal / quantidadeParcelas);
            return verificaCorrecaoPrimeiraParcela(valorTotal, valorParcelaArredondado, quantidadeParcelas);
        }
        else if (quantidadeParcelas < personalizarAposQuantidadeParcelas) {
            Double valorParcelaArredondado = this.truncaValor(valorTotal / quantidadeParcelas);
            return new ParcelamentoCalculado(valorTotal, valorParcelaArredondado, valorParcelaArredondado, quantidadeParcelas);
        }
        else if (divisaoSimples) {
            double valorTotalComJuros = this.calculaJurosComposto(valorTotal, quantidadeParcelas, juros);
            Double valorParcelaArredondado = this.truncaValor(valorTotalComJuros / quantidadeParcelas);
            return new ParcelamentoCalculado(valorTotalComJuros, valorParcelaArredondado, valorParcelaArredondado, quantidadeParcelas);
        }
        return realizaCalculoIndividual(valorTotal, quantidadeParcelas, juros);
    }
}
