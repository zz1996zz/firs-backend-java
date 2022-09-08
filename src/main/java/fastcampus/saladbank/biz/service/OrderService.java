package fastcampus.saladbank.biz.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.biz.repository.LoanRepository;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.config.LocalDateTimeSerializer;
import fastcampus.saladbank.web.dto.CardForm;
import fastcampus.saladbank.web.dto.LoanForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
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

    // 마이페이지 오더리스트 기능 미구현(고정값 리턴)
    public String getCardList() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        List<CardForm> cardList = new ArrayList<>();
        for (long i = 1; i <= 3; i++) {
            CardForm cardForm = new CardForm(cardRepository.findById((2*i)-1).orElseThrow(() -> new RuntimeException("해당 상품이 없습니다.")));
            cardList.add(cardForm);
        }
        return gson.toJson(cardList);
    }

    public String getLoanList() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        List<LoanForm> loanList = new ArrayList<>();
        for (long i = 1; i <= 3; i++) {
            LoanForm loanForm = new LoanForm(loanRepository.findById((2*i)-1).orElseThrow(() -> new RuntimeException("해당 상품이 없습니다.")));
            loanList.add(loanForm);
        }
        return gson.toJson(loanList);
    }
}
