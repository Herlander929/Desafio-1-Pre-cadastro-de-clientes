package Desafio1.Precadastro.de.clientes.resources.exceptions;

import Desafio1.Precadastro.de.clientes.services.servicesExceptions.DataIntegrityException;
import Desafio1.Precadastro.de.clientes.services.servicesExceptions.ObjectNotFoundExceptions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourcesExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExceptions.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExceptions e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
