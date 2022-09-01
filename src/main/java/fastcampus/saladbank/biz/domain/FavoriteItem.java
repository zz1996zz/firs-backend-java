package fastcampus.saladbank.biz.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="FAVORITE_ITEM")
@Getter
@NoArgsConstructor
public class FavoriteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FAVORITE_ITEM_ID")
    private Long favoriteItemId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="CARD_ID")
    private Card card;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="LOAN_ID")
    private Loan loan;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="FAVORITE_ID")
    private Favorite favorite;

    @Builder
    public FavoriteItem(Favorite favorite,Card card,Loan loan){
        this.favorite=favorite;
        this.card=card;
        this.loan=loan;
    }



    public void setFavorite(Favorite favorite){
        if(this.favorite != null){
            this.favorite.getFavoriteItems().remove(this);
        }
        this.favorite = favorite;
        if(!this.favorite.getFavoriteItems().contains(this)){
            this.favorite.addFavoriteItem(this);
        }
    }

    public void setCard(Card card){
        if(this.card != null){
            this.card.getFavoriteItems().remove(this);
        }
        this.card =card;
        if(!this.card.getFavoriteItems().contains(this)){
            this.card.addFavoriteItem(this);
        }
    }

    public void setLoan(Loan loan){
        if(this.loan != null){
            this.loan.getFavoriteItems().remove(this);
        }
        this.loan =loan;
        if(!this.loan.getFavoriteItems().contains(this)){
            this.loan.addFavoriteItem(this);
        }
    }

}
