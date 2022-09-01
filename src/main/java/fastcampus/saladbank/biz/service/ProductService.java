package fastcampus.saladbank.biz.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.domain.Loan;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.biz.repository.LoanRepository;
import fastcampus.saladbank.config.LocalDateTimeSerializer;
import fastcampus.saladbank.web.dto.SearchProductForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final CardRepository cardRepository;
    private final LoanRepository loanRepository;

    public String searchProduct(SearchProductForm form) {
        if (form.getProductType().equals("대출")) {
            return searchLoan(form.getSearchKeyword());
        } else {
            return searchCard(form.getSearchKeyword());
        }
    }

    public String searchCard(String searchKeyword) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        List<Loan> loanList = loanRepository.findAllByLoanNameContainsOrLoanCompanyContainsOrTagContains(searchKeyword, searchKeyword, searchKeyword);
        return gson.toJson(loanList);
    }

    public String searchLoan(String searchKeyword) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        List<Card> cardList = cardRepository.findAllByCardNameContainsOrCardCompanyContainsOrTagContains(searchKeyword, searchKeyword, searchKeyword);
        return gson.toJson(cardList);
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
        Gson gson = new Gson();
        List<Card> cardAll = cardRepository.findAll();
        return gson.toJson(cardAll);
    }

    public String getLoanList() {
        Gson gson = new Gson();
        List<Loan> loanAll = loanRepository.findAll();
        return gson.toJson(loanAll);
    }
}
