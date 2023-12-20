package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamento;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParcelamentoService {

    public List<ParcelamentoCalculado> calcularParcelas(SolicitacaoParcelamento solicitacaoParcelamento) {
        List<ParcelamentoCalculado> listParcelamento = new ArrayList<>();
        for (int num = 1; num < solicitacaoParcelamento.maxParcelas() + 1; num++) {
            listParcelamento.add(realizaCalculoIndividual(num, solicitacaoParcelamento.valor()));
        }
        return listParcelamento;
    }

    private ParcelamentoCalculado realizaCalculoIndividual(Integer parcela, Double valor){
        Double valorParcelaArredondado = this.truncaValor(valor / parcela);
        if (valorParcelaArredondado * parcela != valor) {
            Double primeiraParcela = this.truncaValor(valorParcelaArredondado + (valor - (valorParcelaArredondado * parcela)));
            return new ParcelamentoCalculado(valor, primeiraParcela, valorParcelaArredondado, parcela);
        }
        return new ParcelamentoCalculado(valor, valorParcelaArredondado, valorParcelaArredondado, parcela);
    }

    private Double truncaValor(Double valor){
        return Math.round(valor * 100.0)/100.0;
    }

}
