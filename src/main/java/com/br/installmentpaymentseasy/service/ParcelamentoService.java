package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.domain.TipoSolicitacaoParcelamento;
import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParcelamentoService {

    public List<ParcelamentoCalculado> calcularParcelas(SolicitacaoParcelamento solicitacaoParcelamento) {
        var motorCalculo = TipoSolicitacaoParcelamento.getMotorCalculo(solicitacaoParcelamento.tipoSolicitacaoParcelamento());
        if (motorCalculo == null) {
            throw new IllegalArgumentException("Tipo de solicitação de parcelamento inválida");
        }
        List<ParcelamentoCalculado> listParcelamento = new ArrayList<>();
        for (int num = 1; num < solicitacaoParcelamento.maxParcelas() + 1; num++) {
            listParcelamento.add(motorCalculo.realizaCalculoIndividual(solicitacaoParcelamento.valor(), num, solicitacaoParcelamento.juros()));
        }
        return listParcelamento;
    }
}
