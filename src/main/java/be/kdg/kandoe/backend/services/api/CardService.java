package be.kdg.kandoe.backend.services.api;

import be.kdg.kandoe.backend.dom.Card;

import java.util.List;

/**
 * Created by J.P on 15/02/2016.
 */
public interface CardService {
    Card createCard(int user, String cardtext);

    List<Card> getCards();

    void updateCard(Card c);

    Card getCardById(Integer cardId);
}
