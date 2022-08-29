package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Order;
import fastcampus.saladbank.biz.repository.OrderRepository;
import fastcampus.saladbank.web.dto.OrderForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;


    // 주문 등록
    @Transactional
    public Long save(OrderForm orderForm) {
        return orderRepository.save(orderForm.toEntity()).getId();
    }

    // 주문 수정
    @Transactional
    public Long update(Long id, OrderForm orderForm) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 주문이 없습니다. id:" + id));

        order.update(orderForm.getApplyDate(), orderForm.getExpiryDate(), orderForm.getStatus());

        return id;
    }

    // 주문 조회
    public OrderForm findById(Long id) {
        Order entity = orderRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 주문이 없습니다. id=" + id));

        return new OrderForm(entity);
    }

    // 주문 삭제
    @Transactional
    public void delete(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 주문이 없습니다. id=" + id));

        orderRepository.delete(order);
    }
}
