package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CART")
@Entity
public class Cart extends BaseTime {

    @Id
    @Column(name = "CART_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Member member;

    @Builder
    public Cart(Member member){
        this.member=member;
    }

}
