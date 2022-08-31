package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public void getProducts() {
        String productList = productService.getProductList();
        log.info("productList={}", productList);
    }
}
