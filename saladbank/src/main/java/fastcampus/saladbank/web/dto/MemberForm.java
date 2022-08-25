package fastcampus.saladbank.web.dto;

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
}
