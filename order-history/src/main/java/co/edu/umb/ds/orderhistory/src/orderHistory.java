package co.edu.umb.ds.orderhistory.src;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Kafka")
public class orderHistory {

    @Autowired
    KafkaTemplate<String, String> KafkaTemplate;
    private static final String TOPIC = "order_history";

    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message") final String message){

        KafkaTemplate.send(TOPIC, message);
        return "Published successfully";
    }

}
