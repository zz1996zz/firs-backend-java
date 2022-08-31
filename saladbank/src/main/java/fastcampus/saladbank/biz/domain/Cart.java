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
@Table(name = "CART")
@Entity
public class Cart extends BaseTime {

    @Id
    @Column(name = "CART_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @OneToOne
    private Member member;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "LOAN_ID")
    private List<Loan> loanList= new LinkedList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CARD_ID")
    private List<Card> cardList = new LinkedList<>();

    public void addCartLoan(Loan loan){
        this.loanList.add(loan);
    }

    public void addCartCard(Card card){
        this.cardList.add(card);
    }

    @Builder
    public Cart(Member member) {
        this.member=member;
    }
}
