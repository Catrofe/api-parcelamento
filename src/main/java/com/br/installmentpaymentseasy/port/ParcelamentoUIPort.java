package com.br.installmentpaymentseasy.port;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ParcelamentoUIPort {
    @PostMapping("")
    ResponseEntity<List<ParcelamentoCalculado>> calcularParcelas(SolicitacaoParcelamento solicitacaoParcelamento);
}
