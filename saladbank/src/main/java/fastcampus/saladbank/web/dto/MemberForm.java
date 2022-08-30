package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Member;
import lombok.Data;

@Data
public class MemberForm {

    private String username;
    private String password;
    private String name;
    private String gender;
    private int age;
    private String job;
    private int income;
    private String hobby;
    private Boolean house;

    public Member toEntity() {
        return new Member(username, password, name, gender, age, job, income, hobby, house);
    }

    public void toMemberForm(Member member) {
        this.username = member.getUsername();
        this.password = member.getPassword();
        this.name = member.getName();
        this.gender = member.getGender();
        this.age = member.getAge();
        this.job = member.getJob();
        this.income = member.getIncome();
        this.hobby = member.getHobby();
        this.house = member.getHouse();
    }
}
