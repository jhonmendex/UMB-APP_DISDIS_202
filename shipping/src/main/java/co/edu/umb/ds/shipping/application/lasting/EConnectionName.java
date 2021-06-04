package co.edu.umb.ds.shipping.application.lasting;

import com.spiwer.standard.template.IConnectionName;

/**
 *
 * @author Manuel Ernesto Bonilla Muñoz - mebonilla9@gmail.com
 */
public enum EConnectionName implements IConnectionName
{
  DEFAULT("default");

  private final String name;

  private EConnectionName(String name)
  {
    this.name = name;
  }

  @Override
  public String getName()
  {
    return name;
  }

}
