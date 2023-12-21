package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamento;

import java.util.List;

public interface MotorCalculoService {

    ParcelamentoCalculado realizaCalculoIndividual(double valorTotal, int quantidadeParcelas, double juros);

    Double truncaValor(Double valor);
}