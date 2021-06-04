
package co.edu.umb.ds.shipping.persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.spiwer.rosilla.database.ConnectionManager;
import com.spiwer.rosilla.template.IDatabaseConnect;
import com.spiwer.rosilla.lasting.EMessageRosilla;
import com.spiwer.standard.exception.AppException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Manuel Ernesto Bonilla Muñoz - mebonilla9@gmail.com
 */
public class DatabaseConnection extends ConnectionManager implements IDatabaseConnect {

    private static final Logger LOG = Logger.getLogger(DatabaseConnection.class.getName());

 @Override
    public  Connection connect() throws AppException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e_commerce", "recipes", "recipes");
            cnn.setAutoCommit(false);
            return cnn;
        } catch (SQLException|ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            throw new AppException(EMessageRosilla.ERROR_DATABASE_CONNECTION);
        }
    }

/*
@Override
    public  Connection connect() throws AppException {
      try {
          Context context = new InitialContext();
          DataSource ds = (DataSource) context.lookup("java:/pool");
          return ds;
       } catch (Exception ex) {
          LOG.log(Level.SEVERE, ex.getMessage(), ex);
          throw new AppException(EMessageRosilla.ERROR_DATABASE_CONNECTION);
       }
    }
*/
}
