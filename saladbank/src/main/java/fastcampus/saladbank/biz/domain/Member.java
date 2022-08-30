package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBER")
@Entity
public class Member extends BaseTime {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ROLE")
    private String role = "ROLE_USER";

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "AGE")
    private int age;

    @Column(name = "JOB")
    private String job;

    @Column(name = "INCOME")
    private int income;

    @Column(name = "HOBBY")
    private String hobby;

    @Column(name = "house")
    private Boolean house;

    @OneToMany
    @JoinColumn(name = "ORDERS_ID")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(String username, String password, String name, String gender, int age, String job, int income, String hobby, Boolean house) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.income = income;
        this.hobby = hobby;
        this.house = house;
    }
}
