package fastcampus.saladbank.biz.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Getter
public class Product extends BaseTime {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "BANK", nullable = false)
    private String bank;

    @Column(name = "JOB_TYPE", nullable = false)
    private String jobType;

    @Column(name = "LOAN", nullable = false)
    private int loan;

    @Column(name = "RATE", nullable = false)
    private double rate;

    @Column(name = "PERIOD", nullable = true)
    private int period;

    @Column(name = "TAG", nullable = false)
    private String tag;
}
