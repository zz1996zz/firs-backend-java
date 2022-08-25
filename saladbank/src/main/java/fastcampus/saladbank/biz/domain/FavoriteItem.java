package fastcampus.saladbank.biz.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "FAVORITE_ITEM")
public class FavoriteItem extends BaseTime {

    @Id
    @Column(name = "FAVORITE_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "ORDERS_ID")
    private Favorite favorite;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
