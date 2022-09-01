package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.OrderService;
import fastcampus.saladbank.web.argumentresolver.Login;
import fastcampus.saladbank.web.dto.MemberForm;
import fastcampus.saladbank.web.dto.OrderForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    // 주문 등록
//    @PostMapping
//    public void insertOrder(@Login MemberForm memberForm) throws Exception {
//        orderService.insertOrder(memberForm);
//    }
//
//    // 주문 수정
//    @PutMapping("/order/update/{id}")
//    public Long update(@PathVariable Long id, @RequestBody OrderForm orderForm) {
//        return orderService.update(id, orderForm);
//    }

//    // 주문 조회
//    @GetMapping("/order/view/{id}")
//    public OrderForm findById(@PathVariable Long id) {
//        return orderService.findById(id);
//    }
//
//    // 주문 삭제
//    @DeleteMapping("/order/delete/{id}")
//    public Long delete(@PathVariable Long id) {
//        orderService.delete(id);
//        return id;
//    }
}
