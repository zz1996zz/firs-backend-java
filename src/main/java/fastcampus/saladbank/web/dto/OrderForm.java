package fastcampus.saladbank.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderForm {
    private LocalDate applyDate;
    private LocalDate expiryDate;
    private String status;

    // 주문 등록시 사용
    @Builder
    public OrderForm(LocalDate applyDate, LocalDate expiryDate, String status) {
        this.applyDate = applyDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }

}
