package hub.forum.api.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity tratarErro(RuntimeException ex) {

        return ResponseEntity.badRequest()
                .body(ex.getMessage());
    }
}
