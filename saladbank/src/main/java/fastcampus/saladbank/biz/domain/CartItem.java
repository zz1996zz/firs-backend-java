package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CART_ITEM")
@Entity
public class CartItem extends BaseTime {

    @Id
    @Column(name = "CART_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;

    @OneToOne
    private Cart cart;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Loan> loanList= new LinkedList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Card> cardList = new LinkedList<>();

    public void addCartLoan(Loan loan){
        this.loanList.add(loan);
    }

    public void addCartCard(Card card){
        this.cardList.add(card);
    }

    @Builder
    public CartItem(Cart cart) {
        this.cart=cart;
    }
}
