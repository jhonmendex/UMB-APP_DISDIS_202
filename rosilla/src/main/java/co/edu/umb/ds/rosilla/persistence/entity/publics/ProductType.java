
package co.edu.umb.ds.rosilla.persistence.entity.publics;

import co.edu.umb.ds.rosilla.persistence.lasting.EQueryList;
import com.spiwer.rosilla.database.DatabaseManager;
import com.spiwer.rosilla.dto.Param;
import com.spiwer.rosilla.exception.JdbcException;
import com.spiwer.rosilla.lasting.EMessageRosilla;
import com.spiwer.rosilla.template.EntityManager;
import com.spiwer.rosilla.util.Retrieve;
import com.spiwer.standard.column.PrimaryKey;
import com.spiwer.standard.exception.AppException;
import com.spiwer.standard.lasting.ETypePrimaryKey;
import com.spiwer.standard.template.IGenericMessage;

import java.io.Serializable;
import java.util.List;


/**
 * @author Manuel Ernesto Bonilla Muñoz - mebonilla9@gmail.com
 */

public class ProductType extends EntityManager<ProductType> implements Serializable {


  private static final long serialVersionUID = 858022075397928313L;
  public static final String TABLE_NAME = "public.product_type";

  public static final String COL_ID = "id";
  public static final String COL_NAME = "name";
  public static final String COL_ID_SUB_TYPE = "id_sub_type";


  private Integer id;
  private String name;
  private ProductType idSubType;


  public ProductType() {
    super(TABLE_NAME);
  }

  public ProductType(Integer id) {
    this();
    super.set(COL_ID);
    this.id = id;
  }


  @Override
  public PrimaryKey primaryKey() {
    return new PrimaryKey(
      COL_ID,
      Integer.class, ETypePrimaryKey.AUTOINCREMENT);
  }

  @Override
  public void primaryKey(Object key) {
    this.id = (Integer) key;
  }

  public Integer getId() {
    return id;
  }

  public ProductType setId(Integer id) {
    super.set(COL_ID);
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public ProductType setName(String name) {
    super.set(COL_NAME);
    this.name = name;
    return this;
  }

  public ProductType getIdSubType() {
    return idSubType;
  }

  public ProductType setIdSubType(ProductType idSubType) {
    super.set(COL_ID_SUB_TYPE);
    this.idSubType = idSubType;
    return this;
  }


  @Override
  public ProductType validate() throws AppException {
    return this;
  }

  @Override
  public ProductType getRegister(Retrieve retrieve)
    throws JdbcException {

    Integer idCol = retrieve.getObjectOptional(COL_ID, Integer.class);
    if (idCol != null) {
      setId(idCol);
    }
    String nameCol = retrieve.getObjectOptional(COL_NAME, String.class);
    if (nameCol != null) {
      setName(nameCol);
    }
    Integer idSubTypeCol = retrieve.getObjectOptional(COL_ID_SUB_TYPE, Integer.class);
    if (idSubTypeCol != null) {
      ProductType objIdSubType = new ProductType();
      objIdSubType.setId(idSubTypeCol);
      setIdSubType(objIdSubType);
    }

    return this;
  }

  @Override
  public Object getValue(String columnName)
    throws AppException {
    switch (columnName) {
      case COL_ID:
        return id;
      case COL_NAME:
        return name;
      case COL_ID_SUB_TYPE:
        return idSubType == null ? null : idSubType.getId();

      default:
        throw new AppException(EMessageRosilla.ERROR_DATABASE_COLUMN_NO_FOUND_NAME, columnName);
    }
  }


  public static List<ProductType> list(EQueryList sqlName, Param<String, Object> params)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, ProductType.class, null);
  }

  public static List<ProductType> list(EQueryList sqlName, Param<String, Object> params, IGenericMessage noResults)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, ProductType.class, noResults);
  }

  public static ProductType fill(Retrieve retrieve)
    throws JdbcException {
    return new ProductType().getRegister(retrieve);
  }


}
