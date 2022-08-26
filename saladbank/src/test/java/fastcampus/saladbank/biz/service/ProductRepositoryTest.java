package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Product;
import fastcampus.saladbank.biz.repository.ProductRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @After
    public void cleanup() {
        productRepository.deleteAll();
    }

    @Test
    public void ProductList() {
        //given
        String productName = "우리사주 대출";
        String bank = "우리은행";
        String jobType = "행원";
        Integer loan = 40000;
        Double rate = 4.17;
        Integer period = 365;
        String tag = "우리사주 우대 대출";

        productRepository.save(Product.builder()
                .productName(productName)
                .bank(bank)
                .jobType(jobType)
                .loan(loan)
                .rate(rate)
                .period(period)
                .tag(tag)
                .build());

        //when
        List<Product> productList = productRepository.findAll();

        //then
        Product product = productList.get(0);
        assertThat(product.getProductName()).isEqualTo(productName);
        assertThat(product.getBank()).isEqualTo(bank);
        assertThat(product.getJobType()).isEqualTo(jobType);
        assertThat(product.getLoan()).isEqualTo(loan);
        assertThat(product.getRate()).isEqualTo(rate);
        assertThat(product.getPeriod()).isEqualTo(period);
        assertThat(product.getTag()).isEqualTo(tag);
    }
}
