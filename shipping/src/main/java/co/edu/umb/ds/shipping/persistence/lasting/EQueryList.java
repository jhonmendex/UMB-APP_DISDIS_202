package co.edu.umb.ds.shipping.persistence.lasting;

import com.spiwer.rosilla.template.SQLName;

/**
 *
 * @author Manuel Ernesto Bonilla Muñoz - mebonilla9@gmail.com
 */
public enum EQueryList implements SQLName
{
  ;

  private final String name;

  private EQueryList(String name)
  {
    this.name = name;
  }

  @Override
  public String getName()
  {
    return name;
  }

}
