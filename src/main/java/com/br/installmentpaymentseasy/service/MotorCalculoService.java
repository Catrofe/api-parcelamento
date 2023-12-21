package com.br.installmentpaymentseasy.service;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;

public interface MotorCalculoService {

    ParcelamentoCalculado realizaCalculoIndividual(double valorTotal, int quantidadeParcelas, double juros);

    Double truncaValor(Double valor);


}