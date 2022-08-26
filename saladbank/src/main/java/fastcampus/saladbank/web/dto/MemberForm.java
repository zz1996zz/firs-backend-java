package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Member;
import lombok.Data;

@Data
public class MemberForm {

    private String username;
    private String password;
    private String name;
    private String mobileCarrier;
    private String phone;
    private int age;
    private String job;
    private String hobby;
    private int creditRating;

    public Member toEntity(){
        return new Member(username,password,name,mobileCarrier,phone,age,job,hobby,creditRating);
    }
}
