package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.repository.OrderRepository;
import fastcampus.saladbank.web.dto.OrderForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public Long save(OrderForm orderForm) {
        return orderRepository.save(orderForm.toEntity()).getId();
    }
}
