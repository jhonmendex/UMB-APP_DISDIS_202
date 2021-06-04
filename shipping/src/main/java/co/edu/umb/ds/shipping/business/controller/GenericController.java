package co.edu.umb.ds.shipping.business.controller;

import com.spiwer.rosilla.exception.JdbcException;
import com.spiwer.standard.dto.Answer;
import com.spiwer.standard.exception.AppException;
import com.spiwer.standard.exception.EnvironmentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Manuel Ernesto Bonilla Muñoz - mebonilla9@gmail.com
 */
public class GenericController {

  @ExceptionHandler({
    JdbcException.class,
    AppException.class,
    EnvironmentException.class
  })

  /**
   * Return a default Http status code for the custom exception into the application
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Answer> controlarError(AppException e) {
    return new ResponseEntity<>(
      new Answer().setCode(e.getCode()).setMessage(e.getMessage()),
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }

}
