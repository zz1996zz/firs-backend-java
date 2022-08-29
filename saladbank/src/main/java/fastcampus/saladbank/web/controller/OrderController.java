package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.OrderService;
import fastcampus.saladbank.web.dto.OrderForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/register")
    public Long save(@RequestBody OrderForm orderForm) {
        return orderService.save(orderForm);
    }
}
