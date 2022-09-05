package fastcampus.saladbank.biz.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.domain.Loan;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.biz.repository.LoanRepository;
import fastcampus.saladbank.config.LocalDateTimeSerializer;
import fastcampus.saladbank.web.dto.CardForm;
import fastcampus.saladbank.web.dto.LoanForm;
import fastcampus.saladbank.web.dto.SearchProductForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final CardRepository cardRepository;
    private final LoanRepository loanRepository;

    public String searchProduct(SearchProductForm form) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        String searchKeyword = form.getSearchKeyword();

        if (form.getProductType().equals("대출")) {
            List<LoanForm> loanForms = new ArrayList<>();
            List<Loan> loanList = loanRepository.findAllByLoanNameContainsOrLoanCompanyContainsOrTagContains(searchKeyword, searchKeyword, searchKeyword);
            for (Loan loan : loanList) {
                LoanForm loanForm = new LoanForm(loan);
                loanForms.add(loanForm);
            }
            return gson.toJson(loanForms);
        } else {
            List<CardForm> cardForms = new ArrayList<>();
            List<Card> cardList = cardRepository.findAllByCardNameContainsOrCardCompanyContainsOrTagContains(searchKeyword, searchKeyword, searchKeyword);
            for (Card card : cardList) {
                CardForm cardForm = new CardForm(card);
                cardForms.add(cardForm);
            }
            return gson.toJson(cardForms);
        }
    }

    public String getProductList() {
        String cardList = getCardList();
        String loanList = getLoanList();
        StringBuilder sb = new StringBuilder();

        sb.append("{\n\"cardList\" : " + cardList + ",\n");
        sb.append("\"loanList\" : " + loanList + "\n}");

        return sb.toString();
    }

    public String getCardList() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        List<CardForm> cardForms = new ArrayList<>();

        List<Card> cardAll = cardRepository.findAll();

        for (Card card : cardAll) {
            CardForm cardForm = new CardForm(card);
            cardForms.add(cardForm);
        }

        return gson.toJson(cardForms);
    }

    public String getLoanList() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        List<LoanForm> loanForms = new ArrayList<>();

        List<Loan> loanAll = loanRepository.findAll();

        for (Loan loan : loanAll) {
            LoanForm loanForm = new LoanForm(loan);
            loanForms.add(loanForm);
        }

        return gson.toJson(loanForms);
    }
}
