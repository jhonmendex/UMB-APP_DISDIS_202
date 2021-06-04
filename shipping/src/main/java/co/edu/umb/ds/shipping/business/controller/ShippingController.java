package co.edu.umb.ds.shipping.business.controller;

import co.edu.umb.ds.shipping.business.service.ShippingService;
import co.edu.umb.ds.shipping.persistence.entity.publics.Shipping;
import com.spiwer.rosilla.exception.JdbcException;
import com.spiwer.standard.dto.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipping")
public class ShippingController extends GenericController{

  private final ShippingService shippingService;

  public ShippingController(ShippingService shippingService) {
    this.shippingService = shippingService;
  }

  @GetMapping("/{id-order-history}")
  public ResponseEntity<Answer<List<Shipping>>> getShippingByOrderHistory(
    @PathVariable("id-order-history") Integer idOrderHistory) throws JdbcException {
    List<Shipping> shippingList = shippingService.getShippingByOrderHistory(idOrderHistory);
    return new ResponseEntity(new Answer<>().setInfo(shippingList), HttpStatus.OK);
  }
}
