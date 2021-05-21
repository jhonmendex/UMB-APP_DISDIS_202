
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

public class Shipping extends EntityManager<Shipping> implements Serializable {


  private static final long serialVersionUID = 30392615933738424L;
  public static final String TABLE_NAME = "public.shipping";

  public static final String COL_ID = "id";
  public static final String COL_ADDRESS = "address";
  public static final String COL_SENT_AT = "sent_at";
  public static final String COL_RECEIVED_AT = "received_at";
  public static final String COL_ID_ORDER_HISTORY = "id_order_history";


  private Integer id;
  private String address;
  private LocalDateTime sentAt;
  private LocalDateTime receivedAt;
  private OrderHistory idOrderHistory;


  public Shipping() {
    super(TABLE_NAME);
  }

  public Shipping(Integer id) {
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

  public Shipping setId(Integer id) {
    super.set(COL_ID);
    this.id = id;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Shipping setAddress(String address) {
    super.set(COL_ADDRESS);
    this.address = address;
    return this;
  }

  public LocalDateTime getSentAt() {
    return sentAt;
  }

  public Shipping setSentAt(LocalDateTime sentAt) {
    super.set(COL_SENT_AT);
    this.sentAt = sentAt;
    return this;
  }

  public LocalDateTime getReceivedAt() {
    return receivedAt;
  }

  public Shipping setReceivedAt(LocalDateTime receivedAt) {
    super.set(COL_RECEIVED_AT);
    this.receivedAt = receivedAt;
    return this;
  }

  public OrderHistory getIdOrderHistory() {
    return idOrderHistory;
  }

  public Shipping setIdOrderHistory(OrderHistory idOrderHistory) {
    super.set(COL_ID_ORDER_HISTORY);
    this.idOrderHistory = idOrderHistory;
    return this;
  }


  @Override
  public Shipping validate() throws AppException {
    return this;
  }

  @Override
  public Shipping getRegister(Retrieve retrieve)
    throws JdbcException {

    Integer idCol = retrieve.getObjectOptional(COL_ID, Integer.class);
    if (idCol != null) {
      setId(idCol);
    }
    String addressCol = retrieve.getObjectOptional(COL_ADDRESS, String.class);
    if (addressCol != null) {
      setAddress(addressCol);
    }
    LocalDateTime sentAtCol = retrieve.getObjectOptional(COL_SENT_AT, LocalDateTime.class);
    if (sentAtCol != null) {
      setSentAt(sentAtCol);
    }
    LocalDateTime receivedAtCol = retrieve.getObjectOptional(COL_RECEIVED_AT, LocalDateTime.class);
    if (receivedAtCol != null) {
      setReceivedAt(receivedAtCol);
    }
    Integer idOrderHistoryCol = retrieve.getObjectOptional(COL_ID_ORDER_HISTORY, Integer.class);
    if (idOrderHistoryCol != null) {
      OrderHistory objIdOrderHistory = new OrderHistory();
      objIdOrderHistory.setId(idOrderHistoryCol);
      setIdOrderHistory(objIdOrderHistory);
    }

    return this;
  }

  @Override
  public Object getValue(String columnName)
    throws AppException {
    switch (columnName) {
      case COL_ID:
        return id;
      case COL_ADDRESS:
        return address;
      case COL_SENT_AT:
        return sentAt;
      case COL_RECEIVED_AT:
        return receivedAt;
      case COL_ID_ORDER_HISTORY:
        return idOrderHistory == null ? null : idOrderHistory.getId();

      default:
        throw new AppException(EMessageRosilla.ERROR_DATABASE_COLUMN_NO_FOUND_NAME, columnName);
    }
  }


  public static List<Shipping> list(EQueryList sqlName, Param<String, Object> params)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, Shipping.class, null);
  }

  public static List<Shipping> list(EQueryList sqlName, Param<String, Object> params, IGenericMessage noResults)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, Shipping.class, noResults);
  }

  public static Shipping fill(Retrieve retrieve)
    throws JdbcException {
    return new Shipping().getRegister(retrieve);
  }


}
