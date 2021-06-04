package co.edu.umb.ds.shipping.business.service;

import co.edu.umb.ds.shipping.business.constants.Topics;
import co.edu.umb.ds.shipping.persistence.entity.publics.Shipping;
import com.spiwer.rosilla.exception.JdbcException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {

  public List<Shipping> getShippingByOrderHistory(Integer orderHistory) throws JdbcException {
    return new Shipping().where().and(Shipping.COL_ID_ORDER_HISTORY, "=", orderHistory).list();
  }

  @KafkaListener(topics = Topics.ORDER_HISTORY_TOPIC, groupId = "shipping_group",
    containerFactory = "orderHistoryKafkaListenerFactory")
  public void saveShipping(Shipping shipping) throws JdbcException {
    shipping.insert();
  }
}
