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
@Table(name = "FAVORITE")
@Entity
public class Favorite extends BaseTime {

    @Id
    @Column(name = "FAVORITE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favoriteId;

    @OneToOne
    private Member member;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "LOAN_ID")
    private List<Loan> loanList = new LinkedList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CARD_ID")
    private List<Card> cardList= new LinkedList<>();

    @Builder
    public Favorite(Member member){
        this.member=member;
    }

    public void addCard(Card card){
        this.cardList.add(card);
    }

    public void addLoan(Loan loan){
        this.loanList.add(loan);
    }

}
