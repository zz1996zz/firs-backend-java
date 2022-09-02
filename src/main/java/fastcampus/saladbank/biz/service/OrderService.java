package fastcampus.saladbank.biz.service;

import com.google.gson.Gson;
import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.domain.Loan;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.biz.repository.LoanRepository;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.biz.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;
    private final LoanRepository loanRepository;

    public String getOrderList(String username) {
        StringBuilder sb = new StringBuilder();
        String cardList = getCardList();
        String loanList = getLoanList();

        Member member = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("해당 사용자가 없습니다."));

        sb.append("{\n\"userInfo\" : " + "\"" + member.getName() + "\"" + ",\n");
        sb.append("\"true\" : " + cardList + ",\n");
        sb.append("\"false\" : " + loanList + "\n}");

        return sb.toString();
    }

    public String getCardList() {
        Gson gson = new Gson();
        List<Card> cardList = new ArrayList<>();
        cardList.add(cardRepository.findById(1L).orElseThrow(() -> new RuntimeException("해당 상품이 없습니다.")));
        cardList.add(cardRepository.findById(7L).orElseThrow(() -> new RuntimeException("해당 상품이 없습니다.")));
        cardList.add(cardRepository.findById(9L).orElseThrow(() -> new RuntimeException("해당 상품이 없습니다.")));
        return gson.toJson(cardList);
    }

    public String getLoanList() {
        Gson gson = new Gson();
        List<Loan> loanList = new ArrayList<>();
        loanList.add(loanRepository.findById(3L).orElseThrow(() -> new RuntimeException("해당 상품이 없습니다.")));
        loanList.add(loanRepository.findById(5L).orElseThrow(() -> new RuntimeException("해당 상품이 없습니다.")));
        return gson.toJson(loanList);
    }
}
