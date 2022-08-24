package fastcampus.saladbank.biz.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MEMBER")
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "MOBILE_CARRIER", nullable = false)
    private String mobileCarrier;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "AGE", nullable = false)
    private int age;

    @Column(name = "JOB", nullable = false)
    private String job;

    @Column(name = "HOBBY", nullable = false)
    private String hobby;

    @Column(name = "CREDIT_RATING", nullable = false)
    private int creditRating;

    @OneToOne
    private Cart cart;

    @OneToMany
    @JoinColumn(name = "ORDERS_ID")
    private List<Order> orders;

    @OneToMany
    @JoinColumn(name = "FAVORITE_ID")
    private List<Favorite> favorites;
}
