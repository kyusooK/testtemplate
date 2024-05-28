package edittemplate.domain;

import edittemplate.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository
    extends PagingAndSortingRepository<Product, Long> {
    @Query(
        value = "select product " +
        "from Product product " +
        "where(:orderId is null or product.orderId like %:orderId%) and (:qty is null or product.qty like %:qty%) and (:isTrue is null or product.isTrue like %:isTrue%)"
    )
    List<Product> findByGetStock(
        String orderId,
        Long qty,
        Boolean isTrue,
        Pageable pageable
    );
}
