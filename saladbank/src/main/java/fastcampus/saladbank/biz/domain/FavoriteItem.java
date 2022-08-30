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
@Table(name = "FAVORITE_ITEM")
@Entity
public class FavoriteItem extends BaseTime {

    @Id
    @Column(name = "FAVORITE_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favoriteItemId;

    @OneToOne
    private Favorite favorite;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Loan> loanList = new LinkedList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Card> cardList= new LinkedList<>();

    @Builder
    public FavoriteItem(Favorite favorite){
        this.favorite=favorite;
    }

    public void addCard(Card card){
        this.cardList.add(card);
    }

    public void addLoan(Loan loan){
        this.loanList.add(loan);
    }

}
