
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
import java.time.LocalDateTime;
import java.util.List;


/**
 * @author Manuel Ernesto Bonilla Muñoz - mebonilla9@gmail.com
 */

public class Inventory extends EntityManager<Inventory> implements Serializable {


  private static final long serialVersionUID = -6572400048621589991L;
  public static final String TABLE_NAME = "public.inventory";

  public static final String COL_ID = "id";
  public static final String COL_QUANTITY = "quantity";
  public static final String COL_UPDATED_AT = "updated_at";
  public static final String COL_ID_PRODUCT = "id_product";


  private Integer id;
  private Integer quantity;
  private LocalDateTime updatedAt;
  private Product idProduct;


  public Inventory() {
    super(TABLE_NAME);
  }

  public Inventory(Integer id) {
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

  public Inventory setId(Integer id) {
    super.set(COL_ID);
    this.id = id;
    return this;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public Inventory setQuantity(Integer quantity) {
    super.set(COL_QUANTITY);
    this.quantity = quantity;
    return this;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public Inventory setUpdatedAt(LocalDateTime updatedAt) {
    super.set(COL_UPDATED_AT);
    this.updatedAt = updatedAt;
    return this;
  }

  public Product getIdProduct() {
    return idProduct;
  }

  public Inventory setIdProduct(Product idProduct) {
    super.set(COL_ID_PRODUCT);
    this.idProduct = idProduct;
    return this;
  }


  @Override
  public Inventory validate() throws AppException {
    return this;
  }

  @Override
  public Inventory getRegister(Retrieve retrieve)
    throws JdbcException {

    Integer idCol = retrieve.getObjectOptional(COL_ID, Integer.class);
    if (idCol != null) {
      setId(idCol);
    }
    Integer quantityCol = retrieve.getObjectOptional(COL_QUANTITY, Integer.class);
    if (quantityCol != null) {
      setQuantity(quantityCol);
    }
    LocalDateTime updatedAtCol = retrieve.getObjectOptional(COL_UPDATED_AT, LocalDateTime.class);
    if (updatedAtCol != null) {
      setUpdatedAt(updatedAtCol);
    }
    Integer idProductCol = retrieve.getObjectOptional(COL_ID_PRODUCT, Integer.class);
    if (idProductCol != null) {
      Product objIdProduct = new Product();
      objIdProduct.setId(idProductCol);
      setIdProduct(objIdProduct);
    }

    return this;
  }

  @Override
  public Object getValue(String columnName)
    throws AppException {
    switch (columnName) {
      case COL_ID:
        return id;
      case COL_QUANTITY:
        return quantity;
      case COL_UPDATED_AT:
        return updatedAt;
      case COL_ID_PRODUCT:
        return idProduct == null ? null : idProduct.getId();

      default:
        throw new AppException(EMessageRosilla.ERROR_DATABASE_COLUMN_NO_FOUND_NAME, columnName);
    }
  }


  public static List<Inventory> list(EQueryList sqlName, Param<String, Object> params)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, Inventory.class, null);
  }

  public static List<Inventory> list(EQueryList sqlName, Param<String, Object> params, IGenericMessage noResults)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, Inventory.class, noResults);
  }

  public static Inventory fill(Retrieve retrieve)
    throws JdbcException {
    return new Inventory().getRegister(retrieve);
  }


}
