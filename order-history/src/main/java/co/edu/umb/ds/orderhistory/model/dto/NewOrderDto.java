package co.edu.umb.ds.orderhistory.model.dto;

import co.edu.umb.ds.orderhistory.business.exception.ApiRequestException;
import co.edu.umb.ds.orderhistory.model.entities.OrderHistory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NewOrderDto {
    private OrderHistory orderHistory;

    public NewOrderDto(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }

    public NewOrderDto() {
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(String orderHistory) {
        try {
            this.orderHistory = new ObjectMapper().readValue(orderHistory, OrderHistory.class);
        } catch (JsonProcessingException e) {

            throw new ApiRequestException("Verificar mapeo de Order_History");

        }
    }
}
