package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

    @OneToMany
    @JoinColumn(name = "LOAN_ID")
    private List<Loan> loanList= new LinkedList<>();

    @OneToMany
    @JoinColumn(name = "CARD_ID")
    private List<Card> cardList = new LinkedList<>();

    @Builder
    public CartItem(Cart cart,Loan loan){
        this.cart=cart;
        this.loanList.add(loan);
    }

    @Builder
    public CartItem(Cart cart,Card card){
        this.cart=cart;
        this.cardList.add(card);
    }

}
