package be.kdg.kandoe.backend.services.impl;

import be.kdg.kandoe.backend.dom.Card;
import be.kdg.kandoe.backend.persistence.api.CardRepository;
import be.kdg.kandoe.backend.services.api.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yiua on 15/02/16.
 */
@Service("cardService")
@Transactional
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(final CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public Card createCard(int user, String name, String description) {
        Card card=new Card(name,description);
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public void updateCard(Card c) {

    }

    @Override
    public Card getCardById(Integer cardId) {
        return null;
    }

    @Override
    public List<Card> createCardsFromCSV(Integer id, String csvstring) {
        return null;
    }
}
