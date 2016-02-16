package be.kdg.kandoe.backend.services.impl;

import be.kdg.kandoe.backend.services.api.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Yiua on 15/02/16.
 */
@Service("cardService")
@Transactional
public class CardServiceImpl implements CardService {
    @Autowired
    public CardServiceImpl() {
    }
}
