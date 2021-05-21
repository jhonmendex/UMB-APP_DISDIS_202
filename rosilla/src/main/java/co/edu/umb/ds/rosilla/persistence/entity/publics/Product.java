
package co.edu.umb.ds.rosilla.persistence.entity.publics;

import java.io.Serializable;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.ResultSet;
import java.util.Map;

import com.spiwer.rosilla.util.Retrieve;
import com.spiwer.rosilla.dto.Param;
import com.spiwer.rosilla.template.EntityManager;
import com.spiwer.rosilla.exception.JdbcException;
import com.spiwer.rosilla.database.DatabaseManager;
import com.spiwer.standard.column.PrimaryKey;
import com.spiwer.standard.exception.AppException;
import com.spiwer.standard.lasting.ETypePrimaryKey;
import com.spiwer.standard.template.IGenericMessage;
import com.spiwer.rosilla.lasting.EMessageRosilla;
import co.edu.umb.ds.rosilla.persistence.lasting.EQueryList;
import co.edu.umb.ds.rosilla.persistence.entity.publics.*;


/**
 * @author Manuel Ernesto Bonilla Muñoz - mebonilla9@gmail.com
 */

public class Product extends EntityManager<Product> implements Serializable {


  private static final long serialVersionUID = 4580983269948496475L;
  public static final String TABLE_NAME = "public.product";

  public static final String COL_ID = "id";
  public static final String COL_NAME = "name";
  public static final String COL_PRICE = "price";
  public static final String COL_ID_PRODUCT_TYPE = "id_product_type";


  private Integer id;
  private String name;
  private Double price;
  private ProductType idProductType;


  public Product() {
    super(TABLE_NAME);
  }

  public Product(Integer id) {
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

  public Product setId(Integer id) {
    super.set(COL_ID);
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Product setName(String name) {
    super.set(COL_NAME);
    this.name = name;
    return this;
  }

  public Double getPrice() {
    return price;
  }

  public Product setPrice(Double price) {
    super.set(COL_PRICE);
    this.price = price;
    return this;
  }

  public ProductType getIdProductType() {
    return idProductType;
  }

  public Product setIdProductType(ProductType idProductType) {
    super.set(COL_ID_PRODUCT_TYPE);
    this.idProductType = idProductType;
    return this;
  }


  @Override
  public Product validate() throws AppException {
    return this;
  }

  @Override
  public Product getRegister(Retrieve retrieve)
    throws JdbcException {

    Integer idCol = retrieve.getObjectOptional(COL_ID, Integer.class);
    if (idCol != null) {
      setId(idCol);
    }
    String nameCol = retrieve.getObjectOptional(COL_NAME, String.class);
    if (nameCol != null) {
      setName(nameCol);
    }
    Double priceCol = retrieve.getObjectOptional(COL_PRICE, Double.class);
    if (priceCol != null) {
      setPrice(priceCol);
    }
    Integer idProductTypeCol = retrieve.getObjectOptional(COL_ID_PRODUCT_TYPE, Integer.class);
    if (idProductTypeCol != null) {
      ProductType objIdProductType = new ProductType();
      objIdProductType.setId(idProductTypeCol);
      setIdProductType(objIdProductType);
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
      case COL_PRICE:
        return price;
      case COL_ID_PRODUCT_TYPE:
        return idProductType == null ? null : idProductType.getId();

      default:
        throw new AppException(EMessageRosilla.ERROR_DATABASE_COLUMN_NO_FOUND_NAME, columnName);
    }
  }


  public static List<Product> list(EQueryList sqlName, Param<String, Object> params)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, Product.class, null);
  }

  public static List<Product> list(EQueryList sqlName, Param<String, Object> params, IGenericMessage noResults)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, Product.class, noResults);
  }

  public static Product fill(Retrieve retrieve)
    throws JdbcException {
    return new Product().getRegister(retrieve);
  }


}
