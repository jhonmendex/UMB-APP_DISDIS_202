
package co.edu.umb.ds.rosilla.application.lasting;

import com.spiwer.standard.template.IGenericMessage;
import com.spiwer.standard.exception.AppException;


/**
 *
 * @author Manuel Ernesto Bonilla Muñoz - mebonilla9@gmail.com
 */
public enum EMessage implements IGenericMessage {

  ERROR_TOKEN_REQUIRED(-1000, "Error token is required");;

  private final int code;
  private final String message;

  private EMessage(int code, String message)
  {
    this.code = code;
    this.message = message;
  }

  @Override
  public Integer getCode()
  {
    return code;
  }

  @Override
  public String getMessage()
  {
    return message;
  }


}
