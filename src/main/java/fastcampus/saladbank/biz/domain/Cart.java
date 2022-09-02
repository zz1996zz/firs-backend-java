package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CART")
@Entity
public class Cart extends BaseTime {

    @Id
    @Column(name = "CART_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

//    @OneToMany(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "LOAN_ID")
//    private List<Loan> loanList= new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "CARD_ID")
//    private List<Card> cardList = new ArrayList<>();

    @OneToMany(mappedBy = "cart", cascade = ALL)
    private final List<CartItem> cartItems = new ArrayList<>();

    public void setMember(Member member){this.member = member;}

    public void addCartItem(CartItem cartItem){
        this.cartItems.add(cartItem);
        if(cartItem.getCart()!=this){
            cartItem.setCart(this);
        }
    }


//    public void addCartLoan(Loan loan){
//        this.loanList.add(loan);
//    }
//
//    public void addCartCard(Card card){
//        this.cardList.add(card);
//    }

    @Builder
    public Cart(Member member) {
        this.member=member;
    }

}
