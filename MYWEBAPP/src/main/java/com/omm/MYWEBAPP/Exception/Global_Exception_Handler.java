package com.omm.MYWEBAPP.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.IllformedLocaleException;
import java.util.Map;

@ControllerAdvice
public class Global_Exception_Handler {
    @ExceptionHandler(Product_not_found.class)
    public ResponseEntity<Error_Exceptio> product_not_found(Product_not_found ex){
        Error_Exceptio error_Exceptio = Error_Exceptio.builder()
                .message(ex.getMessage())
                .details("Product not found")
                .timestamp(LocalDateTime.now().toString())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(error_Exceptio,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalAccessError.class)
    public ResponseEntity<Error_Exceptio> illegalArgument_Exception(IllegalArgumentException ex){
        Error_Exceptio error_Exceptio = Error_Exceptio.builder()
                .message(ex.getMessage())
                .details("User not found")
                .timestamp(LocalDateTime.now().toString())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(error_Exceptio,HttpStatus.BAD_REQUEST);
    }


  //  @ExceptionHandler(Exception.class)
    //public ResponseEntity<Error_Exceptio> handleGeneralException(Exception ex){
//Error_Exceptio error_Exceptio = Error_Exceptio.builder()
              //  .message(ex.getMessage())

              //  .details("Something went wrong!!!")
             //   .timestamp(LocalDateTime.now().toString())
              //  .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            //    .build();
        //return new ResponseEntity<>(error_Exceptio,HttpStatus.INTERNAL_SERVER_ERROR);
    //}





}
