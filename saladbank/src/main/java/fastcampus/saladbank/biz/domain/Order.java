package fastcampus.saladbank.biz.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
public class Order extends BaseTime {

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    @JoinColumn(name = "PRODUCT_ID")
    private List<Product> product;

//    @OneToOne
//    private Cart cart;

    @Column(name = "APPLY_DATE", nullable = false)
    private LocalDate applyDate;

    @Column(name = "EXPIRY_DATE", nullable = true)
    private LocalDate expiryDate;

    @Column(name = "STATUS", nullable = false)
    private String status;
}
