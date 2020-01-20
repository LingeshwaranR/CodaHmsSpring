package global.coda.hms.exception.handler;

import global.coda.hms.exception.SystemException;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SystemExceptionHandler {
    @ExceptionHandler({SystemException.class})
    public ResponseEntity<?> handler(){
        return new ResponseEntity<String>("Something went Wrong", HttpStatus.BAD_REQUEST);
    }

}
