package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "CART_ITEM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartItem extends BaseTime {

    @Id
    @Column(name = "CART_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
