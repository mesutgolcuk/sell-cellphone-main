package com.mesutgolcuk.sellcellphone.config;

import com.mesutgolcuk.sellcellphone.exception.NoContentFoundException;
import com.mesutgolcuk.sellcellphone.model.ErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Set;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static Logger LOGGER = LogManager.getLogger(CustomGlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        LOGGER.error("Req: " + request.getContextPath() + " failed. Exception: " + ex.getMessage());

        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setErrorMessage(ex.getMessage());
        error.setErrorCode(-999);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ErrorResponse> handleConstraintExceptions(ConstraintViolationException ex, WebRequest request) {
        LOGGER.error("Bad Request: " + ex.getMessage());

        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            message.append(violation.getMessage().concat(";"));
        }
        error.setErrorMessage(message.toString());
        error.setErrorCode(-999);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoContentFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoContentFoundExceptions(Exception ex, WebRequest request) {
        LOGGER.error("No Content Exception");

        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setErrorMessage("There is no data");
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        // It is possible to update it with HttpStatus.NO_CONTENT
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
