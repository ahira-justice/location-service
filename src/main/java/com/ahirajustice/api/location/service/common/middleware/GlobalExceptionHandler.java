package com.ahirajustice.api.location.service.common.middleware;

import com.ahirajustice.api.location.service.common.error.Error;
import com.ahirajustice.api.location.service.common.error.ErrorResponse;
import com.ahirajustice.api.location.service.common.exceptions.ApplicationException;
import com.ahirajustice.api.location.service.common.exceptions.BadRequestException;
import com.ahirajustice.api.location.service.common.exceptions.NotFoundException;
import com.ahirajustice.api.location.service.common.exceptions.ServerErrorException;
import com.ahirajustice.api.location.service.common.exceptions.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleException(Exception ex) {
        log.error(ex.getMessage(), ex);

        if (ex instanceof ApplicationException)
            return handleApplicationException((ApplicationException) ex);
        else if (ex instanceof NoHandlerFoundException)
            return handleNoHandlerFoundException((NoHandlerFoundException) ex);
        else if (ex instanceof BindException)
            return handleBindException((BindException) ex);
        else if (ex instanceof HttpMessageNotReadableException)
            return handleHttpMessageNotReadableException((HttpMessageNotReadableException) ex);
        else
            return handleUnknownException();
    }

    private ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException ex) {
        return new ResponseEntity<>(ex.toErrorResponse(), HttpStatus.valueOf(ex.getStatusCode()));
    }

    private ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        return handleApplicationException(new NotFoundException(String.format("Route %s %s does not exist", ex.getHttpMethod(), ex.getRequestURL())));
    }

    private ResponseEntity<ErrorResponse> handleBindException(BindException ex) {
        List<Error> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> Error.create(error.getField(), error.getDefaultMessage(), error.getRejectedValue()))
                .collect(Collectors.toList());

        return handleApplicationException(new ValidationException(errors));
    }

    private ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return handleApplicationException(new BadRequestException(ex.getMessage()));
    }

    private ResponseEntity<ErrorResponse> handleUnknownException() {
        return handleApplicationException(new ServerErrorException());
    }

}
