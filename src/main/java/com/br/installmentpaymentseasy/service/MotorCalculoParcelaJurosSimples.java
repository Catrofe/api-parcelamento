package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;

public class MotorCalculoParcelaJurosSimples extends MotorCalculoFactory{

    public ParcelamentoCalculado realizaCalculoIndividual(double valorTotal, int quantidadeParcelas, double juros) {
        double valorTotalComJuros = this.truncaValor(valorTotal + (valorTotal * (juros / 100)));
        Double valorParcelaArredondado = this.truncaValor(valorTotalComJuros / quantidadeParcelas);
       return verificaCorrecaoPrimeiraParcela(valorTotalComJuros, valorParcelaArredondado, quantidadeParcelas);
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
            double valorTotalComJuros = this.truncaValor(valorTotal + (valorTotal * (juros / 100)));
            Double valorParcelaArredondado = this.truncaValor(valorTotalComJuros / quantidadeParcelas);
            return new ParcelamentoCalculado(valorTotalComJuros, valorParcelaArredondado, valorParcelaArredondado, quantidadeParcelas);
        }
        return realizaCalculoIndividual(valorTotal, quantidadeParcelas, juros);
    }
}
