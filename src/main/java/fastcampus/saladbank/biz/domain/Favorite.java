package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "FAVORITE")
@Entity
public class Favorite extends BaseTime {

    @Id
    @Column(name = "FAVORITE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favoriteId;

    @OneToMany(mappedBy = "favorite", cascade = ALL)
    private List<FavoriteItem> favoriteItems = new ArrayList<>();

    @OneToOne
    private Member member;

    @Builder
    public Favorite(Member member){
        this.member=member;
    }

    public void addFavoriteItem(FavoriteItem favoriteItem){
        this.favoriteItems.add(favoriteItem);
        if(favoriteItem.getFavorite()!=this){
            favoriteItem.setFavorite(this);
        }
    }
}
