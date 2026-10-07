package curso_spring_boot.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import curso_spring_boot.exceptions.ExceptionResponse;
import curso_spring_boot.exceptions.UnsupportedMathOperationException;

@ControllerAdvice 
@RestController 
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler{
    
    //Tratamento de exceções genericas
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){


        ExceptionResponse response = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Trata exceções Bad request
    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(UnsupportedMathOperationException ex, WebRequest request){


        ExceptionResponse response = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
