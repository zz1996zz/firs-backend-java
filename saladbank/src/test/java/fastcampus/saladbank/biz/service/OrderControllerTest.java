package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Order;
import fastcampus.saladbank.biz.repository.OrderRepository;
import fastcampus.saladbank.web.dto.OrderForm;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @After
    public void tearDown() throws Exception {
        orderRepository.deleteAll();
    }

    @Test
    public void Order_등록() throws Exception {
        //given
        LocalDate applyDate = LocalDate.now();
        LocalDate expiryDate = LocalDate.now();
        String status = "신청 중";
        OrderForm orderForm = OrderForm.builder()
                .applyDate(applyDate)
                .expiryDate(expiryDate)
                .status(status)
                .build();

        String url = "http://localhost:" + port + "/order/register";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, orderForm, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Order> all = orderRepository.findAll();
        assertThat(all.get(0).getApplyDate()).isEqualTo(applyDate);
        assertThat(all.get(0).getExpiryDate()).isEqualTo(expiryDate);
        assertThat(all.get(0).getStatus()).isEqualTo(status);
    }

    @Test
    public void Order_수정() throws Exception {
        //given
        Order saveOrder = orderRepository.save(Order.builder()
                .applyDate(LocalDate.now())
                .expiryDate(LocalDate.now())
                .status("주문 완료")
                .build());

        Long updateId = saveOrder.getId();

        LocalDate expectedApplyDate = LocalDate.now().plusDays(1);
        LocalDate expectedExpiryDate = LocalDate.now().plusDays(1);
        String expectedStatus = "주문 취소";

        OrderForm orderForm = OrderForm.builder()
                .applyDate(LocalDate.from(expectedApplyDate))
                .expiryDate(LocalDate.from(expectedExpiryDate))
                .status(expectedStatus)
                .build();

        String url = "http://localhost:" + port + "/order/update/" + updateId;

        HttpEntity<OrderForm> requestEntity = new HttpEntity<>(orderForm);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Order> all = orderRepository.findAll();

        assertThat(all.get(0).getApplyDate()).isEqualTo(expectedApplyDate);
        assertThat(all.get(0).getExpiryDate()).isEqualTo(expectedExpiryDate);
        assertThat(all.get(0).getStatus()).isEqualTo(expectedStatus);

    }
}
