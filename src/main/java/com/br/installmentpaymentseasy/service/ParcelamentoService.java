package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamento;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamentoPersonalizado;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ParcelamentoService {
    public List<ParcelamentoCalculado> calcularParcelas(SolicitacaoParcelamento solicitacaoParcelamento) throws BadRequestException;

    public List<ParcelamentoCalculado> calcularParcelasPersonalizado(SolicitacaoParcelamentoPersonalizado solicitacaoParcelamento) throws BadRequestException;
}
