package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CARD")
@Entity
public class Card extends BaseTime {

    @Id
    @Column(name = "CARD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;

    @OneToMany(mappedBy = "card",cascade = ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = ALL)
    private List<FavoriteItem> favoriteItems = new ArrayList<>();

    @Column(name = "PRODUCT_TYPE")
    private String productType; //카드or대출

    @Column(name = "CARD_NAME")
    private String cardName; //카드이름

    @Column(name = "CARD_COMPANY")
    private String cardCompany; //카드회사 이름

    @Column(name = "ANNUAL_FEE")
    private String annualFee; //연회비

    @Column(name = "CARD_TYPE")
    private String cardType; // 카드 종류 (체크 or 신용)

    @Column(name = "CARD_DESCRIPTION")
    private String cardDescription; //카드 간단한 설명

    @Column(name = "FRANCHISEE")
    private String franchisee; // 가맹점 적립률 "0.3 1.0"

    @Column(name = "SHOPPING")
    private String shopping; // "10만원 당 5천 머니" 적립

    @Column(name = "OILING")
    private String oiling; // "5만원당 3천원"

    @Column(name = "INSURANCE")
    private String insurance; // "10만원 당 5천 머니"

    @Column(name = "CAFE")
    private String cafe; // "1000"

    @Column(name = "TAG")
    private String tag; // "주부 그림/운동 30대" 나이/직업/취미 하나씩 들가는 곳

    @Column(name = "IMG")
    private String img; // 이미지 주소 저장하는 곳

    public void addCartItem(CartItem cartItem){
        this.cartItems.add(cartItem);
        if(cartItem.getCard()!=this){
            cartItem.setCard(this);
        }
    }

    public void addFavoriteItem(FavoriteItem favoriteItem){
        this.favoriteItems.add(favoriteItem);
        if(favoriteItem.getCard()!=this){
            favoriteItem.setCard(this);
        }
    }
}