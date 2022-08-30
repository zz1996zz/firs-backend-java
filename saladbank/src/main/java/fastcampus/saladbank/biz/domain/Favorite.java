package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
