package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Table(name = "PRODUCT")
@Entity
public class Product extends BaseTime{

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
    private Integer loan;

    @Column(name = "RATE", nullable = false)
    private double rate;

    @Column(name = "PERIOD", nullable = true)
    private Integer period;

    @Column(name = "TAG", nullable = false)
    private String tag;
}
