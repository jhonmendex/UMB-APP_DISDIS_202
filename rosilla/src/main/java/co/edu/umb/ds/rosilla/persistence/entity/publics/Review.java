
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

public class Review extends EntityManager<Review> implements Serializable {


  private static final long serialVersionUID = 2909861760883711705L;
  public static final String TABLE_NAME = "public.review";

  public static final String COL_ID = "id";
  public static final String COL_NAME = "name";
  public static final String COL_SCORE = "score";
  public static final String COL_CREATED_AT = "created_at";
  public static final String COL_CONTENT = "content";
  public static final String COL_LIKES = "likes";
  public static final String COL_ID_PRODUCT = "id_product";


  private Integer id;
  private String name;
  private Integer score;
  private LocalDateTime createdAt;
  private String content;
  private Integer likes;
  private Product idProduct;


  public Review() {
    super(TABLE_NAME);
  }

  public Review(Integer id) {
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

  public Review setId(Integer id) {
    super.set(COL_ID);
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Review setName(String name) {
    super.set(COL_NAME);
    this.name = name;
    return this;
  }

  public Integer getScore() {
    return score;
  }

  public Review setScore(Integer score) {
    super.set(COL_SCORE);
    this.score = score;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public Review setCreatedAt(LocalDateTime createdAt) {
    super.set(COL_CREATED_AT);
    this.createdAt = createdAt;
    return this;
  }

  public String getContent() {
    return content;
  }

  public Review setContent(String content) {
    super.set(COL_CONTENT);
    this.content = content;
    return this;
  }

  public Integer getLikes() {
    return likes;
  }

  public Review setLikes(Integer likes) {
    super.set(COL_LIKES);
    this.likes = likes;
    return this;
  }

  public Product getIdProduct() {
    return idProduct;
  }

  public Review setIdProduct(Product idProduct) {
    super.set(COL_ID_PRODUCT);
    this.idProduct = idProduct;
    return this;
  }


  @Override
  public Review validate() throws AppException {
    return this;
  }

  @Override
  public Review getRegister(Retrieve retrieve)
    throws JdbcException {

    Integer idCol = retrieve.getObjectOptional(COL_ID, Integer.class);
    if (idCol != null) {
      setId(idCol);
    }
    String nameCol = retrieve.getObjectOptional(COL_NAME, String.class);
    if (nameCol != null) {
      setName(nameCol);
    }
    Integer scoreCol = retrieve.getObjectOptional(COL_SCORE, Integer.class);
    if (scoreCol != null) {
      setScore(scoreCol);
    }
    LocalDateTime createdAtCol = retrieve.getObjectOptional(COL_CREATED_AT, LocalDateTime.class);
    if (createdAtCol != null) {
      setCreatedAt(createdAtCol);
    }
    String contentCol = retrieve.getObjectOptional(COL_CONTENT, String.class);
    if (contentCol != null) {
      setContent(contentCol);
    }
    Integer likesCol = retrieve.getObjectOptional(COL_LIKES, Integer.class);
    if (likesCol != null) {
      setLikes(likesCol);
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
      case COL_NAME:
        return name;
      case COL_SCORE:
        return score;
      case COL_CREATED_AT:
        return createdAt;
      case COL_CONTENT:
        return content;
      case COL_LIKES:
        return likes;
      case COL_ID_PRODUCT:
        return idProduct == null ? null : idProduct.getId();

      default:
        throw new AppException(EMessageRosilla.ERROR_DATABASE_COLUMN_NO_FOUND_NAME, columnName);
    }
  }


  public static List<Review> list(EQueryList sqlName, Param<String, Object> params)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, Review.class, null);
  }

  public static List<Review> list(EQueryList sqlName, Param<String, Object> params, IGenericMessage noResults)
    throws JdbcException {
    return DatabaseManager.getEntityList(sqlName, params, Review.class, noResults);
  }

  public static Review fill(Retrieve retrieve)
    throws JdbcException {
    return new Review().getRegister(retrieve);
  }


}
