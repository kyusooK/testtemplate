package edittemplate.domain;

import edittemplate.OrderApplication;
import edittemplate.domain.OrderPlaced;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private String userId;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        edittemplate.external.Product product = new edittemplate.external.Product();
        // mappings goes here
        OrderApplication.applicationContext
            .getBean(edittemplate.external.ProductService.class)
            .decreaseStock(product);

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
        // Get request from Product
        //edittemplate.external.Product product =
        //    OrderApplication.applicationContext.getBean(edittemplate.external.ProductService.class)
        //    .getProduct(/** mapping value needed */);
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void orderUpdate(OrderUpdateCommand orderUpdateCommand) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
