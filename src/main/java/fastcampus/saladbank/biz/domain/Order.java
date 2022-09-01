package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ORDERS")
@Entity
public class Order extends BaseTime {

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "APPLY_DATE", nullable = false)
    private LocalDate applyDate;

    @Column(name = "EXPIRY_DATE")
    private LocalDate expiryDate;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @OneToMany
    @JoinColumn(name = "LOAN_ID")
    private List<Loan> loanList = new LinkedList<>();

    @OneToMany
    @JoinColumn(name = "CARD_ID")
    private List<Card> cardList = new LinkedList<>();

    @Builder
    public Order(LocalDate applyDate, LocalDate expiryDate, String status) {
        this.applyDate = applyDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    public void update(LocalDate applyDate, LocalDate expiryDate, String status) {
        this.applyDate = applyDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }
}
