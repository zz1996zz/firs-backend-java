package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class OrderForm {
    private LocalDate applyDate;
    private LocalDate expiryDate;
    private String status;
    @Builder
    public OrderForm(LocalDate applyDate, LocalDate expiryDate, String status) {
        this.applyDate = applyDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    public Order toEntity() {
        return Order.builder()
                .applyDate(applyDate)
                .expiryDate(expiryDate)
                .status(status)
                .build();
    }

}
