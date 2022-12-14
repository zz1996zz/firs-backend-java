package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.domain.Loan;
import fastcampus.saladbank.biz.service.CardService;
import fastcampus.saladbank.biz.service.LoanService;
import fastcampus.saladbank.biz.service.ProductService;
import fastcampus.saladbank.web.dto.SearchProductForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CardService cardService;
    private final LoanService loanService;

    @GetMapping
    public ResponseEntity getProducts() {
        String productList = productService.getProductList();
        return new ResponseEntity(productList, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity getProduct(@PathVariable long productId, @RequestParam String productType) {
        if (productType.equals("대출")) {
            Loan loan = loanService.getLoan(productId);
            return new ResponseEntity<Loan>(loan, HttpStatus.OK);
        } else {
            Card card = cardService.getCard(productId);
            return new ResponseEntity<Card>(card, HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity searchProduct(@ModelAttribute SearchProductForm form) {
        String s = productService.searchProduct(form);
        return new ResponseEntity(s, HttpStatus.OK);
    }
}
