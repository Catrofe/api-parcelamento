package com.br.installmentpaymentseasy.port;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamento;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamentoPersonalizado;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface ParcelamentoUIPort {
    @PostMapping("")
    ResponseEntity<List<ParcelamentoCalculado>> calcularParcelas(SolicitacaoParcelamento solicitacaoParcelamento) throws BadRequestException;

    @PostMapping("/personalizado")
    ResponseEntity<List<ParcelamentoCalculado>> calcularParcelasPersonalizadas(SolicitacaoParcelamentoPersonalizado solicitacaoParcelamento) throws BadRequestException;
}
