
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

public class OrderHistory extends EntityManager<OrderHistory> implements Serializable {


  private static final long serialVersionUID = 8919205158058884392L;
  public static final String TABLE_NAME = "public.order_history";

  public static final String COL_ID = "id";
  public static final String COL_QUANTITY = "quantity";
  public static final String COL_TOTAL_PRICE = "total_price";
  public static final String COL_PRODUCTS = "products";


  private Integer id;
  private Integer quantity;
  private Double totalPrice;
  private String products;


  public OrderHistory() {
    super(TABLE_NAME);
  }


  @Override
  public PrimaryKey primaryKey() {
    return new PrimaryKey(
      null,
      null, ETypePrimaryKey.OTHER);
  }

  @Override
  public void primaryKey(Object key) {
    this.id = (Integer) key;
  }

  public Integer getId() {
    return id;
  }

  public OrderHistory setId(Integer id) {
    super.set(COL_ID);
    this.id = id;
    return this;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public OrderHistory setQuantity(Integer quantity) {
    super.set(COL_QUANTITY);
    this.quantity = quantity;
    return this;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public OrderHistory setTotalPrice(Double totalPrice) {
    super.set(COL_TOTAL_PRICE);
    this.totalPrice = totalPrice;
    return this;
  }

  public String getProducts() {
    return products;
  }

  public OrderHistory setProducts(String products) {
    super.set(COL_PRODUCTS);
    this.products = products;
    return this;
  }


  @Override
  public OrderHistory validate() throws AppException {
    return this;
  }

  @Override
  public OrderHistory getRegister(Retrieve retrieve)
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
    String productsCol = retrieve.getObjectOptional(COL_PRODUCTS, String.class);
    if (productsCol != null) {
      setProducts(productsCol);
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
      case COL_PRODUCTS:
        return products;

      default:
        throw new AppException(EMessageRosilla.ERROR_DATABASE_COLUMN_NO_FOUND_NAME, columnName);
    }
  }


  public static List<OrderHistory> list(EQueryList sqlName, Param<String, Object> params)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, OrderHistory.class, null);
  }

  public static List<OrderHistory> list(EQueryList sqlName, Param<String, Object> params, IGenericMessage noResults)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, OrderHistory.class, noResults);
  }

  public static OrderHistory fill(Retrieve retrieve)
    throws JdbcException {
    return new OrderHistory().getRegister(retrieve);
  }


}
