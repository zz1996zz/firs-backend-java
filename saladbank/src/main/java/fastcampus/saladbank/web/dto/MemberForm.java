package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Member;
import lombok.Data;

@Data
public class MemberForm {

    private String username;
    private String password;
    private String name;
    private String sex;
    private int age;
    private String job;
    private int income;
    private String hobby;
    private int creditRating;

    public Member toEntity() {
        return new Member(username, password, name, sex, age, job, income, hobby, creditRating);
    }
}
