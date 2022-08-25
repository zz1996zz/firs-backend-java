package fastcampus.saladbank.biz.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FAVORITE")
@Getter
public class Favorite extends BaseTime {

    @Id
    @Column(name = "FAVORITE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    @JoinColumn(name = "PRODUCT_ID")
    private List<Product> product;
}
