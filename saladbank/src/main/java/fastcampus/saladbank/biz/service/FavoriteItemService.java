package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.FavoriteItem;
import fastcampus.saladbank.biz.repository.FavoriteItemRepository;
import fastcampus.saladbank.biz.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class FavoriteItemService {

    @Transactional
    public FavoriteItem insertFavoriteItem() {

    }
}
