package ru.roman.test_task_project.handler;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.roman.test_task_project.exceptions.AnimalNotFoundException;
import ru.roman.test_task_project.response.Response;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        Map<String, Object> objectBody = new LinkedHashMap<>();
        objectBody.put("Current Timestamp", new Date());
        objectBody.put("Status", status.value());

        List<String> exceptionErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .toList();

        objectBody.put("Errors", exceptionErrors);

        return new ResponseEntity<>(objectBody, status);
    }


    @ExceptionHandler(AnimalNotFoundException.class)
    public ResponseEntity<Response> handleException(AnimalNotFoundException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
