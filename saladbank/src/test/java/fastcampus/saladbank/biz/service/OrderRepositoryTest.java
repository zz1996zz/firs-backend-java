package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Order;
import fastcampus.saladbank.biz.repository.OrderRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @After
    public void cleanup() {
        orderRepository.deleteAll();
    }

    @Test
    public void order_불러오기() {
        //given
        LocalDate applyDate = LocalDate.now();
        LocalDate expiryDate = LocalDate.now();
        String status = "신청 중";

        orderRepository.save(Order.builder()
                .applyDate(applyDate)
                .expiryDate(expiryDate)
                .status(status)
                .build());

        //when
        List<Order> orderList = orderRepository.findAll();

        //then
        Order orders = orderList.get(0);
        assertThat(orders.getApplyDate()).isEqualTo(applyDate);
        assertThat(orders.getExpiryDate()).isEqualTo(expiryDate);
        assertThat(orders.getStatus()).isEqualTo(status);
    }
}
