
package co.edu.umb.ds.shipping.application.lasting;

import com.spiwer.standard.template.IGenericMessage;

/**
 * @author Manuel Ernesto Bonilla Muñoz - mebonilla9@gmail.com
 */
public enum EMessage implements IGenericMessage {

  NO_RESULTS(0, "No se encontraron registros en el sistema"),;

  private final int code;
  private final String message;

  EMessage(int code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public Integer getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }

}
