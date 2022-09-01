package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

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
    public Order(Member member, String status) {
        this.member = member;
        this.status = status;
    }
    public void addOrderLoan(Loan loan){
        this.loanList.add(loan);
    }

    public void addOrderCard(Card card){
        this.cardList.add(card);
    }

    public void addExpiryDate(int period) throws Exception {
        String date = String.valueOf(getCreatedDate());
        String addDay = AddDate(date,  period);
        this.expiryDate = LocalDate.parse(addDay);
    }

    private static String AddDate(String strDate, int day) throws Exception {
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        Date dt = dtFormat.parse(strDate);
        cal.setTime(dt);
        cal.add(Calendar.DATE, day);
        return dtFormat.format(cal.getTime());
    }
 }
