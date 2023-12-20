package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParcelamentoServiceTest {

    @Test
    public void testCalcularParcelas() {
        SolicitacaoParcelamento solicitacaoParcelamento = new SolicitacaoParcelamento(150.41, 12);
        ParcelamentoService parcelamentoService = new ParcelamentoService();
        List<ParcelamentoCalculado> parcelamento =  parcelamentoService.calcularParcelas(solicitacaoParcelamento);

        Assertions.assertEquals(12, parcelamento.size());
        Assertions.assertEquals(12.58, parcelamento.get(11).valorPrimeiraParcela());
        Assertions.assertEquals(12.53, parcelamento.get(11).valorDemaisParcela());
        Assertions.assertEquals(150.41, parcelamento.get(11).valorTotal());
        Assertions.assertEquals(12, parcelamento.get(11).quantidadeParcelas());
    }

}
