package com.example.Prova_Progetto_Personal_Trainer.exception;





import com.example.Prova_Progetto_Personal_Trainer.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomizeExceptionHendler {

    @ExceptionHandler(NotFoundException.class)

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError notFoundExceptionHandler(NotFoundException e){

        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return error;

    }

    @ExceptionHandler(ValidationException.class)

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError ValidationExceptionHandler(ValidationException e){

        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return error;

    }

    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiError unAuthorizedExceptionHandler(UnAuthorizedException e) {
        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return error;
    }
}
