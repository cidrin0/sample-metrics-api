package br.com.grafana.sma.api.handler;

import br.com.grafana.sma.core.business.exception.ProductNotFoundException;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class HandleException {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<@NonNull ApiErrorResponse> notFound(Exception cause) {
        return ResponseEntity.status(NOT_FOUND)
                .body(new ApiErrorResponse(cause.getMessage()));
    }
}
