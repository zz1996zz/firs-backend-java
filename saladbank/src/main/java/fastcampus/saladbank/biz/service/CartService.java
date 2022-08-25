package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductRepository productRepository;


}
