package co.edu.umb.ds.shipping;

import co.edu.umb.ds.shipping.application.lasting.EConnectionName;
import co.edu.umb.ds.shipping.persistence.database.DatabaseConnection;
import com.spiwer.rosilla.util.RequestUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ShippingApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShippingApplication.class, args);
    RequestUtil.DEFAULT = EConnectionName.DEFAULT;
    RequestUtil.CONNECTIONS_LIST.put(EConnectionName.DEFAULT, new DatabaseConnection());
  }

}
