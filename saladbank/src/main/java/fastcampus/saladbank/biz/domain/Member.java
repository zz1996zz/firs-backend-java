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

    @Column(name = "sex")
    private String sex;

    @Column(name = "AGE")
    private int age;

    @Column(name = "JOB")
    private String job;

    @Column(name = "income")
    private int income;

    @Column(name = "HOBBY")
    private String hobby;

    @Column(name = "CREDIT_RATING")
    private int creditRating;

    @OneToMany
    @JoinColumn(name = "ORDERS_ID")
    private List<Order> orders;

    @OneToMany
    @JoinColumn(name = "FAVORITE_ID")
    private List<Favorite> favorites;

    @Builder
    public Member(String username, String password, String name, String sex, int age, String job, int income, String hobby, int creditRating) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.job = job;
        this.income = income;
        this.hobby = hobby;
        this.creditRating = creditRating;
    }

    public void registerMemberInfo(MemberForm memberForm, boolean houseYN) {
        this.age = memberForm.getAge();
        this.job = memberForm.getJob();
        this.hobby = memberForm.getHobby();
        inquireCreditInfo(memberForm.getIncome(), houseYN);
    }

    private void inquireCreditInfo(int income, boolean houseYN) {
        if (houseYN) {
            setGrade(income);
        } else {
            setGrade(income);
        }
    }

    private void setGrade(int income) {
        /*switch (money) {
            case "5000~":
                this.creditRating = 1;
                break;
            case "1000~5000":
                this.creditRating = 2;
                break;
            default:
                this.creditRating = 3;
                break;
        }*/
        //if로 다시 짜기
    }
}
