package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CART_ITEM")
@Entity
public class CartItem extends BaseTime {

    @Id
    @Column(name = "CART_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "LOAN_ID")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "CARD_ID")
    private Card card;
}
