package fastcampus.saladbank.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.domain.Loan;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.biz.repository.LoanRepository;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.config.LocalDateTimeSerializer;
import fastcampus.saladbank.web.dto.CardForm;
import fastcampus.saladbank.web.dto.LoanForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RecommendationProduct {

    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;
    private final CardRepository cardRepository;

    public String setInterestRateAndLimit(String username) {
        Member findMember = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("멤버를 찾지 못했습니다."));
        StringBuilder sb = new StringBuilder();
        int income = findMember.getIncome();
        sb.append(income).append(" ");
        if (findMember.getHouse()) {
            double v = ((income * 1.32) / 1000) + 2;
            String format = String.format("%.2f", v);
            sb.append(format);
        } else {
            double v = ((income * 1.32) / 1000);
            String format = String.format("%.2f", v);
            sb.append(format);
        }
        return sb.toString();
    }

    public String getRecommendationLoan(String username) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        List<LoanForm> filterLoan = new ArrayList<>();
        Member findMember = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("멤버를 찾지 못했습니다."));
        List<Loan> loanAll = loanRepository.findAll();
        for (Loan loan : loanAll) {
            if (Integer.parseInt(loan.getCreditLine()) <= findMember.getIncome()) {
                LoanForm loanForm = new LoanForm(loan);
                filterLoan.add(loanForm);
            }
        }
        if (!filterLoan.isEmpty()) {
            return gson.toJson(filterLoan);

        }
        return null;
    }

    public String getRecommendationCard(String username) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        List<CardForm> filterCard = new ArrayList<>();
        Member findMember = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("멤버를 찾지 못했습니다."));
        List<Card> cardAll = cardRepository.findAll();
        for (Card card : cardAll) {
            if (card.getTag().contains(findMember.getJob())) {
                CardForm cardForm = new CardForm(card);
                filterCard.add(cardForm);
            }
        }
        if (!filterCard.isEmpty()) {
            return gson.toJson(filterCard);
        }
        return null;
    }
}
