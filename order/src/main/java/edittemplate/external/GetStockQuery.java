package edittemplate.external;

import java.util.Date;
import lombok.Data;

@Data
public class GetStockQuery {

    private String orderId;
    private Long qty;
    private Boolean isTrue;
}
