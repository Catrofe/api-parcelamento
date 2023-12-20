package com.br.installmentpaymentseasy.util;

public record ExceptionDetails(
        String timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
