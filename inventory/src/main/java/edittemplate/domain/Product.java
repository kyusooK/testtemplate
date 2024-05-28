package edittemplate.domain;

import edittemplate.InventoryApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Product_table")
@Data
//<<< DDD / Aggregate Root
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer stock;

    @PostPersist
    public void onPostPersist() {}

    public static ProductRepository repository() {
        ProductRepository productRepository = InventoryApplication.applicationContext.getBean(
            ProductRepository.class
        );
        return productRepository;
    }
}
//>>> DDD / Aggregate Root
