
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

public class ShoppingCart extends EntityManager<ShoppingCart> implements Serializable {


  private static final long serialVersionUID = -273495793938126439L;
  public static final String TABLE_NAME = "public.shopping_cart";

  public static final String COL_ID = "id";
  public static final String COL_QUANTITY = "quantity";
  public static final String COL_TOTAL_PRICE = "total_price";
  public static final String COL_ID_PRODUCT = "id_product";


  private Integer id;
  private Integer quantity;
  private Double totalPrice;
  private Product idProduct;


  public ShoppingCart() {
    super(TABLE_NAME);
  }

  public ShoppingCart(Integer id) {
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

  public ShoppingCart setId(Integer id) {
    super.set(COL_ID);
    this.id = id;
    return this;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public ShoppingCart setQuantity(Integer quantity) {
    super.set(COL_QUANTITY);
    this.quantity = quantity;
    return this;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public ShoppingCart setTotalPrice(Double totalPrice) {
    super.set(COL_TOTAL_PRICE);
    this.totalPrice = totalPrice;
    return this;
  }

  public Product getIdProduct() {
    return idProduct;
  }

  public ShoppingCart setIdProduct(Product idProduct) {
    super.set(COL_ID_PRODUCT);
    this.idProduct = idProduct;
    return this;
  }


  @Override
  public ShoppingCart validate() throws AppException {
    return this;
  }

  @Override
  public ShoppingCart getRegister(Retrieve retrieve)
    throws JdbcException {

    Integer idCol = retrieve.getObjectOptional(COL_ID, Integer.class);
    if (idCol != null) {
      setId(idCol);
    }
    Integer quantityCol = retrieve.getObjectOptional(COL_QUANTITY, Integer.class);
    if (quantityCol != null) {
      setQuantity(quantityCol);
    }
    Double totalPriceCol = retrieve.getObjectOptional(COL_TOTAL_PRICE, Double.class);
    if (totalPriceCol != null) {
      setTotalPrice(totalPriceCol);
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
      case COL_TOTAL_PRICE:
        return totalPrice;
      case COL_ID_PRODUCT:
        return idProduct == null ? null : idProduct.getId();

      default:
        throw new AppException(EMessageRosilla.ERROR_DATABASE_COLUMN_NO_FOUND_NAME, columnName);
    }
  }


  public static List<ShoppingCart> list(EQueryList sqlName, Param<String, Object> params)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, ShoppingCart.class, null);
  }

  public static List<ShoppingCart> list(EQueryList sqlName, Param<String, Object> params, IGenericMessage noResults)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, ShoppingCart.class, noResults);
  }

  public static ShoppingCart fill(Retrieve retrieve)
    throws JdbcException {
    return new ShoppingCart().getRegister(retrieve);
  }


}
