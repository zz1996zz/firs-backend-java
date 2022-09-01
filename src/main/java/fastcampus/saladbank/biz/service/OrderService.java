package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.CartRepository;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.biz.repository.OrderRepository;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;

    // 주문 등록
//    @Transactional
//    public void insertOrder(MemberForm memberForm) throws Exception {
//        //member 찾기
//        String username = memberForm.getUsername();
//        Member member = memberRepository.findByUsername(username).orElse(null);
//        Optional<Cart> cart = Optional.ofNullable(cartRepository.findByMember(member));
//        if(cart.isPresent()){
//            if(!cart.get().getCardList().isEmpty()) {
//                Order order = new Order(member,  "신청");
//                for (int i=0; i < cart.get().getCardList().size(); i++) {
//                    Card card = cart.get().getCardList().get(i);
//                    order.addOrderCard(card);
//                    orderRepository.save(order);
//                }
//            }
//
//            if (!cart.get().getLoanList().isEmpty()){
//                Order order = new Order(member,"신청");
//                for(int i=0; i<cart.get().getLoanList().size(); i++){
//                    Loan loan = cart.get().getLoanList().get(i);
//                    order.addOrderLoan(loan);
//                    order.addExpiryDate(loan.getPeriod());
//                    orderRepository.save(order);
//                }
//            }
//        }
//
//    }

    //주문 전체 조회
    public List getOrderList(String username) {
        Member member = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("해당 사용자가 없습니다."));
        return orderRepository.findAllByMember(member);
    }
}
