package uk.edwinek.dnsupdateserver.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler({MissingServletRequestParameterException.class, NoHandlerFoundException.class})
    public ResponseEntity<String> handleConflict() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request.");
    }

}
