package com.br.installmentpaymentseasy.adapter;

import com.br.installmentpaymentseasy.dto.ParcelamentoCalculado;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamento;
import com.br.installmentpaymentseasy.dto.SolicitacaoParcelamentoPersonalizado;
import com.br.installmentpaymentseasy.port.ParcelamentoUIPort;
import com.br.installmentpaymentseasy.service.ParcelamentoService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parcelamento")
public class ParcelamentoControllerAdapter implements ParcelamentoUIPort {

    @Autowired
    private ParcelamentoService parcelamentoService;

    @Override
    public ResponseEntity<List<ParcelamentoCalculado>> calcularParcelas(@RequestBody @Valid SolicitacaoParcelamento solicitacaoParcelamento) throws BadRequestException {
        List<ParcelamentoCalculado> parcelamento =  parcelamentoService.calcularParcelas(solicitacaoParcelamento);
        return new ResponseEntity<>(parcelamento, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ParcelamentoCalculado>> calcularParcelasPersonalizadas(@RequestBody @Valid SolicitacaoParcelamentoPersonalizado solicitacaoParcelamento) throws BadRequestException {
        List<ParcelamentoCalculado> parcelamento =  parcelamentoService.calcularParcelasPersonalizado(solicitacaoParcelamento);
        return new ResponseEntity<>(parcelamento, HttpStatus.OK);
    }


}
