package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "FAVORITE_ITEM")
@Entity
public class FavoriteItem extends BaseTime {

    @Id
    @Column(name = "FAVORITE_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Favorite favorite;

    @ManyToOne
    @JoinColumn(name = "LOAN_ID")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "card_ID")
    private Card card;
}
