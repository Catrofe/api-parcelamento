package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamento;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParcelamentoServiceTest {

    @Test
    public void testCalcularParcelas() throws BadRequestException {
        SolicitacaoParcelamento solicitacaoParcelamento = new SolicitacaoParcelamento(150.41, 12, "SEM_JUROS", 0.00);
        ParcelamentoService parcelamentoService = new ParcelamentoService();
        List<ParcelamentoCalculado> parcelamento =  parcelamentoService.calcularParcelas(solicitacaoParcelamento);

        Assertions.assertEquals(12, parcelamento.size());
        Assertions.assertEquals(12.58, parcelamento.get(11).valorPrimeiraParcela());
        Assertions.assertEquals(12.53, parcelamento.get(11).valorDemaisParcela());
        Assertions.assertEquals(150.41, parcelamento.get(11).valorTotal());
        Assertions.assertEquals(12, parcelamento.get(11).quantidadeParcelas());
    }

    @Test
    public void testCalculaParcelasComJurosSimples() throws BadRequestException {
        SolicitacaoParcelamento solicitacaoParcelamento = new SolicitacaoParcelamento(150.00, 12, "COM_JUROS_SIMPLES", 27.67);
        ParcelamentoService parcelamentoService = new ParcelamentoService();
        List<ParcelamentoCalculado> parcelamento =  parcelamentoService.calcularParcelas(solicitacaoParcelamento);

        Assertions.assertEquals(12, parcelamento.size());
        Assertions.assertEquals(15.95, parcelamento.get(11).valorPrimeiraParcela());
        Assertions.assertEquals(15.96, parcelamento.get(11).valorDemaisParcela());
        Assertions.assertEquals(191.51, parcelamento.get(11).valorTotal());
        Assertions.assertEquals(12, parcelamento.get(11).quantidadeParcelas());
    }

    @Test
    public void testCalculaParcelasComJurosSimplesNegativo() throws BadRequestException {
        SolicitacaoParcelamento solicitacaoParcelamento = new SolicitacaoParcelamento(150.00, 12, "COM_JUROS_SIMPLES", -27.67);
        ParcelamentoService parcelamentoService = new ParcelamentoService();
        List<ParcelamentoCalculado> parcelamento =  parcelamentoService.calcularParcelas(solicitacaoParcelamento);

        Assertions.assertEquals(12, parcelamento.size());
        Assertions.assertEquals(9.06, parcelamento.get(11).valorPrimeiraParcela());
        Assertions.assertEquals(9.04, parcelamento.get(11).valorDemaisParcela());
        Assertions.assertEquals(108.5, parcelamento.get(11).valorTotal());
        Assertions.assertEquals(12, parcelamento.get(11).quantidadeParcelas());
    }

    @Test
    public void testErroAoConsultarTipoSolicitacaoParcelamento() {
        SolicitacaoParcelamento solicitacaoParcelamento = new SolicitacaoParcelamento(150.00, 12, "s", 27.67);
        ParcelamentoService parcelamentoService = new ParcelamentoService();
        Assertions.assertThrows(BadRequestException.class, () -> parcelamentoService.calcularParcelas(solicitacaoParcelamento));
    }

    @Test
    public void testCalculaParcelasComJurosComposto() throws BadRequestException {
        SolicitacaoParcelamento solicitacaoParcelamento = new SolicitacaoParcelamento(150.00, 12, "COM_JUROS_COMPOSTO", 2.35);
        ParcelamentoService parcelamentoService = new ParcelamentoService();
        List<ParcelamentoCalculado> parcelamento =  parcelamentoService.calcularParcelas(solicitacaoParcelamento);

        Assertions.assertEquals(12, parcelamento.size());
        Assertions.assertEquals(16.5, parcelamento.get(11).valorPrimeiraParcela());
        Assertions.assertEquals(16.52, parcelamento.get(11).valorDemaisParcela());
        Assertions.assertEquals(198.22, parcelamento.get(11).valorTotal());
        Assertions.assertEquals(12, parcelamento.get(11).quantidadeParcelas());
    }
}
