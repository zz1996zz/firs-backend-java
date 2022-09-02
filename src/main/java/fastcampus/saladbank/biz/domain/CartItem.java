package fastcampus.saladbank.biz.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Table(name="CART_ITEM")
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CART_ITEM_ID")
    private Long cartItemId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="CART_ID")
    private Cart cart;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="CARD_ID")
    private Card card;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="LOAN_ID")
    private Loan loan;

    @Builder
    public CartItem(Cart cart,Card card,Loan loan){
        this.cart=cart;
        this.card=card;
        this.loan=loan;
    }


    public void setCart(Cart cart){
        if(this.cart != null){
            this.cart.getCartItems().remove(this);
        }
        this.cart =cart;
        if(!this.cart.getCartItems().contains(this)){
            this.cart.addCartItem(this);
        }
    }

    public void setCard(Card card){
        if(this.card != null){
            this.card.getCartItems().remove(this);
        }
        this.card =card;
        if(!this.card.getCartItems().contains(this)){
            this.card.addCartItem(this);
        }
    }

    public void setLoan(Loan loan){
        if(this.loan != null){
            this.loan.getCartItems().remove(this);
        }
        this.loan =loan;
        if(!this.loan.getCartItems().contains(this)){
            this.loan.addCartItem(this);
        }
    }

}
