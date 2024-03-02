package com.ademkose.casesolving.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice(basePackages = "com.ademkose.casesolving.exception")
public class ExceptionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
        logger.error("[BadRequestException] Exception: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}