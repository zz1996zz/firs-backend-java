package fastcampus.saladbank.web.dto;

import lombok.Data;

@Data
public class SearchProductForm {

    private String productType;
    private String searchKeyword;
}
