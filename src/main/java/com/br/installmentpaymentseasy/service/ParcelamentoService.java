package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.domain.TipoSolicitacaoParcelamento;
import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamento;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParcelamentoService {

    public List<ParcelamentoCalculado> calcularParcelas(SolicitacaoParcelamento solicitacaoParcelamento) throws BadRequestException {
        TipoSolicitacaoParcelamento tipoSolicitacaoParcelamento = TipoSolicitacaoParcelamento.getTipoSolicitacaoParcelamento(solicitacaoParcelamento.tipoSolicitacaoParcelamento());
        var motorCalculo = switch (tipoSolicitacaoParcelamento) {
            case PARCELAMENTO_SEM_JUROS -> new MotorCalculoParcelaSimples();
            case PARCELAMENTO_COM_JUROS_SIMPLES -> new MotorCalculoParcelaJurosSimples();
        };
        List<ParcelamentoCalculado> listParcelamento = new ArrayList<>();
        for (int num = 1; num < solicitacaoParcelamento.maxParcelas() + 1; num++) {
            listParcelamento.add(motorCalculo.realizaCalculoIndividual(solicitacaoParcelamento.valor(), num, solicitacaoParcelamento.juros()));
        }
        return listParcelamento;
    }
}
