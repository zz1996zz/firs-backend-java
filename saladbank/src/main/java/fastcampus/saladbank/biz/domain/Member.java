package fastcampus.saladbank.biz.domain;

import fastcampus.saladbank.web.dto.MemberForm;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTime {

    @Id
    @Column(name = "MEMBER_ID")
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

    @Column(name = "AGE")
    private int age;

    @Column(name = "JOB")
    private String job;

    @Column(name = "HOBBY")
    private String hobby;

    @Column(name = "CREDIT_RATING")
    private int creditRating;

    @OneToOne
    private Cart cart;

    @OneToMany
    @JoinColumn(name = "ORDERS_ID")
    private List<Order> orders;

    @OneToMany
    @JoinColumn(name = "FAVORITE_ID")
    private List<Favorite> favorites;

    @Builder
    public Member(String username, String password, String name, String mobileCarrier, String phone, int age, String job, String hobby, int creditRating) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.mobileCarrier = mobileCarrier;
        this.phone = phone;
        this.age = age;
        this.job = job;
        this.hobby = hobby;
        this.creditRating = creditRating;
    }

    public void registerMemberInfo(MemberForm memberForm, String money, boolean houseYN) {
        this.age = memberForm.getAge();
        this.job = memberForm.getJob();
        this.hobby = memberForm.getHobby();
        inquireCreditInfo(money, houseYN);
    }

    private void inquireCreditInfo(String money, boolean houseYN) {
        if (houseYN) {
            setGrade(money);
        } else {
            setGrade(money);
        }
    }

    private void setGrade(String money) {
        switch (money) {
            case "5000~":
                this.creditRating = 1;
                break;
            case "1000~5000":
                this.creditRating = 2;
                break;
            default:
                this.creditRating = 3;
                break;
        }
    }
}
