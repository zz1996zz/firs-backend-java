package fastcampus.saladbank.biz.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "CART_ITEM")
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
