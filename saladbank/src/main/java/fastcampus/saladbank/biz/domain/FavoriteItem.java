package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @OneToMany
    @JoinColumn(name = "LOAN_ID")
    private List<Loan> loanList;

    @OneToMany
    @JoinColumn(name = "card_ID")
    private List<Card> cardList;

    @Builder
    public FavoriteItem(Favorite favorite, Card card){
        this.favorite=favorite;
        this.cardList.add(card);
    }
    @Builder
    public FavoriteItem(Favorite favorite, Loan loan){
        this.favorite=favorite;
        this.loanList.add(loan);
    }

}
