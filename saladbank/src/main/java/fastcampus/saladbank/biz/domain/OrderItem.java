package fastcampus.saladbank.biz.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem extends BaseTime {

    @Id
    @Column(name = "ORDER_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "ORDERS_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "LOAN_ID")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "CARD_ID")
    private Card card;
}
